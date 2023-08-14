package ai.kiya.repository;

import java.util.List;

import ai.kiya.entity.TenantMst;

public interface TenantRepository extends CommonRepository<TenantMst, Integer>  {
	public TenantMst findByTenantId(Integer Id);
	
	public  List<TenantMst> findByAuthStatus(String auth);
	
	
}
