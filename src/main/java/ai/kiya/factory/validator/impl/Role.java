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

import ai.kiya.entity.RoleMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.key.RoleKey;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Role implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		RoleMst role = null;
		Optional<RoleMst> role123 = null;
		try {
			role = objectMapper.readValue(masterjson.getBytes(), RoleMst.class); // object convert

			role123 = (Optional<RoleMst>) jpaRepository.getClass().getMethod("findById", RoleKey.class)
					.invoke(jpaRepository, role.getRoleKey());
			System.out.println("hi");
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(role, role123.get());

		return role123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		RoleMst convertedObj = null;
		Optional<RoleMst> role = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), RoleMst.class);

			errors = new BindException(convertedObj, "Role");
			role = (Optional<RoleMst>) jpaRepository.getClass().getMethod("findById", RoleKey.class)
					.invoke(jpaRepository, convertedObj.getRoleKey());
			if (role.isPresent()) {
				errors.addError(new FieldError("Role", "userRoleId", "Record Already Present"));
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
		return "Role";
	}

	@Override
	public Object getById(String master, String userrRoleId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		RoleMst role = (RoleMst) jpaRepository.getClass().getMethod("findByUserRoleId", String.class)
				.invoke(jpaRepository, userrRoleId);
		return role;
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

		List<RoleMst> roleList = (List<RoleMst>) jpaRepository.getClass().getMethod("findByAuthStatus", String.class)
				.invoke(jpaRepository, status);

		return roleList.size();
	}

	@Override
	public Class getMasterClass() {
		return RoleMst.class;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return null;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		RoleMst convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), RoleMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<RoleMst> RoleList = (List<RoleMst>) jpaRepository.getClass()
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
		RoleMst role = null;
		role = objectMapper.readValue(masterjson.getBytes(), RoleMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		RoleMst role2 = (RoleMst) jpaRepository.getClass().getMethod("findByUserRoleId", String.class)
				.invoke(jpaRepository, role.getUserRoleId());

		return role2;
	}

}
