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

import ai.kiya.entity.UserRoleMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
public class UserRole implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@SuppressWarnings("unchecked")
	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserRoleMst UserRole = null;
		Optional<UserRoleMst> UserRole123 = null;
		try {
			UserRole = objectMapper.readValue(masterjson.getBytes(), UserRoleMst.class); // object convert
			UserRole123 = (Optional<UserRoleMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, UserRole.getUserRoleId());
			if (!UserRole123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(UserRole, UserRole123.get());
		return UserRole123.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		UserRoleMst convertedObj = null;
		Optional<UserRoleMst> UserRole = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), UserRoleMst.class);
			errors = new BindException(convertedObj, "UserRole");
			UserRole = (Optional<UserRoleMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD002005Key());

			if (UserRole.isPresent()) {
				errors.addError(new FieldError("UserRole", "userRoleId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userRoleId", "userRoleId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "UserRole";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserRoleMst userRole = (UserRoleMst) jpaRepository.getClass().getMethod("findByUserRoleId", String.class)
				.invoke(jpaRepository, id);
		return userRole;
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
		List<UserRoleMst> userRoleList = (List<UserRoleMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return userRoleList.size();
	}

	@Override
	public Class getMasterClass() {
		return UserRoleMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		UserRoleMst convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), UserRoleMst.class);
		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<UserRoleMst> RoleList = (List<UserRoleMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return RoleList;
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
		UserRoleMst userRole = null;
		userRole = objectMapper.readValue(masterjson.getBytes(), UserRoleMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserRoleMst userRole2 = (UserRoleMst) jpaRepository.getClass().getMethod("findByUserRoleId", String.class)
				.invoke(jpaRepository, userRole.getUserRoleId());

		return userRole2;
	}

}
