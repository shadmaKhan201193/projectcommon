package ai.kiya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ai.kiya.entity.SeqFileGen;
import ai.kiya.entity.StateMst2;

@Repository
public interface StateRepository extends JpaRepository<StateMst2,String> {

	public StateMst2 findByStateCode(String Id);
	
	public List<StateMst2> findByAuthStatus(String authStatus);
	
	public List<StateMst2> findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode(Integer tenantId,Integer isActive,
			String authStatus, String languageCode);
	
	public List<StateMst2> findByTenantIdAndIsActiveAndAuthStatusAndCountryCodeAndLanguageCode(Integer tenantId,Integer isActive,
			String authStatus, String countryCode, String languageCode);
}
