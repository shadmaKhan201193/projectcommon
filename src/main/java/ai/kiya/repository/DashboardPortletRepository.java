package ai.kiya.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.CustomerMst2;
import ai.kiya.entity.DashboardPortletMap;

@Repository
public interface DashboardPortletRepository  extends CommonRepository<DashboardPortletMap, Long> {
	@PersistenceContext 
	public  EntityManager em = null;
	
	public DashboardPortletMap findByDashId(String Id);
	
	public  List<DashboardPortletMap> findByAuthStatus(String auth);
	public List<DashboardPortletMap> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
