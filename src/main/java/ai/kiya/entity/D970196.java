package ai.kiya.entity;
import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import ai.kiya.base.Base2;
import ai.kiya.key.D970196Key;
import ai.kiya.key.RoleKey;

@Entity
@IdClass(D970196Key.class)
public class D970196 extends  Base2 {

private static final long serialVersionUID = 1L;
	
//	@EmbeddedId
//	private D970196Key d970196Key ;
	

	
	////
	@Id
	@Column(nullable = false)
	private Integer paramNo;
	
	
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	
	@Id
	@Column(nullable = false)
	private Integer lbrCode;

	@Id
	@Column(nullable = false, length =80)
	private String reportId  = "";
	
	///
	
	@Column(nullable = true, length =40)
	private String paramName  = "";

	
	@Column(nullable = true, length =80)
	private String paramDesc  = "";


	@Column(nullable = true, length =30)
	private String paramDataType  = "";


	@Column(nullable = true, length =80)
	private String defaultValue  = "";

	
	@Column(nullable = true, length =80)
	private String actualValue  = "";


	@Column(nullable = true, length =20)
	private String allowFutureDt  = "";   


	@Column(nullable = true, length =10)
	private String allowIMPLDt  = "";
	

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tenantId",referencedColumnName = "tenantId", insertable = false, updatable = false),
		@JoinColumn(name = "lbrCode",referencedColumnName = "lbrCode", insertable = false, updatable = false),
		@JoinColumn(name = "reportId",referencedColumnName = "reportId", insertable = false, updatable = false),
	})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private ReportMst reportMst;

	@JsonProperty(access = Access.WRITE_ONLY) 
	@Column(nullable = true, length =60)
	private String authStatus = "";
	
	@JsonProperty(access = Access.WRITE_ONLY) 
	@Column(nullable = true, length = 1)
	private Integer isActive;

	@JsonProperty(access = Access.WRITE_ONLY) 
	@Column(nullable = false, length =19)
	private Long srNo = 0L;
	
	//@Column(columnDefinition = "nvarchar(50) default ' '", nullable = false)
	@Column(nullable = false, length =50)
	private String lookupCode = ""; // menuCode will remain same across all
	
	public String getLookupCode() {
		if (null != lookupCode) {
		} else {
			lookupCode = super.initString;
		}
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	@Transient
	public Long getSrNo() {
		return srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	

	public String getParamName() {
		if (null != paramName) {
		} else {
			paramName = super.initString;
		}
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamDesc() {
		if (null != paramDesc) {
		} else {
			paramDesc = super.initString;
		}
		return paramDesc;
	}

	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}

	public String getParamDataType() {
		if (null != paramDataType) {
		} else {
			paramDataType = super.initString;
		}
		return paramDataType;
	}

	public void setParamDataType(String paramDataType) {
		this.paramDataType = paramDataType;
	}

	public String getDefaultValue() {
		if (null != defaultValue) {
		} else {
			defaultValue = super.initString;
		}
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getActualValue() {
		if (null != actualValue) {
		} else {
			actualValue = super.initString;
		}
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	public String getAllowFutureDt() {
		if (null != allowFutureDt) {
		} else {
			allowFutureDt = super.initString;
		}
		return allowFutureDt;
	}

	public void setAllowFutureDt(String allowFutureDt) {
		this.allowFutureDt = allowFutureDt;
	}

	public String getAllowIMPLDt() {
		if (null != allowIMPLDt) {
		} else {
			allowIMPLDt = super.initString;
		}
		return allowIMPLDt;
	}

	public void setAllowIMPLDt(String allowIMPLDt) {
		this.allowIMPLDt = allowIMPLDt;
	}

	

	public String getAuthStatus() {
		if (null != authStatus) {
		} else {
			authStatus = super.initString;
		}
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public Integer getIsActive() {
		if (null != isActive) {
		} else {
			isActive = super.initInteger;
		}
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public ReportMst getReportMst() {
		return reportMst;
	}

	public void setReportMst(ReportMst reportMst) {
		this.reportMst = reportMst;
	}

	public Integer getParamNo() {
		return paramNo;
	}

	public void setParamNo(Integer paramNo) {
		this.paramNo = paramNo;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getLbrCode() {
		return lbrCode;
	}

	public void setLbrCode(Integer lbrCode) {
		this.lbrCode = lbrCode;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramNo == null) ? 0 : paramNo.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((lbrCode == null) ? 0 : lbrCode.hashCode());
		result = prime * result + ((reportId== null) ? 0 : reportId.hashCode());
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
		D970196 other = (D970196) obj;
		if (paramNo == null) {
			if (other.paramNo != null)
				return false;
		} else if (!paramNo.equals(other.paramNo))
			return false;

		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;

		if (lbrCode == null) {
			if (other.lbrCode != null)
				return false;
		} else if (!lbrCode.equals(other.lbrCode))
			return false;
				
		if (reportId == null) {
			if (other.reportId!= null)
				return false;
		} else if (!reportId.equals(other.reportId))
			return false;
		return true;
	}
	
	
}
