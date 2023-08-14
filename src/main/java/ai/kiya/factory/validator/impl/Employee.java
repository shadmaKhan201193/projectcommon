package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

import ai.kiya.entity.EmployeeMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Employee implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;

	String str = "";
	// EmployeeKey empKey=new EmployeeKey();
	Object masterObj = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		EmployeeMst employee = null;
		Optional<EmployeeMst> employee123 = null;

		try {
			employee = objectMapper.readValue(masterjson.getBytes(), EmployeeMst.class); // object convert
			employee123 = (Optional<EmployeeMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, employee.getEmployeeKey());
			if (!employee123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		EmployeeMst masterObj = converterClass.childTable(master, employee, employee123.get());

		BeanMappingBuilder builderMinusId = new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(EmployeeMst.class, EmployeeMst.class).exclude("version").exclude("empAddresses")
						.exclude("addresList");

			}
		};
		Mapper mapper = new DozerBeanMapper();
		((DozerBeanMapper) mapper).addMapping(builderMinusId);

		mapper.map(employee, masterObj);
		masterObj.setAddresList(employee.getAddresList());
		masterObj.setEmpAddresses(employee.getEmpAddresses());
		return masterObj;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		EmployeeMst convertedObj = null;
		Optional<EmployeeMst> employee = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), EmployeeMst.class);

			errors = new BindException(convertedObj, "Employee");
			employee = (Optional<EmployeeMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getEmployeeKey());
			if (employee.isPresent()) {
				errors.addError(new FieldError("Employee", "empId", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empId", "empId can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;

	}

	///
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		EmployeeMst convertedObj = null;
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), EmployeeMst.class);

		return convertedObj;

	}

	///

	@Override
	public String getMasterType() {
		return "Employee";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		EmployeeMst employee = (EmployeeMst) jpaRepository.getClass().getMethod("findByEmpId", String.class)
				.invoke(jpaRepository, id);

		return employee;
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

		List<EmployeeMst> employeeList = (List<EmployeeMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return employeeList.size();
	}

	@Override
	@Autowired
	public Class getMasterClass() {
		return EmployeeMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		return roleCode;
//		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
//		EmployeeMst employee = (EmployeeMst) jpaRepository.getClass().getMethod("findByTenantIdAndRoleCode", String.class).invoke(jpaRepository, tenantId,roleCode);
//
//		return employee;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<EmployeeMst> EmployeeList = (List<EmployeeMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return EmployeeList;

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
		EmployeeMst employee = null;
		employee = objectMapper.readValue(masterjson.getBytes(), EmployeeMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		EmployeeMst employee2 = (EmployeeMst) jpaRepository.getClass().getMethod("findByEmpId", String.class)
				.invoke(jpaRepository, employee.getEmpId());

		return employee2;
	}

}
