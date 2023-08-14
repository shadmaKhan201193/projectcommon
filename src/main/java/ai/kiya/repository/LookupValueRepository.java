package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.LookupValue;
import ai.kiya.key.D001002Key;

@Repository
public interface LookupValueRepository extends CommonRepository<LookupValue, D001002Key> {

	public LookupValue findByLookupCodeAndLanguageCodeAndTenantIdAndLookupValueCode(String lookupCode,String LanguageCode,Integer tenantId,String LookupValueCode);

	public List<LookupValue> findByLookupCode(String lookupCode);
	
	public List<LookupValue> findByAuthStatus(String authStatus);
	
//	@Query(value = "SELECT * FROM D001002 e where e.tenantId =:tenantId AND e.authStatus =:authStatus AND e.isActive =:isActive", nativeQuery = true)
//	public  List<LookupValue> getData(@Param("tenantId")Integer tenantId,@Param("isActive")String isActive,@Param("authStatus")String authStatus);
	
	public List<LookupValue> findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode(Integer tenantId,Integer isActive,String authStatus, String languageCode);
	
}
