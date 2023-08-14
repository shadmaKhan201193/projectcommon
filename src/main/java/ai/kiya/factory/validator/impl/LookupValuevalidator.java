package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.List;

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

import ai.kiya.entity.LookupValue;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class LookupValuevalidator implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// RoleKey roleKey=new RoleKey();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		LookupValue lookupValue = null;
		LookupValue lookupValue123 = null;
		try {
			lookupValue = objectMapper.readValue(masterjson.getBytes(), LookupValue.class); // object convert

			lookupValue123 = (LookupValue) jpaRepository.getClass()
					.getMethod("findByLookupCodeAndLanguageCodeAndTenantIdAndLookupValueCode", String.class,
							String.class, Integer.class, String.class)
					.invoke(jpaRepository, lookupValue.getLookupCode(), lookupValue.getLanguageCode(),
							lookupValue.getTenantId(), lookupValue.getLookupValueCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		mapper.map(lookupValue, lookupValue123);
		return lookupValue123;

	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		LookupValue convertedObj = null;
		LookupValue lookupValue = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), LookupValue.class);

			errors = new BindException(convertedObj, "LookupValue");
			lookupValue = (LookupValue) jpaRepository.getClass().getMethod("findByLookupCode", String.class)
					.invoke(jpaRepository, convertedObj.getLookupCode());

			if (null != lookupValue) {
				errors.addError(new FieldError("LookupValue", "lookupCode", "Record Already Present"));
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
		return "LookupValue";
	}

	@Override
	public Object getById(String master, String lookupCode) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<LookupValue> lookupValue = (List<LookupValue>) jpaRepository.getClass()
				.getMethod("findByLookupCode", String.class).invoke(jpaRepository, lookupCode);
		return lookupValue;
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
		List<LookupValue> lookupValueList = (List<LookupValue>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return lookupValueList.size();
	}

	@Override
	public Class getMasterClass() {
		return LookupValuevalidator.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		LookupValue convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), LookupValue.class);
		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<LookupValue> lookupValueList = (List<LookupValue>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode", Integer.class, Integer.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus,languageCode);
		return lookupValueList;
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
		// TODO Auto-generated method stub
		return null;
	}


}
