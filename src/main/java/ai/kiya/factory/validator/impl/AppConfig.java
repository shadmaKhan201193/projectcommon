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

import ai.kiya.entity.AppConfigMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AppConfig implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;
	
	@Autowired
	ObjectMapper objectMapper;
	
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@Override
	public Object getByIdForUpdate(String master, String strjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		AppConfigMst appConfig = null;
		AppConfigMst appConfig123 = null;
		try {
			appConfig = objectMapper.readValue(strjson.getBytes(), AppConfigMst.class); // object convert
			appConfig123 = (AppConfigMst) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
					.invoke(jpaRepository, appConfig.getBranchCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long id = appConfig123.getId();
		mapper.map(appConfig, appConfig123);
		appConfig123.setId(id);

		return appConfig123;

	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		AppConfigMst appConfigObj = null;
		AppConfigMst appConfig = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			appConfigObj = objectMapper.readValue(masterjson.getBytes(), AppConfigMst.class);
			errors = new BindException(appConfigObj, "AppConfig");
			appConfig = (AppConfigMst) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
					.invoke(jpaRepository, appConfigObj.getBranchCode());
			if (null != appConfig) {
				errors.addError(new FieldError("AppConfig", "branchCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchCode", "branchCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "AppConfig";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		AppConfigMst tenantGrp = (AppConfigMst) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
				.invoke(jpaRepository, id);
		return tenantGrp;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<AppConfigMst> tenantGrpList = (List<AppConfigMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return tenantGrpList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<AppConfigMst> appconList = (List<AppConfigMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return appconList.size();
	}

	@Override
	@Autowired
	public Class getMasterClass() {
		return AppConfigMst.class;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		// TODO Auto-generated method stub
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
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<AppConfigMst> AppConfigList = (List<AppConfigMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return AppConfigList;
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
		AppConfigMst appConfig = null;
		appConfig = objectMapper.readValue(masterjson.getBytes(), AppConfigMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		AppConfigMst appConfig2 = (AppConfigMst) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
				.invoke(jpaRepository, appConfig.getBranchCode());

		return appConfig2;
	}

}
