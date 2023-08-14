package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.CalenderMst;
import ai.kiya.key.D001013Key;
@Repository
public interface CalenderRepository extends CommonRepository<CalenderMst, D001013Key> {
	//public CalenderMst findByD001013Key(D001013Key d001013Key);

	public List<CalenderMst> findByAuthStatus(String authStatus);
	public CalenderMst findByBranchCode(Integer id);
	public List<CalenderMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
