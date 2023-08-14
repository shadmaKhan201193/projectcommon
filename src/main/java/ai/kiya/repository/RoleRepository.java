package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.ResetPasswordMst;
import ai.kiya.entity.RoleMst;
import ai.kiya.key.RoleKey;

@Repository
public interface RoleRepository extends CommonRepository<RoleMst, RoleKey> {

	//public RoleMst findByD002062Key(RoleKey roleKey);
	
	

	public RoleMst findByUserRoleId(String  userRoleId);

	public List<RoleMst> findByAuthStatus(String authStatus);
	public List<RoleMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);

}
