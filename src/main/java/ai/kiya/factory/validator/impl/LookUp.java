package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.LookupCode;
import ai.kiya.entity.LookupValue;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.omni.OmniConstants;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LookUp implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;
	String str = "";
	// D001001Key d001001Key=new D001001Key();
	Object masterObj = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		LookupCode lookUp = null;
		Optional<LookupCode> lookUp123 = null;

		try {
			lookUp = objectMapper.readValue(masterjson.getBytes(), LookupCode.class); // object convert

			lookUp123 = (Optional<LookupCode>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, lookUp.getD001001Key());
			if (!lookUp123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		LookupCode masterObj = converterClass.childTable(master, lookUp, lookUp123.get());

		BeanMappingBuilder builderMinusId = new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(LookupCode.class, LookupCode.class).exclude("version").exclude("lookupValues");

			}
		};
		Mapper mapper = new DozerBeanMapper();
		((DozerBeanMapper) mapper).addMapping(builderMinusId);
		mapper.map(lookUp, masterObj);
		masterObj.setLookupValues(lookUp.getLookupValues());
		return masterObj;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		LookupCode convertedObj = null;
		Optional<LookupCode> lookup = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), LookupCode.class);

			errors = new BindException(convertedObj, "LookUp");
			lookup = (Optional<LookupCode>) jpaRepository.getClass().getMethod("findByLookupCode", Object.class)
					.invoke(jpaRepository, convertedObj.getD001001Key());
			if (lookup.isPresent()) {
				errors.addError(new FieldError("LookUp", "lookupCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lookupCode", "lookupCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "LookUp";
	}

	@Override
	public Object getById(String master, String lookupCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		LookupCode lookUp = (LookupCode) jpaRepository.getClass().getMethod("findByLookupCode", String.class)
				.invoke(jpaRepository, lookupCode);

		return lookUp;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<LookupCode> lookUpList = (List<LookupCode>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return lookUpList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<LookupCode> lookUpList = (List<LookupCode>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return lookUpList.size();
	}

	@Override
	public Class getMasterClass() {
		return LookupCode.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		LookupCode convertedObj = null;
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), LookupCode.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<LookupCode> LookupCodeList = (List<LookupCode>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		List<LookupCode> lkupCodeList = new ArrayList<>();

		if (null != LookupCodeList && LookupCodeList.size() > 0) {
			LookupCodeList.forEach(lookupCode -> {
				List<LookupValue> lookupValues = lookupCode.getLookupValues();
				List<LookupValue> lkupValueList = new ArrayList<>();
				if (null != lookupValues && lookupValues.size() > 0) {
					lookupValues.forEach(lookupValue -> {
						if (lookupValue.getLanguageCode().equalsIgnoreCase(languageCode)) {
							lkupValueList.add(lookupValue);
						}
						// Mahesh
					});
				}
				if (null != lkupValueList && lkupValueList.size() > 0) {
					LookupCode lkupCode = new LookupCode();
					BeanUtils.copyProperties(lookupCode, lkupCode, "lookupValues");
					lkupCode.setLookupValues(lkupValueList);
					lkupCodeList.add(lkupCode);
				}
			});
		}
		return lkupCodeList;
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
		LookupCode lkCode = (LookupCode) obj;
		List<LookupValue> lookupValues = lkCode.getLookupValues();
		if (null != lookupValues && lookupValues.size() > 0) {
			lookupValues.forEach(lookupValue -> {
				if (mode == OmniConstants.DELETE) {
					lookupValue.setLastModifiedBy(lkCode.getLastModifiedBy());
					lookupValue.setLastModifiedDate(lkCode.getLastModifiedDate());
					lookupValue.setLastModifiedTime(lkCode.getLastModifiedTime());
					lookupValue.setAuthStatus(lkCode.getAuthStatus());
					lookupValue.setIsActive(lkCode.getIsActive());
				}
				if (mode == OmniConstants.AUTH_AUTHORIZED) {
					lookupValue.setLastModifiedBy(lkCode.getLastModifiedBy());
					lookupValue.setLastModifiedDate(lkCode.getLastModifiedDate());
					lookupValue.setLastModifiedTime(lkCode.getLastModifiedTime());
					lookupValue.setAuthStatus(lkCode.getAuthStatus());
					lookupValue.setIsActive(lkCode.getIsActive());
				}
				if (mode == OmniConstants.CREATE) {
					lookupValue.setCreatedBy(lkCode.getCreatedBy());
					lookupValue.setCreatedDate(lkCode.getCreatedDate());
					lookupValue.setCreatedTime(lkCode.getCreatedTime());
					lookupValue.setLastModifiedBy(lkCode.getLastModifiedBy());
					lookupValue.setLastModifiedDate(lkCode.getLastModifiedDate());
					lookupValue.setLastModifiedTime(lkCode.getLastModifiedTime());
					lookupValue.setAuthStatus(lkCode.getAuthStatus());
					lookupValue.setIsActive(lkCode.getIsActive());
					// lookupValue.setDeprecated(Boolean.FALSE);
				}
				if (mode == OmniConstants.UPDATE) {
					lookupValue.setLastModifiedBy(lkCode.getLastModifiedBy());
					lookupValue.setLastModifiedDate(lkCode.getLastModifiedDate());
					lookupValue.setLastModifiedTime(lkCode.getLastModifiedTime());
					lookupValue.setAuthStatus(lkCode.getAuthStatus());
					lookupValue.setIsActive(lkCode.getIsActive());
				}
			});
		}
		return lkCode;
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
		LookupCode lookupCode = null;
		lookupCode = objectMapper.readValue(masterjson.getBytes(), LookupCode.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		LookupCode lookupCode2 = (LookupCode) jpaRepository.getClass().getMethod("findByLookupCode", String.class)
				.invoke(jpaRepository, lookupCode.getLookupCode());

		return lookupCode2;
	}

}
