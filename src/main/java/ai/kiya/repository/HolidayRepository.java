package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.EmployeeMst;
import ai.kiya.entity.HolidayBranchMap;
import ai.kiya.key.D009401Key;

@Repository
public interface HolidayRepository extends CommonRepository<HolidayBranchMap, D009401Key> {

	public HolidayBranchMap findByHolidayCode(String holidayCode);


	public List<HolidayBranchMap> findByAuthStatus(String authStatus);
	public HolidayBranchMap findByHolidayId(String id);
	
	public List<HolidayBranchMap> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
}
