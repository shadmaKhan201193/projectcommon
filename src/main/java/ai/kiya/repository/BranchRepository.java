package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.BranchMst;
import ai.kiya.key.D001003Key;
@Repository
public interface BranchRepository extends CommonRepository<BranchMst, D001003Key> {
	
	


	public List<BranchMst> findByAuthStatus(String authStatus);
	public BranchMst findByBranchId(String id);
	
	public List<BranchMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
