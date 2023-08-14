package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.UserRoleMst;
import ai.kiya.key.D002005Key;


@Repository
public interface UserRoleRepository extends CommonRepository<UserRoleMst, D002005Key> {
	 public UserRoleMst findByUserRoleId(String userRoleId);

		public List<UserRoleMst> findByAuthStatus(String authStatus);
		
		public List<UserRoleMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
