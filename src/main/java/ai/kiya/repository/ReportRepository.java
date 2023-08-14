package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.PortletMst;
import ai.kiya.entity.ReportMst;
import ai.kiya.key.D970096Key;

@Repository
public interface ReportRepository extends CommonRepository<ReportMst, D970096Key> {
	
	 // public ReportMst findByD970096Key(D970096Key d970096Key);
	
		public ReportMst  findByReportId(String reportId);
		public ReportMst findByReportIddesc(String  Id);

		public List<ReportMst> findByAuthStatus(String authStatus);
		public List<ReportMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
		
}
