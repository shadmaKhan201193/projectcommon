package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.CityMst2;

@Repository
public interface CityRepository extends CommonRepository<CityMst2, Long> {

	public CityMst2 findByNumCityCode(String Id);
	
	public List<CityMst2> findByAuthStatus(String authStatus);
	public List<CityMst2> findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode(Integer tenantId,Integer isActive,String authStatus,String languageCode);
	
	public List<CityMst2> findByTenantIdAndIsActiveAndAuthStatusAndCountryCodeAndStateCodeAndLanguageCode(Integer tenantId,Integer isActive,
			String authStatus,String countryCode,String stateCode,String languageCode);
	
}
