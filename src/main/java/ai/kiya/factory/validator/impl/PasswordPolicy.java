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

import ai.kiya.entity.PasswordPolicyMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class PasswordPolicy implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
//	D009501Key d009501Key=new D009501Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PasswordPolicyMst passPolicy = null;
		PasswordPolicyMst passPolicy123 = null;
		try {
			passPolicy = objectMapper.readValue(masterjson.getBytes(), PasswordPolicyMst.class); // object convert

			passPolicy123 = (PasswordPolicyMst) jpaRepository.getClass().getMethod("findById", String.class)
					.invoke(jpaRepository, passPolicy.getId());
			System.out.println("hi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(passPolicy, passPolicy123);

		return passPolicy123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		PasswordPolicyMst convertedObj = null;
		PasswordPolicyMst pssPolicy = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), PasswordPolicyMst.class);

			errors = new BindException(convertedObj, "PasswordPolicy");
			pssPolicy = (PasswordPolicyMst) jpaRepository.getClass().getMethod("findById", String.class)
					.invoke(jpaRepository, convertedObj.getId());
			if (null != pssPolicy) {
				errors.addError(new FieldError("PasswordPolicy", "id", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "PasswordPolicy";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PasswordPolicyMst passPolicy123 = null;
		passPolicy123 = (PasswordPolicyMst) jpaRepository.getClass().getMethod("findById", String.class)
				.invoke(jpaRepository, id);

		return passPolicy123;
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
		List<PasswordPolicyMst> passPolicyList = (List<PasswordPolicyMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return passPolicyList.size();
	}

	@Override
	public Class getMasterClass() {
		return PasswordPolicyMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		PasswordPolicyMst convertedObj = null;
																						// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), PasswordPolicyMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<PasswordPolicyMst> PasswordPolicyList = (List<PasswordPolicyMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return PasswordPolicyList;
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
		return null;
	}

	@Override
	public Object getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		PasswordPolicyMst passwordPolicy = null;
		passwordPolicy = objectMapper.readValue(masterjson.getBytes(), PasswordPolicyMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PasswordPolicyMst passwordPolicy2 = (PasswordPolicyMst) jpaRepository.getClass().getMethod("findById", String.class)
				.invoke(jpaRepository, passwordPolicy.getId());

		return passwordPolicy2;
	}

	
}
