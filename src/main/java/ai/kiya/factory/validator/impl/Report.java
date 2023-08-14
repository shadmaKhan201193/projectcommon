package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.entity.LookupCode;
import ai.kiya.entity.ReportMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({"rawtypes","unchecked"})
public class Report implements MasterValidator {
	
	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;
	String str = "";
	// D970096Key d970096Key=new D970096Key();
	Object masterObj = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ReportMst report = null;
		ReportMst report123 = null;

		try {
			report = objectMapper.readValue(masterjson.getBytes(), ReportMst.class); // object convert

			report123 = (ReportMst) jpaRepository.getClass().getMethod("findByReportId", String.class)
					.invoke(jpaRepository, report.getReportId());

		} catch (IOException e) {
			e.printStackTrace();
		}

		ReportMst masterObj = converterClass.childTable(master, report, report123);

		BeanMappingBuilder builderMinusId = new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(LookupCode.class, LookupCode.class).exclude("version").exclude("d970196");
			}
		};
		Mapper mapper = new DozerBeanMapper();
		((DozerBeanMapper) mapper).addMapping(builderMinusId);
		mapper.map(report, masterObj);
		masterObj.setD970196(report.getD970196());
		return masterObj;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		ReportMst convertedObj = null;
		ReportMst report = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																							// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), ReportMst.class);

			errors = new BindException(convertedObj, "Report");
			report = (ReportMst) jpaRepository.getClass().getMethod("findByReportId", String.class)
					.invoke(jpaRepository, convertedObj.getReportId());
			if (null != report) {
				errors.addError(new FieldError("Report", "reportId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reportId", "reportId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Report";
	}

	@Override
	public Object getById(String master, String ReportId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ReportMst report = (ReportMst) jpaRepository.getClass().getMethod("findByReportId", String.class)
				.invoke(jpaRepository, ReportId);

		return report;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return null;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<ReportMst> reportList = (List<ReportMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return reportList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<ReportMst> reportList = (List<ReportMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return reportList.size();
	}

	@Override
	public Class getMasterClass() {
		return ReportMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		ReportMst convertedObj = null;

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
																						// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), ReportMst.class);

		return convertedObj;

	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<ReportMst> ReportList = (List<ReportMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return ReportList;
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
		ReportMst report = null;
		report = objectMapper.readValue(masterjson.getBytes(), ReportMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		ReportMst report2 = (ReportMst) jpaRepository.getClass().getMethod("findByReportId", String.class)
				.invoke(jpaRepository, report.getReportId());

		return report2;
	}

	
}
