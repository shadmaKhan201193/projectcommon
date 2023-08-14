package ai.kiya.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@MappedSuperclass
public class Base implements Serializable {

	private static final long serialVersionUID = 1701926931204630606L;

	@Version
	@JsonProperty(access = Access.WRITE_ONLY)
	protected Integer version = 0;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true)
	protected Long activityId = 0L;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 100, nullable = true)
	private String description = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true, updatable = false)
	protected String createdBy = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true, updatable = false)
	protected Date createdDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false, updatable = false)
	private Date createdTime;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	protected String lastModifiedBy = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true)
	private Integer isActive = 1;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true, length = 8)
	private String authStatus = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true)
	protected Date lastModifiedDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = false)
	private Date lastModifiedTime;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	protected String deprecatedBy = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true)
	protected Date deprecatedDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(nullable = true)
	private Date deprecatedTime;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Basic
	Boolean deprecated = false;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public Double initDouble = 0.00;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public int initInteger = 0;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public String initString = " ";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public long initLongInt = 0L;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public BigDecimal initBDInt = BigDecimal.ZERO;

////////////added for auth check ///

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public String authChecker1 = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public Date authCheckerDate1;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public String authChecker2 = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public Date authCheckerDate2;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public String authChecker3 = "";

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(length = 10, nullable = true)
	public Date authCheckerDate3;

//////////////
	
	
	
	
	public Date getCreatedTime() {
		return createdTime;
	}

	public String getAuthChecker1() {
		return authChecker1;
	}

	public void setAuthChecker1(String authChecker1) {
		this.authChecker1 = authChecker1;
	}

	public Date getAuthCheckerDate1() {
		return authCheckerDate1;
	}

	public void setAuthCheckerDate1(Date authCheckerDate1) {
		this.authCheckerDate1 = authCheckerDate1;
	}

	public String getAuthChecker2() {
		return authChecker2;
	}

	public void setAuthChecker2(String authChecker2) {
		this.authChecker2 = authChecker2;
	}

	public Date getAuthCheckerDate2() {
		return authCheckerDate2;
	}

	public void setAuthCheckerDate2(Date authCheckerDate2) {
		this.authCheckerDate2 = authCheckerDate2;
	}

	public String getAuthChecker3() {
		return authChecker3;
	}

	public void setAuthChecker3(String authChecker3) {
		this.authChecker3 = authChecker3;
	}

	public Date getAuthCheckerDate3() {
		return authCheckerDate3;
	}

	public void setAuthCheckerDate3(Date authCheckerDate3) {
		this.authCheckerDate3 = authCheckerDate3;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/*
	 * public Integer getTenantId() { return tenantId; }
	 * 
	 * public void setTenantId(Integer tenantId) { this.tenantId = tenantId; }
	 */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getDeprecatedBy() {
		return deprecatedBy;
	}

	public void setDeprecatedBy(String deprecatedBy) {
		this.deprecatedBy = deprecatedBy;
	}

	public Date getDeprecatedDate() {
		return deprecatedDate;
	}

	public void setDeprecatedDate(Date deprecatedDate) {
		this.deprecatedDate = deprecatedDate;
	}

	public Date getDeprecatedTime() {
		return deprecatedTime;
	}

	public void setDeprecatedTime(Date deprecatedTime) {
		this.deprecatedTime = deprecatedTime;
	}

	public Boolean getDeprecated() {
		return deprecated;
	}

	public void setDeprecated(Boolean deprecated) {
		this.deprecated = deprecated;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public Date initDate() {
		String intialDate = "01-JAN-1900";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		try {
			return sdf.parse(intialDate);
		} catch (ParseException e) {
			return null;
		}
	}

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public Integer noOfAuthNeeded = 1;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public Boolean conCurChkYN = true;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	public Boolean uaeYN = false;

	public Integer getNoOfAuthNeeded() {
		return noOfAuthNeeded;
	}

	public void setNoOfAuthNeeded(Integer noOfAuthNeeded) {
		this.noOfAuthNeeded = noOfAuthNeeded;
	}

	public Boolean getConCurChkYN() {
		return conCurChkYN;
	}

	public void setConCurChkYN(Boolean conCurChkYN) {
		this.conCurChkYN = conCurChkYN;
	}

	public Boolean getUaeYN() {
		return uaeYN;
	}

	public void setUaeYN(Boolean uaeYN) {
		this.uaeYN = uaeYN;
	}

	public String setterStringReplace(String str) {
		str = str.replace("_", "\\_").replace("%", "\\%").replace("'", "\\'");
		return str;
	}

	public String getterStringReplace(String str) {
		str = str.replace("\\_", "_").replace("\\%", "%").replace("\\'", "'");
		return str;
	}

}
