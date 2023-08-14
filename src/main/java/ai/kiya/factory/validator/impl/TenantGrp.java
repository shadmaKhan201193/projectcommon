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

import ai.kiya.entity.TenantGrpMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class TenantGrp implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@Override
	public Object getByIdForUpdate(String master, String strjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		TenantGrpMst tenantGrp = null;
		TenantGrpMst tenantGrp123 = null;
		try {
			tenantGrp = objectMapper.readValue(strjson.getBytes(), TenantGrpMst.class); // object convert
			tenantGrp123 = (TenantGrpMst) jpaRepository.getClass().getMethod("findByGrpTenantId", Integer.class)
					.invoke(jpaRepository, tenantGrp.getGrpTenantId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Integer id = tenantGrp123.getGrpTenantId();
		mapper.map(tenantGrp, tenantGrp123);
		tenantGrp123.setGrpTenantId(id);

		return tenantGrp123;

	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		TenantGrpMst convertedObj = null;
		TenantGrpMst TenantGrp = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), TenantGrpMst.class);
			errors = new BindException(convertedObj, "TenantGrp");
			TenantGrp = (TenantGrpMst) jpaRepository.getClass().getMethod("findByGrpTenantId", Integer.class)
					.invoke(jpaRepository, convertedObj.getGrpTenantId());
			if (null != TenantGrp) {
				errors.addError(new FieldError("TenantGrp", "grpTenantId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "grpTenantId", "grpTenantId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "TenantGrp";

	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		Integer tenentId = Integer.valueOf(id);
		TenantGrpMst tenantGrp = (TenantGrpMst) jpaRepository.getClass().getMethod("findByGrpTenantId", Integer.class)
				.invoke(jpaRepository, tenentId);
		return tenantGrp;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<TenantGrpMst> tenantGrpList = (List<TenantGrpMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return tenantGrpList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<TenantGrpMst> tenantGrpList = (List<TenantGrpMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return tenantGrpList.size();
	}

	@Override
	@Autowired
	public Class getMasterClass() {
		return TenantGrpMst.class;
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
		Object masterObj = "";
		masterObj = converterClass.getJsonToObject(getMasterClass(), masterjson);
		return masterObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		return null;
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
		TenantGrpMst tenant = null;
		tenant = objectMapper.readValue(masterjson.getBytes(), TenantGrpMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		TenantGrpMst tenant2 = (TenantGrpMst) jpaRepository.getClass().getMethod("findByGrpTenantId", Integer.class)
				.invoke(jpaRepository, tenant.getGrpTenantId());

		return tenant2;
	}

}
