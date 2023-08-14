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

import ai.kiya.entity.StateMst2;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class State implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;
	ObjectMapper objectMapper;
	Mapper mapper = new DozerBeanMapper();
	String str = "";

	@Override
	public String getMasterType() {

		return "State";
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		StateMst2 convertedObj = null;
		Optional<StateMst2> state = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			convertedObj = objectMapper.readValue(masterjson.getBytes(), StateMst2.class);
			errors = new BindException(convertedObj, "State");
			state = (Optional<StateMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD009505Key());
			if (state.isPresent()) {
				errors.addError(new FieldError("State", "stateCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stateCode", "stateCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public Object getByIdForUpdate(String master, String str) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		StateMst2 state = null;
		Optional<StateMst2> state123 = null;
		try {
			state = objectMapper.readValue(str.getBytes(), StateMst2.class); // object convert
			state123 = (Optional<StateMst2>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, state.getD009505Key());
			if (!state123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
//		String id = state123.getStateCode();
		mapper.map(state, state123.get());
//		state123.setStateCode(id);

		return state123.get();
	}

	@Override
	public Object getById(String master, String stateCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		StateMst2 city = (StateMst2) jpaRepository.getClass().getMethod("findByStateCode", String.class)
				.invoke(jpaRepository, stateCode);

		return city;
	}

	@Autowired
	public Class getMasterClass() {
		return StateMst2.class;
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
		List<StateMst2> stateList = (List<StateMst2>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return stateList.size();
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
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<StateMst2> StateList = (List<StateMst2>) jpaRepository
				.getClass().getMethod("findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode", Integer.class,
						Integer.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, languageCode);
		return StateList;
	}

	@Override
	public Object getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<StateMst2> StateList = (List<StateMst2>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatusAndCountryCodeAndLanguageCode", Integer.class,
						Integer.class, String.class, String.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus, countryCode, languageCode);
		return StateList;
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
		StateMst2 State = null;
		State = objectMapper.readValue(masterjson.getBytes(), StateMst2.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		StateMst2 State2 = (StateMst2) jpaRepository.getClass().getMethod("findByStateCode", String.class)
				.invoke(jpaRepository, State.getStateCode());

		return State2;
	}

}
