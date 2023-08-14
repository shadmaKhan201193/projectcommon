package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.LookupCode;
import ai.kiya.key.D001001Key;

@Repository
public interface LookUpRepository extends CommonRepository<LookupCode, D001001Key> {

	
	public LookupCode findByLookupCode(String lookupCode);
	
	public List<LookupCode> findByAuthStatus(String authStatus);
	
	public List<LookupCode> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
}
