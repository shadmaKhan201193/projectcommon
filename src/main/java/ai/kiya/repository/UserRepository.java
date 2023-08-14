package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.StateMst2;
import ai.kiya.entity.UserMst;
import ai.kiya.key.D002001Key;

@Repository
public interface UserRepository extends CommonRepository<UserMst, D002001Key> {
	
	
    //public UserMst findByD002001Key(D002001Key d002001Key);
    public UserMst findByLoginId(String loginId);
	
	
	public UserMst findByUserId(String  id);

	public List<UserMst> findByAuthStatus(String authStatus);
	public List<UserMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
	
	public List<UserMst> findByTenantIdAndIsActiveAndAuthStatusAndUserBranchMapsBranchCode(Integer tenantId,Integer isActive,String authStatus, Integer branchCode);
	
	
	
	//public List<UserMst> findByTenantIdAndIsActiveAndAuthStatusAndUserBranchMapsBranchCodeAndUserBranchMapsUserBranch_RoleMapsRoleCode(
	//		Integer tenantId,Integer isActive,String authStatus, Integer branchCode, String roleCode);
	
}
