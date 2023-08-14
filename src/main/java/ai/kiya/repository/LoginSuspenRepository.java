package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.HolidayBranchMap;
import ai.kiya.entity.UserLoginSuspenMst;
import ai.kiya.key.D002046Key;

@Repository
public interface LoginSuspenRepository extends CommonRepository<UserLoginSuspenMst, D002046Key> {
	
	//public UserLoginSuspenMst findByD002046Key(D002046Key D002046Key); loginId
   public UserLoginSuspenMst  findByLoginId(String loginId); 

	public List<UserLoginSuspenMst> findByAuthStatus(String authStatus);

	public List<UserLoginSuspenMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
