package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.DashboardMst;
import ai.kiya.entity.EmployeeMst;
import ai.kiya.key.EmployeeKey;

@Repository
public interface EmployeeRepository extends CommonRepository<EmployeeMst, EmployeeKey> {
	

	
	public EmployeeMst findByEmpId(String  id);

	public List<EmployeeMst> findByAuthStatus(String authStatus);
	public List<EmployeeMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);

}
