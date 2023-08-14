package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.PasswordPolicyMst;
import ai.kiya.entity.PortletMst;
import ai.kiya.key.D009509Key;

@Repository
public interface PortletRepository extends CommonRepository<PortletMst, D009509Key> {

	
	public PortletMst findByPortletCode(String portletCode);

	//public PortletMst findByPortletId(String  portletId);
	public List<PortletMst> findByAuthStatus(String authStatus);
	public List<PortletMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
}
