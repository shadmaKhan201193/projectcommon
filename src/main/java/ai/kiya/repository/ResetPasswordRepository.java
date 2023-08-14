package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.ReportMst;
import ai.kiya.entity.ResetPasswordMst;
import ai.kiya.key.D045947Key;

@Repository
public interface ResetPasswordRepository extends CommonRepository<ResetPasswordMst, D045947Key> {

	//public ResetPasswordMst findByD045947Key(D045947Key d045947Key);
	
	public ResetPasswordMst findByUserLoginId(String userLoginId);


	public List<ResetPasswordMst> findByAuthStatus(String authStatus);
	public ResetPasswordMst findById(String id);
	public List<ResetPasswordMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
}
