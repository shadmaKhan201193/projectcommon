package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.CityMst2;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class City implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;

	Mapper mapper = new DozerBeanMapper();

	@Override
	public String getMasterType() {

		return "City";
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		CityMst2 convertedObj = null;
		Optional<CityMst2> city = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), CityMst2.class);
			errors = new BindException(convertedObj, "City");
			city = (Optional<CityMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD009500Key());
			if (city.isPresent()) {
				errors.addError(new FieldError("City", "numCityCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numCityCode", "numCityCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;

	}

	@Override
	public Object getByIdForUpdate(String master, String str) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CityMst2 city = null;
		Optional<CityMst2> city123 = null;
		try {
			city = objectMapper.readValue(str.getBytes(), CityMst2.class);
			city123 = (Optional<CityMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, city.getD009500Key());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String id = city123.getNumCityCode();
		mapper.map(city, city123.get());
//		city123.setNumCityCode(id);
		return city123.get();

	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CityMst2 city = (CityMst2) jpaRepository.getClass().getMethod("findByNumCityCode", String.class)
				.invoke(jpaRepository, id);

		return city;
	}

	@Autowired
	public Class getMasterClass() {
		return CityMst2.class;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		if (status == null) {
			return jpaRepository.findAll();
		} else {
			return jpaRepository.getClass().getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		}
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<CityMst2> cityList = (List<CityMst2>) jpaRepository.getClass().getMethod("findByAuthStatus", String.class)
				.invoke(jpaRepository, status);

		return cityList.size();
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		Object masterObj = "";
		masterObj = converterClass.getJsonToObject(getMasterClass(), masterjson);
		return masterObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<CityMst2> cityList = (List<CityMst2>) jpaRepository
				.getClass().getMethod("findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode", Integer.class,
						Integer.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, languageCode);
		return cityList;
	}

	@Override
	public Object getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String languageCode) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<CityMst2> cityList = (List<CityMst2>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatusAndCountryCodeAndStateCodeAndLanguageCode",
						Integer.class, Integer.class, String.class, String.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, countryCode, stateCode, languageCode);
		return cityList;
	}

	@Override
	public Object setChildkeyValue(Object obj, String mode) throws Exception {
		return obj;
	}

	@Override
	public Object getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String cityCode, String languageCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		CityMst2 city = null;
		city = objectMapper.readValue(masterjson.getBytes(), CityMst2.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CityMst2 city2 = (CityMst2) jpaRepository.getClass().getMethod("findByNumCityCode", String.class)
				.invoke(jpaRepository, city.getNumCityCode());

		return city2;
	}

}
