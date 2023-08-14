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

import ai.kiya.entity.CustomerMst2;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Customer implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;

	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// D009011Key d009011Key=new D009011Key();

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CustomerMst2 customer = null;
		Optional<CustomerMst2> customer123 = null;
		try {
			customer = objectMapper.readValue(masterjson.getBytes(), CustomerMst2.class); // object convert

			customer123 = (Optional<CustomerMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, customer.getD009011Key());
			if (!customer123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(customer, customer123.get());

		return customer123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		CustomerMst2 convertedObj = null;
		Optional<CustomerMst2> customer = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), CustomerMst2.class);

			errors = new BindException(convertedObj, "Customer");
			customer = (Optional<CustomerMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD009011Key());
			if (customer.isPresent()) {
				errors.addError(new FieldError("Customer", "memberCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "memberCode", "memberCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {

		return "Customer";
	}

	@Override
	public Object getById(String master, String custId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CustomerMst2 customer123 = null;
		Integer mumId = Integer.valueOf(custId);
		customer123 = (CustomerMst2) jpaRepository.getClass().getMethod("findByMemberCode", Integer.class)
				.invoke(jpaRepository, mumId);

		return customer123;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class getMasterClass() {
		return CustomerMst2.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		CustomerMst2 convertedObj = null;
		convertedObj = objectMapper.readValue(masterjson.getBytes(), CustomerMst2.class);
		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<CustomerMst2> CustomerList = (List<CustomerMst2>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return CustomerList;

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
		CustomerMst2 customer = null;
		customer = objectMapper.readValue(masterjson.getBytes(), CustomerMst2.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CustomerMst2 customer2 = (CustomerMst2) jpaRepository.getClass().getMethod("findByMemberCode", String.class)
				.invoke(jpaRepository, customer.getMemberCode());

		return customer2;
	}

}
