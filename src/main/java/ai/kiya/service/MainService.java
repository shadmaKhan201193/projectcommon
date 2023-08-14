package ai.kiya.service;

import java.util.List;
import java.util.Map;

public interface MainService {

	public String saveMater(String master, String masterJson) throws Exception;

	public String update(String master, String masterJson) throws Exception;

	public String getById(String master, String id) throws Exception;

	public String getByTenantRoleCode(String master, Integer tenantId, String roleCode) throws Exception;

	public String authorization(String master, String id) throws Exception;

	public String rejection(String master, String id) throws Exception;

	public String getUserByTenantBranchRoleCode(String master, Integer tenantId, Integer branchCode, String roleCode)
			throws Exception;

	public String getByAuthrizationStatus(String master, String status) throws Exception;

	public String getAllStatusCount(String master, String status) throws Exception;

	public String delete(String master, Map<String, String> params) throws Exception;

	public String getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,
			String languageCode) throws Exception;

	public String getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String languageCode) throws Exception;

	public String getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String languageCode) throws Exception;

	public String getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive,
			String authStatus, String countryCode, String stateCode, String cityCode, String languageCode)
			throws Exception;

	public Object searchDetailsByAny(String master, Map<String, String> params) throws Exception;

}
