package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.SeqKey;

@Table(name = "SeqFileGen")
@Entity
@IdClass(SeqKey.class)
public class SeqFileGen extends Base{
	
	private static final long serialVersionUID = -7302788561829784335L;

//	@EmbeddedId
//	private SeqKey seqKey;
	//
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId=0;
	

	@Id
	@Column(length=10,nullable = false)
	private String branchCode = "";

	@Id
	@Column(length=4, nullable = false)
	private String trailApply = "";

	@Id
	@Column(length=4, nullable = false)
	private String fromDate = "";

	@Id
	@Column(length=20, nullable = false)
	private String toDate = "";
	//
	
	@Column(nullable=true, columnDefinition="nvarchar(600)")
	private String seqId="";
	
	@Column(nullable=true, columnDefinition="nvarchar(600)")
	private String fileName="";
	
	@Column(nullable=true)
	private Boolean satSunCourier;
	
	@Column(nullable=true)
	private Boolean onlyWelcomeKit;
	
	@Column(nullable=true,columnDefinition="nvarchar(40)")
	private String chequeType="";
	
	
//	public SeqKey getSeqKey() {
//		return seqKey;
//	}
//
//	public void setSeqKey(SeqKey seqKey) {
//		this.seqKey = seqKey;
//	}

	public String getSeqId() {
		return seqId;
	}

	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Boolean getSatSunCourier() {
		return satSunCourier;
	}

	public void setSatSunCourier(Boolean satSunCourier) {
		this.satSunCourier = satSunCourier;
	}

	public Boolean getOnlyWelcomeKit() {
		return onlyWelcomeKit;
	}

	public void setOnlyWelcomeKit(Boolean onlyWelcomeKit) {
		this.onlyWelcomeKit = onlyWelcomeKit;
	}

	public String getChequeType() {
		return chequeType;
	}

	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getTrailApply() {
		return trailApply;
	}

	public void setTrailApply(String trailApply) {
		this.trailApply = trailApply;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((toDate == null) ? 0 : toDate.hashCode());
		result = prime * result + ((fromDate == null) ? 0 : fromDate.hashCode());
		result = prime * result + ((trailApply == null) ? 0 : trailApply.hashCode());
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeqFileGen other = (SeqFileGen) obj;
		if (toDate == null) {
			if (other.toDate != null)
				return false;
		} else if (!toDate.equals(other.toDate))
			return false;
		if (fromDate == null) {
			if (other.fromDate != null)
				return false;
		} else if (!fromDate.equals(other.fromDate))
			return false;
		if (trailApply == null) {
			if (other.trailApply != null)
				return false;
		} else if (!trailApply.equals(other.trailApply))
			return false;
		if (branchCode == null) {
			if (other.branchCode != null)
				return false;
		} else if (!branchCode.equals(other.branchCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
}
