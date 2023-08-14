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

import ai.kiya.entity.BranchMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Branch implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;

	Mapper mapper = new DozerBeanMapper();
	String str = "";

	// D001003Key d001003Key=new D001003Key();
	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		BranchMst branch = null;
		Optional<BranchMst> branch123 = null;
		try {
			branch = objectMapper.readValue(masterjson.getBytes(), BranchMst.class); // object convert

			branch123 = (Optional<BranchMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, branch.getD001003Key());
			if (!branch123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(branch, branch123.get());

		return branch123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		BranchMst convertedObj = null;
		Optional<BranchMst> branch = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), BranchMst.class);

			errors = new BindException(convertedObj, "Branch");
			branch = (Optional<BranchMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD001003Key());
			if (branch.isPresent()) {
				errors.addError(new FieldError("Branch", "branchId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchCode", "branchCode can not be blank");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenantId", "tenantId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {

		return "Branch";
	}

	@Override
	public Object getById(String master, String branchId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		BranchMst branch123 = null;
		branch123 = (BranchMst) jpaRepository.getClass().getMethod("findByBranchId", String.class).invoke(jpaRepository,
				branchId);

		return branch123;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
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

		List<BranchMst> branchList = (List<BranchMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return branchList.size();
	}

	@Override
	public Class getMasterClass() {
		return BranchMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		BranchMst convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), BranchMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<BranchMst> BranchList = (List<BranchMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return BranchList;
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
		BranchMst branch = null;
		branch = objectMapper.readValue(masterjson.getBytes(), BranchMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		BranchMst branch2 = (BranchMst) jpaRepository.getClass().getMethod("findByBranchId", String.class)
				.invoke(jpaRepository, branch.getBranchId());

		return branch2;
	}

}
