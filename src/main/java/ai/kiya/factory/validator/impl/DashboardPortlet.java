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

import ai.kiya.entity.DashboardPortletMap;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DashboardPortlet implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	
	@Autowired
	ObjectMapper objectMapper;

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		DashboardPortletMap dashboard = null;
		DashboardPortletMap dashboard123 = null;
		try {
			dashboard = objectMapper.readValue(masterjson.getBytes(), DashboardPortletMap.class); // object
																								// convert
			dashboard123 = (DashboardPortletMap) jpaRepository.getClass().getMethod("findByDashId", String.class)
					.invoke(jpaRepository, dashboard.getDashId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		Long id = dashboard123.getId();
		mapper.map(dashboard, dashboard123);
		dashboard123.setId(id);

		return dashboard123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		DashboardPortletMap convertedObj = null;
		DashboardPortletMap dashboard = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), DashboardPortletMap.class);
			errors = new BindException(convertedObj, "Dashboard");
			dashboard = (DashboardPortletMap) jpaRepository.getClass().getMethod("findByDashId", String.class)
					.invoke(jpaRepository, convertedObj.getDashId());
			if (null != dashboard) {
				errors.addError(new FieldError("Dashboard", "dashId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dashId", "dashId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "DashboardPortlet";
	}

	@Override
	public Object getById(String master, String idd) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		DashboardPortletMap dashboard = (DashboardPortletMap) jpaRepository.getClass()
				.getMethod("findByDashId", String.class).invoke(jpaRepository, idd);

		return dashboard;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<DashboardPortletMap> dashboardList = (List<DashboardPortletMap>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return dashboardList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<DashboardPortletMap> dashboardList = (List<DashboardPortletMap>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return dashboardList.size();
	}

	@Override
	public Class getMasterClass() {
		return DashboardPortletMap.class;
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
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<DashboardPortletMap> DashboardPortletList = (List<DashboardPortletMap>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return DashboardPortletList;

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
		DashboardPortletMap dashboardPortlet = null;
		dashboardPortlet = objectMapper.readValue(masterjson.getBytes(), DashboardPortletMap.class); // object
																											// convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		DashboardPortletMap dashboardPortlet2 = (DashboardPortletMap) jpaRepository.getClass()
				.getMethod("findByDashId", String.class).invoke(jpaRepository, dashboardPortlet.getDashId());

		return dashboardPortlet2;
	}

}
