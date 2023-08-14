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

import ai.kiya.entity.ResetPasswordMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ResetPassword implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// D045947Key d045947Key=new D045947Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ResetPasswordMst resetPass = null;
		ResetPasswordMst resetPass123 = null;
		try {
			resetPass = objectMapper.readValue(masterjson.getBytes(), ResetPasswordMst.class); // object convert

			resetPass123 = (ResetPasswordMst) jpaRepository.getClass().getMethod("findByUserLoginId", String.class)
					.invoke(jpaRepository, resetPass.getUserLoginId());
			System.out.println("hi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(resetPass, resetPass123);

		return resetPass123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		ResetPasswordMst convertedObj = null;
		ResetPasswordMst resetPass = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), ResetPasswordMst.class);

			errors = new BindException(convertedObj, "ResetPassword");
			resetPass = (ResetPasswordMst) jpaRepository.getClass().getMethod("findByUserLoginId", String.class)
					.invoke(jpaRepository, convertedObj.getUserLoginId());
			if (null != resetPass) {
				errors.addError(new FieldError("ResetPassword", "userLoginId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userLoginId", "userLoginId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "ResetPassword";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ResetPasswordMst resetPass123 = null;
		resetPass123 = (ResetPasswordMst) jpaRepository.getClass().getMethod("findById", String.class)
				.invoke(jpaRepository, id);

		return resetPass123;
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
		List<ResetPasswordMst> resetPassList = (List<ResetPasswordMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return resetPassList.size();
	}

	@Override
	public Class getMasterClass() {
		return ResetPasswordMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		ResetPasswordMst convertedObj = null;
																						// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), ResetPasswordMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<ResetPasswordMst> ResetPasswordList = (List<ResetPasswordMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return ResetPasswordList;
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
		ResetPasswordMst resetPassword = null;
		resetPassword = objectMapper.readValue(masterjson.getBytes(), ResetPasswordMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ResetPasswordMst resetPassword2 = (ResetPasswordMst) jpaRepository.getClass().getMethod("findById", String.class)
				.invoke(jpaRepository, resetPassword.getId());

		return resetPassword2;
	}

	
}
