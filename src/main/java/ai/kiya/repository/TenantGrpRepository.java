package ai.kiya.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ai.kiya.entity.StateMst2;
import ai.kiya.entity.TenantGrpMst;

public interface TenantGrpRepository extends CommonRepository<TenantGrpMst, Integer>  {
	@PersistenceContext 
	public  EntityManager em = null;
	
	public TenantGrpMst findByGrpTenantId(Integer Id);
	
	public  List<TenantGrpMst> findByAuthStatus(String auth);
	
	
}
