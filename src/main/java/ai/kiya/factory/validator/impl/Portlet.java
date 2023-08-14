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

import ai.kiya.entity.PortletMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class Portlet implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// D009509Key d009509Key=new D009509Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PortletMst portlet = null;
		PortletMst portlet123 = null;
		try {
			portlet = objectMapper.readValue(masterjson.getBytes(), PortletMst.class); // object convert

			portlet123 = (PortletMst) jpaRepository.getClass().getMethod("findByPortletCode", String.class)
					.invoke(jpaRepository, portlet.getPortletCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(portlet, portlet123);

		return portlet123;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		PortletMst convertedObj = null;
		PortletMst portlet = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), PortletMst.class);

			errors = new BindException(convertedObj, "Portlet");
			portlet = (PortletMst) jpaRepository.getClass().getMethod("findByPortletCode", String.class)
					.invoke(jpaRepository, convertedObj.getPortletCode());
			if (null != portlet) {
				errors.addError(new FieldError("Portlet", "portletCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portletCode", "portletCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Portlet";
	}

	@Override
	public Object getById(String master, String portletId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PortletMst portlet = (PortletMst) jpaRepository.getClass().getMethod("findByPortletCode", String.class)
				.invoke(jpaRepository, portletId);

		return portlet;
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
		List<PortletMst> PortletList = (List<PortletMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return PortletList.size();
	}

	@Override
	public Class getMasterClass() {

		return PortletMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {

		PortletMst convertedObj = null;
																						// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), PortletMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<PortletMst> PortletList = (List<PortletMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return PortletList;
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
		PortletMst portlet = null;
		portlet = objectMapper.readValue(masterjson.getBytes(), PortletMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		PortletMst portlet2 = (PortletMst) jpaRepository.getClass().getMethod("findByPortletCode", String.class)
				.invoke(jpaRepository, portlet.getPortletCode());

		return portlet2;
	}

	

}
