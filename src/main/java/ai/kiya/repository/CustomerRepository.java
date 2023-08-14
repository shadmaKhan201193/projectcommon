package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.CountryMst2;
import ai.kiya.entity.CustomerMst2;
import ai.kiya.key.D009011Key;


@Repository
public interface CustomerRepository extends CommonRepository<CustomerMst2, D009011Key> {

	//public CustomerMst2 findByD009011Key(D009011Key dO009011Key);
	
	public CustomerMst2 findByMemberCode(Integer  id);

	public List<CustomerMst2> findByAuthStatus(String authStatus);
	public List<CustomerMst2> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
}
