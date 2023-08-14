package ai.kiya.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ai.kiya.dto.BaseResponseVO;
import ai.kiya.dto.StatusCountVO;
import ai.kiya.service.MainService;
import ai.kiya.util.ConverterClass;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/masters")
public class MasterController {

	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	ConverterClass converterClass;

	@Autowired
	private MainService mainService;

	String response = "";

	@PostMapping(value = "/{master}", produces = "application/json")
	public ResponseEntity<BaseResponseVO> createCommon(@PathVariable String master, @RequestBody String jsonMaster)
			throws Exception {
		// MainVO convertedObj =(MainVO)
		// converterClass.jsonStringToObject(MainVO.class,bodydata);
		BaseResponseVO responseVO = new BaseResponseVO();

		try {
			response = mainService.saveMater(master, jsonMaster);
			// Important - below is just a hack, please use a better mechanism to identify
			// if the
			// previous call has resulted in an error or success. For e.g. throw exception
			// from business logic and use the below code in exception handler (catch) which
			// gives clear indication that the issue has happened.
			if (response.startsWith("Success")) {
				responseVO.setSuccessMessage(response);
				return new ResponseEntity<BaseResponseVO>(responseVO, HttpStatus.OK);
			} else {
				responseVO.setErrorMessage(response);
				return new ResponseEntity<BaseResponseVO>(responseVO, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error::" + e.getMessage());
			responseVO.setErrorMessage("An unknown error occurred. Please check the logs");
			return new ResponseEntity<BaseResponseVO>(responseVO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/update/{master}", produces = "application/json")
	public String updateCommon(@PathVariable String master, @RequestBody String jsonMaster) throws Exception {
		// MainVO convertedObj =(MainVO)
		// converterClass.jsonStringToObject(MainVO.class,bodydata);
		response = mainService.update(master, jsonMaster);
		return response;
	}

	@PutMapping(value = "/authrize/{master}", produces = "application/json")
	public String authorizationCommon(@PathVariable String master, @RequestBody String jsonMaster) throws Exception {
		response = mainService.authorization(master, jsonMaster);
		return response;
	}

	@PutMapping(value = "/reject/{master}", produces = "application/json")
	public String rejectionCommon(@PathVariable String master, @RequestBody String jsonMaster) throws Exception {
		response = mainService.rejection(master, jsonMaster);
		return response;
	}

	@GetMapping(value = "/{master}/{id}", produces = "application/json")
	public String getByIdCommon(@PathVariable String master, @PathVariable String id) throws Exception {
		response = mainService.getById(master, id);
		return response;
	}

	@GetMapping(value = "/{master}/Status/{status}", produces = "application/json")
	public String getByAuthrization(@PathVariable String master, @PathVariable String status) throws Exception {
		response = mainService.getByAuthrizationStatus(master, status);
		return response;
	}

	@GetMapping(value = "/{master}/count/{status}", produces = "application/json")
	public String getStatusCount(@PathVariable String master, @PathVariable String status) throws Exception {
		response = mainService.getAllStatusCount(master, status);
		return response;
	}

	@GetMapping(value = "/{master}/allCounts", produces = "application/json")
	public StatusCountVO getAllStatusCounts(@PathVariable String master) throws Exception {
		StatusCountVO response = new StatusCountVO();
		response.setAuthCount(mainService.getAllStatusCount(master, "A"));
		response.setClosedCount(mainService.getAllStatusCount(master, "D"));
		response.setPendingCount(mainService.getAllStatusCount(master, "P"));
		response.setRejectedCount(mainService.getAllStatusCount(master, "R"));
		return response;
	}

	@GetMapping(value = { "/{master}/{tenantId}/{isActive}/{authStatus}",
			"/{master}/{tenantId}/{isActive}/{authStatus}/{languageCode}" }, produces = "application/json")
	public String getMultiField(@PathVariable String master, @PathVariable Integer tenantId,
			@PathVariable Integer isActive, @PathVariable String authStatus,
			@PathVariable(name = "languageCode", required = false) String languageCode) throws Exception {
		if (!StringUtils.hasLength(languageCode)) {
			languageCode = "en";
		}
		response = mainService.getMultiField(master, tenantId, isActive, authStatus, languageCode);
		return response;
	}

	@DeleteMapping(value = "/{master}", produces = "application/json")
	public String deleteCommon(@PathVariable String master, @RequestParam Map<String, String> params) throws Exception {
		response = mainService.delete(master, params);
		return response;
	}

	@GetMapping(value = "/{master}/{tenantId}/{roleCode}", produces = "application/json")
	public String getByIdRoleCode(@PathVariable String master, @PathVariable Integer tenantId,
			@PathVariable String roleCode) throws Exception {

		response = "";
		if (master.equalsIgnoreCase("User")) {
			response = mainService.getByTenantRoleCode(master, tenantId, roleCode);
		}
		return response;
	}

	@GetMapping(value = "/{master}/getUserByTenantBranchRoleCode/{tenantId}/{branchCode}/{roleCode}", produces = "application/json")
	public String getUserByTenantBranchRoleCode(@PathVariable String master,
			@PathVariable(name = "tenantId") Integer tenantId, @PathVariable(name = "branchCode") Integer branchCode,
			@PathVariable(name = "roleCode") String roleCode) throws Exception {

		response = "";
		if (master.equalsIgnoreCase("User")) {
			response = mainService.getUserByTenantBranchRoleCode(master, tenantId, branchCode, roleCode);
		}
		return response;
	}

	@GetMapping(value = {
			"/{master}/getByAuthActiveTenantCountry/{tenantId}/{isActive}/{authStatus}/{countryCode}/{languageCode}",
			"/{master}/getByAuthActiveTenantCountry/{tenantId}/{isActive}/{authStatus}/{countryCode}" }, produces = "application/json")
	public String getByAuthActiveTenantIdCountry(@PathVariable String master,
			@PathVariable(name = "tenantId") Integer tenantId, @PathVariable(name = "isActive") Integer isActive,
			@PathVariable(name = "authStatus") String authStatus,
			@PathVariable(name = "countryCode") String countryCode,
			@PathVariable(name = "languageCode", required = false) String languageCode) throws Exception {
		response = "";
		if (master.equalsIgnoreCase("State")) {
			if (!StringUtils.hasLength(languageCode)) {
				languageCode = "en";
			}
			response = mainService.getByAuthActiveTenantIdCountryLang(master, tenantId, isActive, authStatus,
					countryCode, languageCode);
		}
		return response;
	}

	@GetMapping(value = {
			"/{master}/getByAuthActiveTenantCountryState/{tenantId}/{isActive}/{authStatus}/{countryCode}/{stateCode}/{languageCode}",
			"/{master}/getByAuthActiveTenantCountryState/{tenantId}/{isActive}/{authStatus}/{countryCode}/{stateCode}" }, produces = "application/json")
	public String getByAuthActiveTenantIdCountryState(@PathVariable String master,
			@PathVariable(name = "tenantId") Integer tenantId, @PathVariable(name = "isActive") Integer isActive,
			@PathVariable(name = "authStatus") String authStatus,
			@PathVariable(name = "countryCode") String countryCode, @PathVariable(name = "stateCode") String stateCode,
			@PathVariable(name = "languageCode", required = false) String languageCode) throws Exception {
		response = "";
		if (master.equalsIgnoreCase("City")) {
			if (!StringUtils.hasLength(languageCode)) {
				languageCode = "en";
			}
			response = mainService.getByAuthActiveTenantCountryStateLang(master, tenantId, isActive, authStatus,
					countryCode, stateCode, languageCode);
		}
		return response;
	}

	@GetMapping(value = {
			"/{master}/getByAuthActiveTenantCountryStateCity/{tenantId}/{isActive}/{authStatus}/{countryCode}/{stateCode}/{cityCode}/{languageCode}",
			"/{master}/getByAuthActiveTenantCountryStateCity/{tenantId}/{isActive}/{authStatus}/{countryCode}/{stateCode}/{cityCode}" }, produces = "application/json")
	public String getByAuthActiveTenantIdCountryStateCity(@PathVariable String master,
			@PathVariable(name = "tenantId") Integer tenantId, @PathVariable(name = "isActive") Integer isActive,
			@PathVariable(name = "authStatus") String authStatus,
			@PathVariable(name = "countryCode") String countryCode, @PathVariable(name = "stateCode") String stateCode,
			@PathVariable(name = "cityCode") String cityCode,
			@PathVariable(name = "languageCode", required = false) String languageCode) throws Exception {
		response = "";
		if (master.equalsIgnoreCase("Village")) {
			if (!StringUtils.hasLength(languageCode)) {
				languageCode = "en";
			}
			response = mainService.getByAuthActiveTenantCountryStateCityLang(master, tenantId, isActive, authStatus,
					countryCode, stateCode, cityCode, languageCode);
		}
		return response;
	}

	@GetMapping(value = "/{master}")
	public Object searchByAllMaster(@PathVariable String master, @RequestParam Map<String, String> params)
			throws Exception {

		return mainService.searchDetailsByAny(master, params);
	}
}
