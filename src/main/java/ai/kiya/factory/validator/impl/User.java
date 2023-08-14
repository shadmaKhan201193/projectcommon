package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.dto.AddressVO;
import ai.kiya.dto.UserBranchMapVO;
import ai.kiya.dto.UserBranchRoleMapVO;
import ai.kiya.dto.UserByTenantBranchRoleCodeVO;
import ai.kiya.dto.UserVO;
import ai.kiya.entity.Address;
import ai.kiya.entity.EmployeeMst;
import ai.kiya.entity.UserBranchMap;
import ai.kiya.entity.UserBranch_RoleMap;
import ai.kiya.entity.UserMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.omni.OmniConstants;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class User implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;
	String str = "";
	Object masterObj = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserMst user = null;
		Optional<UserMst> user123 = null;

		try {
			user = objectMapper.readValue(masterjson.getBytes(), UserMst.class); // object convert

			JsonNode parent = objectMapper.readTree(masterjson);

			String loginId = user.getLoginId();

			JsonNode array = parent.get("userBranchMaps");
			user.getUserBranchMaps().forEach(use1 -> {
				use1.setLoginId(loginId);
				use1.setBranchCode(Integer.valueOf(array.get(0).get("branchCode").asText()));
			});
			user123 = (Optional<UserMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, user.getD002001Key());
			if (!user123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
			// user123 = (UserMst) jpaRepository.getClass().getMethod("findByD002001Key",
			// D002001Key.class).invoke(jpaRepository,d002001Key );

		} catch (IOException e) {
			e.printStackTrace();
		}

		UserMst masterObj = converterClass.childTable(master, user, user123.get());

		BeanMappingBuilder builderMinusId = new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(EmployeeMst.class, EmployeeMst.class).exclude("version").exclude("userAddresses")
						.exclude("userBranchMaps");

			}
		};
		Mapper mapper = new DozerBeanMapper();
		((DozerBeanMapper) mapper).addMapping(builderMinusId);
		mapper.map(user, masterObj);
		masterObj.setUserBaseBranchCode(user.getUserBaseBranchCode());
		return masterObj;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		UserMst convertedObj = null;
		Optional<UserMst> user = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), UserMst.class);

			errors = new BindException(convertedObj, "User");
			user = (Optional<UserMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD002001Key());
			if (user.isPresent()) {
				errors.addError(new FieldError("User", "loginId", "Record Already Present"));
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
		return "User";
	}

	@Override
	public Object getById(String master, String userId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserMst user = (UserMst) jpaRepository.getClass().getMethod("findByUserId", String.class).invoke(jpaRepository,
				userId);
		return user;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<UserMst> userList = (List<UserMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, 1, "A");
		List<UserMst> userRetList = new ArrayList<>();
		userList.stream().forEach(user -> {
			if (user.getRoleCode().equalsIgnoreCase(roleCode)) {
				userRetList.add(user);
			}
		});

		return userRetList;
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

		List<UserMst> userList = (List<UserMst>) jpaRepository.getClass().getMethod("findByAuthStatus", String.class)
				.invoke(jpaRepository, status);

		return userList.size();
	}

	@Override
	public Class getMasterClass() {

		return UserMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		UserVO convertedObj = null;
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), UserVO.class);

		UserMst user = new UserMst();
		List<Address> userNewAddresses = new ArrayList<Address>();
		List<AddressVO> userOldAddresses = convertedObj.getUserAddresses();
		if (null != userOldAddresses && userOldAddresses.size() > 0) {
			for (AddressVO address : userOldAddresses) {
				Address add = new Address();
				BeanUtils.copyProperties(address, add);
				userNewAddresses.add(add);
			}
		}

		List<UserBranchMapVO> userBranchOldMaps = convertedObj.getUserBranchMaps();
		List<UserBranchMap> userBranchNewMaps = new ArrayList<>();

		if (null != userBranchOldMaps && userBranchOldMaps.size() > 0) {
			for (UserBranchMapVO branchMap : userBranchOldMaps) {
				UserBranchMap userBranchMap = new UserBranchMap();
				userBranchMap.setBranchCode(branchMap.getBranchCode());
				userBranchMap.setLoginId(convertedObj.getLoginId());
				userBranchMap.setTenantId(convertedObj.getTenantId());
				Calendar cal = Calendar.getInstance();
				Date createdDate = cal.getTime();
				userBranchMap.setCreatedDate(createdDate);
				userBranchMap.setCreatedTime(createdDate);
				userBranchMap.setLastModifiedDate(createdDate);
				userBranchMap.setLastModifiedTime(createdDate);
				List<UserBranchRoleMapVO> userBranchRoleOldMaps = branchMap.getUserBranchRoleMaps();
				List<UserBranch_RoleMap> userBranchRoleNewMaps = new ArrayList<>();

				if (null != userBranchRoleOldMaps && userBranchRoleOldMaps.size() > 0) {
					for (UserBranchRoleMapVO userBranchRoleMap : userBranchRoleOldMaps) {
						UserBranch_RoleMap userBranch_RoleMap = new UserBranch_RoleMap();
						userBranch_RoleMap.setRoleCode(userBranchRoleMap.getRoleCode());
						userBranch_RoleMap.setTenantId(convertedObj.getTenantId());
						userBranch_RoleMap.setUserBranchMap(userBranchMap);
						userBranchRoleNewMaps.add(userBranch_RoleMap);
					}
				}
				if (null != userBranchRoleNewMaps && userBranchRoleNewMaps.size() > 0) {
					userBranchMap.setUserBranch_RoleMaps(userBranchRoleNewMaps);
				}
				userBranchNewMaps.add(userBranchMap);
			}
		}
		BeanUtils.copyProperties(convertedObj, user, "userAddresses", "userBranchMaps");
		user.setUserAddresses(userNewAddresses);
		user.setUserBranchMaps(userBranchNewMaps);

		return user;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<UserMst> UserList = (List<UserMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return UserList;
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
		UserMst userMst = (UserMst) obj;

		List<UserBranchMap> userBranchMaps = (List<UserBranchMap>) userMst.getUserBranchMaps();
		if (null != userBranchMaps && userBranchMaps.size() > 0) {
			userBranchMaps.forEach(branchMap -> {
				if (mode == OmniConstants.DELETE) {
					branchMap.setLastModifiedBy(userMst.getLastModifiedBy());
					branchMap.setLastModifiedDate(userMst.getLastModifiedDate());
					branchMap.setLastModifiedTime(userMst.getLastModifiedTime());
					branchMap.setAuthStatus(userMst.getAuthStatus());
					branchMap.setIsActive(userMst.getIsActive());
				}
				if (mode == OmniConstants.AUTH_AUTHORIZED) {
					branchMap.setLastModifiedBy(userMst.getLastModifiedBy());
					branchMap.setLastModifiedDate(userMst.getLastModifiedDate());
					branchMap.setLastModifiedTime(userMst.getLastModifiedTime());
					branchMap.setAuthStatus(userMst.getAuthStatus());
					branchMap.setIsActive(userMst.getIsActive());
				}
				if (mode == OmniConstants.CREATE) {
					branchMap.setCreatedBy(userMst.getCreatedBy());
					branchMap.setCreatedDate(userMst.getCreatedDate());
					branchMap.setCreatedTime(userMst.getCreatedTime());
					branchMap.setLastModifiedBy(userMst.getLastModifiedBy());
					branchMap.setLastModifiedDate(userMst.getLastModifiedDate());
					branchMap.setLastModifiedTime(userMst.getLastModifiedTime());
					branchMap.setAuthStatus(userMst.getAuthStatus());
					branchMap.setIsActive(userMst.getIsActive());
					// lookupValue.setDeprecated(Boolean.FALSE);
				}
				if (mode == OmniConstants.UPDATE) {
					branchMap.setLastModifiedBy(userMst.getLastModifiedBy());
					branchMap.setLastModifiedDate(userMst.getLastModifiedDate());
					branchMap.setLastModifiedTime(userMst.getLastModifiedTime());
					branchMap.setAuthStatus(userMst.getAuthStatus());
					branchMap.setIsActive(userMst.getIsActive());
				}

				List<UserBranch_RoleMap> usrBrRoleMapList = (List<UserBranch_RoleMap>) branchMap
						.getUserBranch_RoleMaps();
				if (null != usrBrRoleMapList && usrBrRoleMapList.size() > 0) {
					usrBrRoleMapList.forEach(role -> {
						if (mode == OmniConstants.DELETE) {
							role.setLastModifiedBy(userMst.getLastModifiedBy());
							role.setLastModifiedDate(userMst.getLastModifiedDate());
							role.setLastModifiedTime(userMst.getLastModifiedTime());
							role.setAuthStatus(userMst.getAuthStatus());
							role.setIsActive(userMst.getIsActive());
						}
						if (mode == OmniConstants.AUTH_AUTHORIZED) {
							role.setLastModifiedBy(userMst.getLastModifiedBy());
							role.setLastModifiedDate(userMst.getLastModifiedDate());
							role.setLastModifiedTime(userMst.getLastModifiedTime());
							role.setAuthStatus(userMst.getAuthStatus());
							role.setIsActive(userMst.getIsActive());
						}
						if (mode == OmniConstants.CREATE) {
							role.setCreatedBy(userMst.getCreatedBy());
							role.setCreatedDate(userMst.getCreatedDate());
							role.setCreatedTime(userMst.getCreatedTime());
							role.setLastModifiedBy(userMst.getLastModifiedBy());
							role.setLastModifiedDate(userMst.getLastModifiedDate());
							role.setLastModifiedTime(userMst.getLastModifiedTime());
							role.setAuthStatus(userMst.getAuthStatus());
							role.setIsActive(userMst.getIsActive());
							// lookupValue.setDeprecated(Boolean.FALSE);
						}
						if (mode == OmniConstants.UPDATE) {
							role.setLastModifiedBy(userMst.getLastModifiedBy());
							role.setLastModifiedDate(userMst.getLastModifiedDate());
							role.setLastModifiedTime(userMst.getLastModifiedTime());
							role.setAuthStatus(userMst.getAuthStatus());
							role.setIsActive(userMst.getIsActive());
						}
					});
				}

			});
		}
		return userMst;
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
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<UserMst> userList = (List<UserMst>) jpaRepository
				.getClass().getMethod("findByTenantIdAndIsActiveAndAuthStatusAndUserBranchMapsBranchCode",
						Integer.class, Integer.class, String.class, Integer.class)
				.invoke(jpaRepository, tenantId, 1, "A", branchCode);

		List<UserMst> userRetList = new ArrayList<>();
		if (null != userList && userList.size() > 0) {

			for (UserMst user : userList) {
				List<UserBranchMap> userBranchMaps = (List<UserBranchMap>) user.getUserBranchMaps();
				if (null != userBranchMaps && userBranchMaps.size() > 0) {
					aa: for (UserBranchMap userBranch : userBranchMaps) {
						List<UserBranch_RoleMap> userBranch_RoleMaps = new ArrayList(
								userBranch.getUserBranch_RoleMaps());
						if (null != userBranch_RoleMaps && userBranch_RoleMaps.size() > 0) {
							for (UserBranch_RoleMap roles : userBranch_RoleMaps) {
								if (roles.getRoleCode().equalsIgnoreCase(roleCode)) {
									UserBranch_RoleMap userBranch_RoleMap = new UserBranch_RoleMap();
									BeanUtils.copyProperties(roles, userBranch_RoleMap);

									Collection<UserBranch_RoleMap> usrBranch_RoleMaps = new ArrayList<UserBranch_RoleMap>();
									usrBranch_RoleMaps.add(userBranch_RoleMap);

									UserBranchMap userBranchMap = new UserBranchMap();
									BeanUtils.copyProperties(userBranch, userBranchMap, "userBranch_RoleMaps");
									userBranchMap.setUserBranch_RoleMaps(usrBranch_RoleMaps);

									UserMst user1 = new UserMst();
									BeanUtils.copyProperties(user, user1, "userBranchMaps");
									user1.setUserBranchMaps(userBranchMaps);

									userRetList.add(user1);
									break aa;
								}
							}
						}
					}
				}
			}
		}
		List<UserByTenantBranchRoleCodeVO> userByTenantBranchRoleCodeVOList = new ArrayList<>();

		if (null != userRetList && userRetList.size() > 0) {
			for (UserMst user : userRetList) {
				UserByTenantBranchRoleCodeVO userVO = new UserByTenantBranchRoleCodeVO();
				BeanUtils.copyProperties(user, userVO);
				userVO.setRoleCode(roleCode);
				userByTenantBranchRoleCodeVOList.add(userVO);
			}
		}
		return userByTenantBranchRoleCodeVOList;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		UserMst user = null;
		user = objectMapper.readValue(masterjson.getBytes(), UserMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		UserMst user2 = (UserMst) jpaRepository.getClass().getMethod("findByUserId", String.class).invoke(jpaRepository,
				user.getUserId());

		return user2;
	}

}
