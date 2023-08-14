package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D002046Key;

@Table(name="D002046")
@Entity
@IdClass(D002046Key.class)
public class UserLoginSuspenMst extends Base{

	
	private static final long serialVersionUID = 1L;
	
//	@EmbeddedId
//	private D002046Key d002046Key = new D002046Key();

	@Column
	private Integer srNo = 1; // srNo is a running number from Sequence Table



	@Column(nullable = true)
	private Date suspendTillDate; // Cannot be less than the FromDate
	
	@Column(nullable = true)
	private Date suspendCreateDate;
	

	@Column(length=250, nullable = true)
	private String remarks = ""; // Optional

	@Column(length=1000, nullable = true)
	private String status = "";

	@Temporal(TemporalType.TIMESTAMP)
	private Date recordOprnDate; // to be updated when the record is inserted

	
	@Transient
	private String fromDate = "";
	
	@Transient
	private String toDate = "";
	
	@Column(nullable = true)
	private String suspendFromTime;
	

	@Column(nullable = true)
	private String suspendToTime;
	
	
	////
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId=0;
	
	@Id
	@Column(length=10, nullable = false)
	private String loginId = ""; 
	
	@Id
	@Column(nullable = false)
	private Date suspendFromDate; 
	
	///
	
	public String getSuspendFromTime() {
		return suspendFromTime;
	}

	public void setSuspendFromTime(String suspendFromTime) {
		this.suspendFromTime = suspendFromTime;
	}

	public String getSuspendToTime() {
		return suspendToTime;
	}

	public void setSuspendToTime(String suspendToTime) {
		this.suspendToTime = suspendToTime;
	}

	public Date getSuspendCreateDate() {
		return suspendCreateDate;
	}

	public void setSuspendCreateDate(Date suspendCreateDate) {
		this.suspendCreateDate = suspendCreateDate;
	}

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
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

	


	public String getRemarks() {
		if(null!=remarks ){} else {remarks = super.initString;}
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		if(null!=status ){} else {status = super.initString;}
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRecordOprnDate() {
		return recordOprnDate;
	}

	public void setRecordOprnDate(Date recordOprnDate) {
		this.recordOprnDate = recordOprnDate;
	}

	

	public Date getSuspendTillDate() {
		return suspendTillDate;
	}

	public void setSuspendTillDate(Date suspendTillDate) {
		this.suspendTillDate = suspendTillDate;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public Date getSuspendFromDate() {
		return suspendFromDate;
	}

	public void setSuspendFromDate(Date suspendFromDate) {
		this.suspendFromDate = suspendFromDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((suspendFromDate == null) ? 0 : suspendFromDate.hashCode());
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
		UserLoginSuspenMst other = (UserLoginSuspenMst) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (suspendFromDate == null) {
			if (other.suspendFromDate != null)
				return false;
		} else if (!suspendFromDate.equals(other.suspendFromDate))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}


}
