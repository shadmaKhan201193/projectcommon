package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.DashboardMst;
import ai.kiya.entity.DashboardPortletMap;
import ai.kiya.key.D009508Key;

@Repository
public interface DashboardRepository extends  CommonRepository<DashboardMst, D009508Key> {
	public DashboardMst findByDashboardCode(String dashboardCode);


	public List<DashboardMst> findByAuthStatus(String authStatus);

	public List<DashboardMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
