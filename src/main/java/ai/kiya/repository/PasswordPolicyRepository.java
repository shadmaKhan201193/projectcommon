package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.PasswordPolicyMst;
import ai.kiya.key.D009501Key;

@Repository
public interface PasswordPolicyRepository extends CommonRepository<PasswordPolicyMst, D009501Key> {

	// public PasswordPolicyMst findByTenantId(D009501Key d009501Key);

	public List<PasswordPolicyMst> findByAuthStatus(String authStatus);

	public PasswordPolicyMst findById(String id);

	public List<PasswordPolicyMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId, Integer isActive,
			String authStatus);

}
