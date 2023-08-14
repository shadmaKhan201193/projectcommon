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

import ai.kiya.entity.CurrencyMst;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.util.ConverterClass;

@Component
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Currency implements MasterValidator {

	@Autowired
	private ConverterClass converterClass;

	@Autowired
	ObjectMapper objectMapper;

	String str = "";
	Object masterObj = "";

	@Override
	public Object getByIdForUpdate(String master, String masterjson) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CurrencyMst currency = null;
		Optional<CurrencyMst> currency123 = null;

		try {
			currency = objectMapper.readValue(masterjson.getBytes(), CurrencyMst.class); // object convert

			currency123 = (Optional<CurrencyMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, currency.getD001012Key());
			if (!currency123.isPresent()) {
				// TODO - handle a situation where update is called on non-existing object
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		CurrencyMst masterObj = converterClass.childTable(master, currency, currency123.get());

		BeanMappingBuilder builderMinusId = new BeanMappingBuilder() {
			@Override
			protected void configure() {
				mapping(CurrencyMst.class, CurrencyMst.class).exclude("version").exclude("d001112");
			}
		};
		Mapper mapper = new DozerBeanMapper();
		((DozerBeanMapper) mapper).addMapping(builderMinusId);
		mapper.map(currency, masterObj);
		masterObj.setD001112(currency.getD001112());
		return masterObj;
	}

	@Override
	public Errors validate(String master, String masterjson) throws Exception {
		CurrencyMst convertedObj = null;
		Optional<CurrencyMst> currency = null;
		BindException errors = null;

		try {
			JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
			// roleCode from entity
			convertedObj = objectMapper.readValue(masterjson.getBytes(), CurrencyMst.class);

			errors = new BindException(convertedObj, "Currency");
			currency = (Optional<CurrencyMst>) jpaRepository.getClass().getMethod("findById", Object.class)
					.invoke(jpaRepository, convertedObj.getD001012Key());
			if (currency.isPresent()) {
				errors.addError(new FieldError("Currency", "currencyIsoCode", "Record Already Present"));
				return errors;
			}
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currencyIsoCode", "currencyIsoCode can not be blank");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return errors;
	}

	@Override
	public String getMasterType() {
		return "Currency";
	}

	@Override
	public Object getById(String master, String currencyIsoCode) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CurrencyMst currency = (CurrencyMst) jpaRepository.getClass().getMethod("findByCurrencyIsoCode", String.class)
				.invoke(jpaRepository, currencyIsoCode);

		return currency;
	}

	@Override
	public Object getByIdRoldeCode(String master, Integer tenantId, String roleCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByAuthStatus(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		List<CurrencyMst> currencyList = (List<CurrencyMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);
		return currencyList;
	}

	@Override
	public int getAllStatusCount(String master, String status) throws Exception {
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<CurrencyMst> currencyList = (List<CurrencyMst>) jpaRepository.getClass()
				.getMethod("findByAuthStatus", String.class).invoke(jpaRepository, status);

		return currencyList.size();
	}

	@Override
	public Class getMasterClass() {

		return CurrencyMst.class;
	}

	@Override
	public Object getKeyValue(Object obj, String jsonemaster) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception {
		CurrencyMst convertedObj = null;
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		// roleCode from entity
		convertedObj = objectMapper.readValue(masterjson.getBytes(), CurrencyMst.class);

		return convertedObj;
	}

	@Override
	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		List<CurrencyMst> CurrencyList = (List<CurrencyMst>) jpaRepository.getClass()
				.getMethod("findByTenantIdAndIsActiveAndAuthStatus", Integer.class, Integer.class, String.class)
				.invoke(jpaRepository, tenantId, isActive, authStatus);
		return CurrencyList;
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
		CurrencyMst currency = null;
		currency = objectMapper.readValue(masterjson.getBytes(), CurrencyMst.class); // object convert
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		CurrencyMst currency2 = (CurrencyMst) jpaRepository.getClass().getMethod("findByCurrencyIsoCode", String.class)
				.invoke(jpaRepository, currency.getCurrencyIsoCode());

		return currency2;
	}

}
