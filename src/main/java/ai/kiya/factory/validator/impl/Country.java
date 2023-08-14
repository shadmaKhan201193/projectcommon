package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.CountryMst2;
import ai.kiya.factory.CommonValidator;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Country implements MasterValidator, CommonValidator {
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;

	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@Override
	public String getMasterType() {

		return "Country";
	}

	@Autowired
	public Class getMasterClass() {
		return CountryMst2.class;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {

		CountryMst2 convertedObj = null;
		Optional<CountryMst2> country = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), CountryMst2.class);
			errors = new BindException(convertedObj, "Country");
			country = (Optional<CountryMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD009504Key());
			if (country.isPresent()) {
				errors.addError(new FieldError("Country", "countryCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "countryCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;

	}

	@Override
	public Object getByIdForUpdate(String master, String strjson) throws Exception {
//		return str;
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CountryMst2 country = null;
		Optional<CountryMst2> country123 = null;
		try {
			country = objectMapper.readValue(strjson.getBytes(), CountryMst2.class); // object convert
			country123 = (Optional<CountryMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, country.getD009504Key());
			if (!country123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// country123.setId(country123.getId());
//		String id = country123.getCountryCode();
		mapper.map(country, country123.get());
//		country123.setCountryCode(id);

		return country123.get();
	}

	@Override
	public Object getById(String master, String countryCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CountryMst2 country = (CountryMst2) jpaRepository.getClass().getMethod("findByCountryCode", String.class)
				.invoke(jpaRepository, countryCode);

		return country;
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

		List<CountryMst2> countryList = (List<CountryMst2>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return countryList.size();
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

		List<CountryMst2> countryList = (List<CountryMst2>) jpaRepository
				.getClass().getMethod("findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode", Integer.class,
						Integer.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, languageCode);
		return countryList;
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
		// TODO Auto-generated method stub
		return null;
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
		CountryMst2 country = null;
		country = objectMapper.readValue(masterjson.getBytes(), CountryMst2.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CountryMst2 country2 = (CountryMst2) jpaRepository.getClass().getMethod("findByCountryCode", String.class)
				.invoke(jpaRepository, country.getCountryCode());

		return country2;
	}

	@Override
	public Object getBySearchDetails(String master, Map<String, String> params) throws Exception {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CountryMst2> criteriaQuery = builder.createQuery(CountryMst2.class);
		Root<CountryMst2> root = criteriaQuery.from(CountryMst2.class);
		String fieldName = "";
		String fieldValue = "";
		for (Map.Entry<String, String> entry : params.entrySet()) {
			fieldName = entry.getKey();
			fieldValue = entry.getValue();
		}

		List<CountryMst2> results;
		if (fieldName == null) {
			throw new IllegalArgumentException(" Attribute name is missing");
		}
		try {
			Predicate predicate = builder.equal(root.get(fieldName), fieldValue);
			criteriaQuery.where(predicate);

			TypedQuery<CountryMst2> query = entityManager.createQuery(criteriaQuery);
			results = query.getResultList();

		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Invalid attribute name: " + fieldName);
		}

		return results;
	}

}
