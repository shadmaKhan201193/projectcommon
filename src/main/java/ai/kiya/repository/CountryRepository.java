package ai.kiya.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ai.kiya.entity.CountryMst2;

@Repository
public interface CountryRepository extends CommonRepository<CountryMst2, Long> {
	
	@PersistenceContext 
	public  EntityManager em = null;
	
	public CountryMst2 findByCountryCode(String Id);
	
	public  List<CountryMst2> findByAuthStatus(String auth);

	public List<CountryMst2> findByTenantIdAndIsActiveAndAuthStatusAndLanguageCode(Integer tenantId,Integer isActive,String authStatus,String languageCode);

    

    
}
