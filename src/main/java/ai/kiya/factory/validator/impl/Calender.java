package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.lang.StackWalker.Option;
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
import ai.kiya.entity.CalenderMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Calender implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	// D001013Key d001013Key=new D001013Key();
	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CalenderMst calender = null;
		Optional<CalenderMst> calender123 = null;
		try {
			calender = objectMapper.readValue(masterjson.getBytes(), CalenderMst.class); // object convert

			calender123 = (Optional<CalenderMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, calender.getD001013Key());
			if (!calender123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(calender, calender123.get());

		return calender123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		CalenderMst convertedObj = null;
		Optional<CalenderMst> calender = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), CalenderMst.class);

			errors = new BindException(convertedObj, "Calender");
			calender = (Optional<CalenderMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getBranchCode());
			if (calender.isPresent()) {
				errors.addError(new FieldError("Calender", "branchCode", "Record Already Present"));
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

		return "Calender";
	}

	@Override
	public Object getById(String master, String id) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CalenderMst calender123 = null;
		Integer branchCode = Integer.valueOf(id);
		calender123 = (CalenderMst) jpaRepository.getClass().getMethod("findByBranchCode", Integer.class)
				.invoke(jpaRepository, branchCode);

		return calender123;
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

		List<CalenderMst> calenderList = (List<CalenderMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return calenderList.size();
	}

	@Override
	public Class getMasterClass() {
		return CalenderMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {

		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		CalenderMst convertedObj = null;
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), CalenderMst.class);

		return convertedObj;

	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<BranchMst> CalenderList = (List<BranchMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return CalenderList;
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
		CalenderMst calender = null;
		calender = objectMapper.readValue(masterjson.getBytes(), CalenderMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CalenderMst calender2 = (CalenderMst) jpaRepository.getClass().getMethod("findByBranchCode", String.class)
				.invoke(jpaRepository, calender.getBranchCode());

		return calender2;
	}

}
