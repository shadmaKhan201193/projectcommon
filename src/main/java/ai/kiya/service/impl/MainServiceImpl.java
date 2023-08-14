package ai.kiya.service.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.fasterxml.jackson.databind.ObjectMapper;

import ai.kiya.commons.component.config.AppConstant;
import ai.kiya.commons.component.dto.NotificationVO;
import ai.kiya.commons.component.service.NotificationService;
import ai.kiya.factory.CalculatorFactory;
import ai.kiya.factory.MasterRepositoryFactoryImplementation;
import ai.kiya.factory.MasterValidator;
import ai.kiya.factory.MasterValidatorImplementation;
import ai.kiya.omni.OmniConstants;
import ai.kiya.service.MainService;

@Service
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class MainServiceImpl implements MainService {

	@Autowired
	private NotificationService notificationService;

	Object masterObj = "";
	Mapper mapper = new DozerBeanMapper();
	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	CalculatorFactory calculatorFactory;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String saveMater(String master, String masterJson) throws Exception {
		// BindException errors=new BindException(masterJson, master);
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		Errors errors = validator.validate(master, masterJson);
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		if (errors.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (ObjectError object : errors.getAllErrors()) {
				if (object instanceof FieldError) {
					FieldError fe = (FieldError) object;
					if (null != fe.getCode()) {
						sb.append(fe.getCode());
					} else if (null != fe.getDefaultMessage()) {
						sb.append(fe.getDefaultMessage());
					}
				}
			}
			return sb.toString();
		}

		masterObj = validator.setkeyValueAndChild(master, masterJson);
		calculatorFactory.mapBaseObj(masterObj, OmniConstants.CREATE, master);
		masterObj = validator.setChildkeyValue(masterObj, OmniConstants.CREATE);

		jpaRepository.save(masterObj);
		String response = "Successfully saved record";
		return response;
	}

	private void sendNotification(String master, String response) {
		NotificationVO notification = new NotificationVO();
		notification.setMessage(response);
		notification.setSourceApp("common-masters");
		notification.setSubject(master + "Added");
		notification.setTenantId(null); // TODO - map tenantId from masterObj
		notification.setUserId(null); // TODO - get the user performing this action from masterObj
		notificationService.sendNotification(notification, AppConstant.email);
	}

	@Override
	public String update(String master, String masterJson) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByIdForUpdate(master, masterJson);

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		calculatorFactory.mapBaseObj(masterObj, OmniConstants.CREATE, master);
		jpaRepository.save(masterObj);
		String response = "Successfully updated Record";

		return response;
	}

	@Override
	public String delete(String master, Map<String, String> params) throws Exception {
		masterObj = searchDetailsByAny(master, params);
		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);

		calculatorFactory.mapBaseObj(masterObj, OmniConstants.DELETE, master);
		jpaRepository.save(masterObj);
		String response = "Successfully deleted record";
		sendNotification(master, response);
		return response;

	}

	@Override
	public String getById(String master, String id) throws Exception {

		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		masterObj = validator.getById(master, id);
		String response = objectMapper.writeValueAsString(masterObj);
		return response;

	}

	@Override
	public String authorization(String master, String masterJson) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByIdForAuth(master, masterJson);

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		calculatorFactory.mapBaseObj(masterObj, OmniConstants.AUTH_AUTHORIZED, master);
		jpaRepository.save(masterObj);

		String response = "Record Authorized Successfully.";

		return response;
	}

	@Override
	public String rejection(String master, String masterJson) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByIdForAuth(master, masterJson);

		JpaRepository jpaRepository = MasterRepositoryFactoryImplementation.getInstance(master);
		calculatorFactory.mapBaseObj(masterObj, OmniConstants.REJECT, master);
		jpaRepository.save(masterObj);

		String response = "Record Rejected Successfully.";

		return response;
	}

	@Override
	public String getByAuthrizationStatus(String master, String status) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		masterObj = validator.getByAuthStatus(master, status);
		String response = objectMapper.writeValueAsString(masterObj);
		return response;
	}

	@Override
	public String getAllStatusCount(String master, String status) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		masterObj = validator.getAllStatusCount(master, status);
		String response = objectMapper.writeValueAsString(masterObj);
		return response;
	}

	@Override
	public String getByTenantRoleCode(String master, Integer tenantId, String roleCode) throws Exception {

		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		masterObj = validator.getByIdRoldeCode(master, tenantId, roleCode);
		String response = objectMapper.writeValueAsString(masterObj);
		return response;

	}

	@Override
	public String getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getMultiField(master, tenantId, isActive, authStatus, languageCode);
		String responce = objectMapper.writeValueAsString(masterObj);
		return responce;
	}

	@Override
	public String getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByAuthActiveTenantIdCountryLang(master, tenantId, isActive, authStatus, countryCode,
				languageCode);
		String responce = objectMapper.writeValueAsString(masterObj);
		return responce;
	}

	@Override
	public String getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String languageCode) throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByAuthActiveTenantCountryStateLang(master, tenantId, isActive, authStatus, countryCode,
				stateCode, languageCode);
		String responce = objectMapper.writeValueAsString(masterObj);
		return responce;
	}

	@Override
	public String getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String cityCode, String languageCode)
			throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);
		masterObj = validator.getByAuthActiveTenantCountryStateCityLang(master, tenantId, isActive, authStatus,
				countryCode, stateCode, cityCode, languageCode);
		String responce = objectMapper.writeValueAsString(masterObj);
		return responce;
	}

	@Override
	public String getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception {
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		masterObj = validator.getUserByTenantBranchRoleCode(master, tenantId, branchCode, roleCode);
		String responce = objectMapper.writeValueAsString(masterObj);
		return responce;
	}

	@Override
	public Object searchDetailsByAny(String master, Map<String, String> params) throws Exception {

		// get master object
		MasterValidator validator = MasterValidatorImplementation.createInstance(master);

		// convert master in class
		// Use Master Entity in CriteriaBuilder for Dynamic Query
		Class requiredClass = validator.getMasterClass();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery criteriaQuery = builder.createQuery(requiredClass);
		Root root = criteriaQuery.from(requiredClass);
		String fieldName = "";
		String fieldValue = "";
		for (Map.Entry<String, String> entry : params.entrySet()) {
			fieldName = entry.getKey();
			fieldValue = entry.getValue();
		}
		// Getting List of Object from CriteriaBuilder
		List<Object> results;
		if (fieldName == null) {
			throw new IllegalArgumentException(" Attribute name is missing");
		}
		try {
			Predicate predicate = builder.equal(root.get(fieldName), fieldValue);
			criteriaQuery.where(predicate);

			TypedQuery query = entityManager.createQuery(criteriaQuery);
			results = query.getResultList();

		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Invalid attribute name: " + fieldName);
		}

		if (results != null && results.size() >= 1) {
			return results.get(0);
		} else {
			return null;
		}

	}
}
