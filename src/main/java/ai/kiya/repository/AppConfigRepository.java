package ai.kiya.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.AppConfigMst;

@Repository
public interface AppConfigRepository  extends CommonRepository<AppConfigMst, Long> {
	
	@PersistenceContext 
	public  EntityManager em = null;
	
	public AppConfigMst findByBranchCode(String Id);
	
	public  List<AppConfigMst> findByAuthStatus(String auth);
	
	public List<AppConfigMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);

}
