package ai.kiya.factory;

import java.util.Map;

import org.aspectj.weaver.ast.Instanceof;
import org.springframework.validation.Errors;

public interface MasterValidator {
	
	public Object getByIdForUpdate(String master,String str)throws Exception ;

	public Errors validate(String master,String obj)throws Exception ;

	public String getMasterType();
	

	public Object getById(String master,String str)throws Exception ;
	
	public Object getByIdRoldeCode(String master,Integer tenantId,String roleCode)throws Exception ;
	
	public Object getUserByTenantBranchRoleCode(String master,Integer tenantId,Integer branchCode, String roleCode)throws Exception ;
	
	public Object getByAuthStatus(String master,String status)throws Exception ;
	
	public int getAllStatusCount(String master,String status)throws Exception ;

	public Class getMasterClass();
	
	public Object getKeyValue(Object obj,String jsonemaster) throws Exception;
	
	public Object setkeyValueAndChild(String master, String masterjson) throws Exception ;
	
	public Object setChildkeyValue(Object obj, String mode) throws Exception ;

	public Object getMultiField(String master, Integer tenantId, Integer isActive, String authStatus,String languageCode)throws Exception ;
	
	public Object getByAuthActiveTenantIdCountryLang(String master, Integer tenantId, Integer isActive, String authStatus,
			String countryCode, String languageCode) throws Exception;

	public Object getByAuthActiveTenantCountryStateLang(String master, Integer tenantId, Integer isActive, String authStatus,
			String countryCode, String stateCode, String languageCode) throws Exception;
	
	public Object getByAuthActiveTenantCountryStateCityLang(String master, Integer tenantId, Integer isActive, String authStatus,
			String countryCode, String stateCode, String cityCode, String languageCode) throws Exception;
	public Object getByIdForAuth(String master,String masterjson)throws Exception ;

	
	
	
}
