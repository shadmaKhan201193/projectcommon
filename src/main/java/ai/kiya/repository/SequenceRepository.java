package ai.kiya.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ai.kiya.entity.RoleMst;
import ai.kiya.entity.SeqFileGen;
import ai.kiya.key.SeqKey;

@Repository
public interface SequenceRepository  extends CommonRepository<SeqFileGen, SeqKey> {
	
	public SeqFileGen findByBranchCode(String branchCode);
	//public SeqFileGen findBySeqKey(SeqKey seqKey);


	public List<SeqFileGen> findByAuthStatus(String authStatus);
	public SeqFileGen findBySeqId(String id);
	
	public List<SeqFileGen> findByTenantIdAndIsActiveAndAuthStatus(Integer tenantId,Integer isActive,String authStatus);


}
