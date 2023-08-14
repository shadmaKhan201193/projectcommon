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

import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.VillageMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Village implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// D002043Key d002043Key=new D002043Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		VillageMst village = null;
		Optional<VillageMst> village123 = null;
		try {
			village = objectMapper.readValue(masterjson.getBytes(), VillageMst.class); // object convert

			village123 = (Optional<VillageMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, village.getKey());
			if (!village123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		mapper.map(village, village123.get());

		return village123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		VillageMst convertedObj = null;
		Optional<VillageMst> village = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), VillageMst.class);

			errors = new BindException(convertedObj, "Village");
			village = (Optional<VillageMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getKey());
			if (village.isPresent()) {
				errors.addError(new FieldError("Village", "villageCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "villageCode", "villageCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Village";
	}

	@Override
	public Object getById(String master, String villageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		VillageMst village123 = null;
		village123 = (VillageMst) jpaRepository.getClass().getMethod("findByVillageCode", String.class)
				.invoke(jpaRepository, villageCode);

		return village123;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return null;
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

		List<VillageMst> villageMsts = (List<VillageMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return villageMsts.size();
	}

	@Override
	public Class getMasterClass() {
		return VillageMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {

		VillageMst convertedObj = null;
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), VillageMst.class);

		return convertedObj;

	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<VillageMst> VillageList = (List<VillageMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return VillageList;
	}

	@Override
	public Object getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception {
		return null;
	}

	@Override
	public Object getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String languageCode) throws Exception {
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
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<VillageMst> VillageList = (List<VillageMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatusAndCountryAndStateAndCityAndLanguage", Integer.class,
						Integer.class, String.class, String.class, String.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, countryCode, stateCode, cityCode, languageCode);
		return VillageList;
	}

	@Override
	public Object getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		VillageMst village = null;
		village = objectMapper.readValue(masterjson.getBytes(), VillageMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		VillageMst village2 = (VillageMst) jpaRepository.getClass().getMethod("findByVillageCode", String.class)
				.invoke(jpaRepository, village.getVillageCode());

		return village2;
	}

}
