package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.CountryMst2;
import ai.kiya.entity.CurrencyMst;
import ai.kiya.key.D001012Key;

@Repository
public interface CurrencyRepository extends CommonRepository<CurrencyMst, D001012Key> {
	
    public CurrencyMst findByCurrencyIsoCode(String currencyIsoCode);
	
	//public CurrencyMst findByCurrencyId(String  lookupId);

	public List<CurrencyMst> findByAuthStatus(String authStatus);
	
	public List<CurrencyMst> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);
	}
	
	
	

