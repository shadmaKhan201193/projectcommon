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

import ai.kiya.entity.UserLoginSuspenMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.key.D002046Key;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoginSuspen implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	D002046Key d002046Key = new D002046Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserLoginSuspenMst userSuspend = null;
		UserLoginSuspenMst userSuspend123 = null;
		try {
			userSuspend = objectMapper.readValue(masterjson.getBytes(), UserLoginSuspenMst.class); // object convert

			userSuspend123 = (UserLoginSuspenMst) jpaRepository.getClass().getMethod("findByLoginId", String.class)
					.invoke(jpaRepository, userSuspend.getLoginId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(userSuspend, userSuspend123);

		return userSuspend123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		UserLoginSuspenMst convertedObj = null;
		UserLoginSuspenMst role = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), UserLoginSuspenMst.class);

			errors = new BindException(convertedObj, "LoginSuspend");
			role = (UserLoginSuspenMst) jpaRepository.getClass().getMethod("findByLoginId", String.class)
					.invoke(jpaRepository, convertedObj.getLoginId());
			if (null != role) {
				errors.addError(new FieldError("UserLoginSuspend", "loginId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "loginId", "loginId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "LoginSuspen";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserLoginSuspenMst userLoginSuspend123 = null;
		userLoginSuspend123 = (UserLoginSuspenMst) jpaRepository.getClass().getMethod("findByLoginId", String.class)
				.invoke(jpaRepository, id);
		return userLoginSuspend123;
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

		List<UserLoginSuspenMst> userLoginSuspendList = (List<UserLoginSuspenMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return userLoginSuspendList.size();
	}

	@Override
	public Class getMasterClass() {

		return UserLoginSuspenMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		UserLoginSuspenMst convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), UserLoginSuspenMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<UserLoginSuspenMst> UserLoginSuspenList = (List<UserLoginSuspenMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return UserLoginSuspenList;
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
		UserLoginSuspenMst UserLoginSuspen = null;
		UserLoginSuspen = objectMapper.readValue(masterjson.getBytes(), UserLoginSuspenMst.class); // object
																											// convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserLoginSuspenMst UserLoginSuspen2 = (UserLoginSuspenMst) jpaRepository.getClass()
				.getMethod("findByLoginId", String.class).invoke(jpaRepository, UserLoginSuspen.getLoginId());

		return UserLoginSuspen2;
	}

}
