package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.UserMst;
import ai.kiya.entity.VillageMst;
import ai.kiya.key.D500025Key;

@Repository
public interface VillageRepository extends CommonRepository<VillageMst, D500025Key> {
	//public VillageMst findByD002043Key(D002043Key d002043Key);
	
	public VillageMst findByVillageCode(String  villageCode);


	public List<VillageMst> findByAuthStatus(String authStatus);
	public List<VillageMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	
	public List<VillageMst> findByTenantIdAndIsActiveAndAuthStatusAndCountryAndStateAndCityAndLanguage(Integer tenantId, Integer isActive,
			String authStatus, String country, String state, String city, String language);
}
