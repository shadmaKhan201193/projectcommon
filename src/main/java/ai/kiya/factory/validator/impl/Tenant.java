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

import ai.kiya.entity.TenantMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
public class Tenant implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;

	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@SuppressWarnings("unchecked")
	@Override
	public Object getByIdForUpdate(String master, String strjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		TenantMst tenantMst = null;
		Optional<TenantMst> tenantMst123 = null;
		try {
			tenantMst = objectMapper.readValue(strjson.getBytes(), TenantMst.class); // object convert
			tenantMst123 = (Optional<TenantMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, tenantMst.getD001008Key());
			if (!tenantMst123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Integer id = tenantMst123.getTenantId();
		mapper.map(tenantMst, tenantMst123.get());
//		tenantMst123.setTenantId(id);

		return tenantMst123.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		TenantMst convertedObj = null;
		Optional<TenantMst> Tenantmst = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), TenantMst.class);
			errors = new BindException(convertedObj, "TenantMst");
			Tenantmst = (Optional<TenantMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD001008Key());
			if (Tenantmst.isPresent()) {
				errors.addError(new FieldError("TenantMst", "tenantId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tenantId", "tenantId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Tenant";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		Integer tenentId = Integer.valueOf(id);
		TenantMst tenantmst = (TenantMst) jpaRepository.getClass().getMethod("findByTenantId", Integer.class)
				.invoke(jpaRepository, tenentId);
		return tenantmst;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<TenantMst> tenantList = (List<TenantMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return tenantList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<TenantMst> tanantList = (List<TenantMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return tanantList.size();
	}

	@Override
	@Autowired
	public Class getMasterClass() {
		return TenantMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		Object masterObj = "";
		masterObj = converterClass.getJsonToObject(getMasterClass(), masterjson);
		return masterObj;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return null;
	}

	@Override
	public Object setChildkeyValue(Object obj, String mode) throws Exception {
		return obj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
	public Object getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String cityCode, String languageCode)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		return null;
	}

	@Override
	public Object getByIdForAuth(String master, String masterjson) throws Exception {
		TenantMst tenant = null;
		tenant = objectMapper.readValue(masterjson.getBytes(), TenantMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		TenantMst tenant2 = (TenantMst) jpaRepository.getClass().getMethod("findByTenantId", String.class)
				.invoke(jpaRepository, tenant.getTenantId());

		return tenant2;
	}

}
