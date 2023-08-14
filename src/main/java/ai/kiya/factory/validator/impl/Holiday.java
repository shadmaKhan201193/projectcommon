package ai.kiya.factory.validator.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

import ai.kiya.entity.HolidayBranchMap;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Holiday implements MasterValidator {

	@Autowired
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";
	// D009401Key d009401Key=new D009401Key();
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		HolidayBranchMap holiday = null;
		Optional<HolidayBranchMap> holiday123 = null;
		try {
			holiday = objectMapper.readValue(masterjson.getBytes(), HolidayBranchMap.class); // object convert

			holiday123 = (Optional<HolidayBranchMap>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, holiday.getD009401Key());
			if (!holiday123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		mapper.map(holiday, holiday123.get());

		return holiday123.get();
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		HolidayBranchMap convertedObj = null;
		Optional<HolidayBranchMap> holiday = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), HolidayBranchMap.class);

			errors = new BindException(convertedObj, "Holiday");
			holiday = (Optional<HolidayBranchMap>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD009401Key());
			if (holiday.isPresent()) {
				errors.addError(new FieldError("Holiday", "holidayCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "holidayCode", "holidayCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Holiday";
	}

	@Override
	public Object getById(String master, String holidayId) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		HolidayBranchMap holiday123 = null;
		holiday123 = (HolidayBranchMap) jpaRepository.getClass().getMethod("findByHolidayId", String.class)
				.invoke(jpaRepository, holidayId);

		return holiday123;
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

		List<HolidayBranchMap> roleList = (List<HolidayBranchMap>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return roleList.size();
	}

	@Override
	public Class getMasterClass() {
		return HolidayBranchMap.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		HolidayBranchMap convertedObj = null;
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), HolidayBranchMap.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<HolidayBranchMap> HolidayBranchList = (List<HolidayBranchMap>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return HolidayBranchList;
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
		HolidayBranchMap holidayBranchMap = null;
		holidayBranchMap = objectMapper.readValue(masterjson.getBytes(), HolidayBranchMap.class); // object
																									// convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		HolidayBranchMap holidayBranchMap2 = (HolidayBranchMap) jpaRepository.getClass()
				.getMethod("findByHolidayId", String.class).invoke(jpaRepository, holidayBranchMap.getHolidayId());

		return holidayBranchMap2;
	}

}
