package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.omni.OmniConstants;

@Table(name = "AppConfigMst")
@Entity
public class AppConfigMst extends Base {
	
	private static final long serialVersionUID = 1701926931204630606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	
	@Column(nullable = true, length = 20)
	private String branchCode = "";

	private Date effFromDate;					

	@Transient
	private String strEffFromDate;

	private Date effToDate;

	@Transient
	private String strEffToDate;

	@Column(nullable = true, length = 20)
	private Long setNo;

	@Column(nullable = true, length = 40)
	private String dateFormatStr = "";

	@Column(nullable = true, length = 40)
	private String numberFormatStr = "";

	@Column(nullable = true, length = 40)
	private String amountFormatStr = "";

	@Column(nullable = true, length = 40)
	private String decimalCharacter = "";

	@Column(nullable = true, length = 40)
	private String digitSeparator = "";

	@Column(nullable = true)
	private Integer paginationSize = 10;

	@Column(nullable = true) 
	private Integer CustomerIdLen = 0;

	@Column(nullable = true, length = 40)
	private String CustomerIdLenTypeCode = ""; // from lookup (system)

	@Column(nullable = true, length = 20)
	private String customerIdGenType = "";
	
	@Column(nullable = true, length = 2)
	private String borrowingRequired = "N";
//	
//	@Column(nullable = true)
//	private Boolean isActive = true;
//
//	@Column(nullable = true, length = 60)
//	private String authStatus = "";

	
	
	
	@Column(nullable = true, length = 1000)
	private String signPhotoUploadDirPath = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	@Column(nullable = true, length = 1000)
	private String signPhotoDownloadDirPath = "";

	@Column(nullable = true)
	private Double smallFarmerArea = 2.0d;							// for PACS module

	@Column(nullable = true)
	private Double perShareAmount=0D;								// for Shares module (48)
	
	@Column(nullable = true)
	private Boolean allowConcurrentLogin = true;

	@Column(nullable = true)
	private Integer consecutiveBadLoginCount = 5;

	@Column(nullable = true, length = 500)
	private String ruleFilePath = ""; // drool's file path

	@Column(nullable = true, length = 1000)
	private String systemFilePath = ""; // System file path

	@Column(nullable = true)
	private Integer recentLinks=5;

	@Column(nullable = true)
	private Integer quickLinks=5;

	@Column(nullable = true, length = 20)
	private String accntNoGenType = OmniConstants.GLOBAL_GEN;
	
	@Column(length = 3, nullable = true)
	private String homeCurrency = "";

	private String menuCodeString;
	
	
	
	public String getAccntNoGenType() {
		if(null!=accntNoGenType ){} else {accntNoGenType = super.initString;}
		return accntNoGenType;
	}

	public void setAccntNoGenType(String accntNoGenType) {
		this.accntNoGenType = accntNoGenType;
	}
	public Double getSmallFarmerArea() {
		if(null!=smallFarmerArea ){} else {smallFarmerArea = super.initDouble;}
		return smallFarmerArea;
	}

	public void setSmallFarmerArea(Double smallFarmerArea) {
		this.smallFarmerArea = smallFarmerArea;
	}

//	public Long getId() {
//		if(null!=id ){} else {id = super.initLongInt;}
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getBranchCode() {
		if(null!=branchCode ){} else {branchCode = super.initString;}
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getDateFormatStr() {
		if(null!=dateFormatStr ){} else {dateFormatStr = super.initString;}
		return dateFormatStr;
	}

	public void setDateFormatStr(String dateFormatStr) {
		this.dateFormatStr = dateFormatStr;
	}

	public String getNumberFormatStr() {
		if(null!=numberFormatStr ){} else {numberFormatStr = super.initString;}
		return numberFormatStr;
	}

	public void setNumberFormatStr(String numberFormatStr) {
		this.numberFormatStr = numberFormatStr;
	}

	public String getStrEffFromDate() {
		if(null!=strEffFromDate ){} else {strEffFromDate = super.initString;}
		return strEffFromDate;
	}

	public void setStrEffFromDate(String strEffFromDate) {
		this.strEffFromDate = strEffFromDate;
	}

	public String getStrEffToDate() {
	if(null!=strEffToDate ){} else {strEffToDate = super.initString;}
		return strEffToDate;
	}

	public void setStrEffToDate(String strEffToDate) {
		this.strEffToDate = strEffToDate;
	}

	public String getAmountFormatStr() {
		if(null!=amountFormatStr ){} else {amountFormatStr = super.initString;}
		return amountFormatStr;
	}

	public void setAmountFormatStr(String amountFormatStr) {
		this.amountFormatStr = amountFormatStr;
	}

	public String getDecimalCharacter() {
		if(null!=decimalCharacter ){} else {decimalCharacter = super.initString;}
		return decimalCharacter;
	}

	public void setDecimalCharacter(String decimalCharacter) {
		this.decimalCharacter = decimalCharacter;
	}

	public String getDigitSeparator() {
		if(null!=digitSeparator ){} else {digitSeparator = super.initString;}
		return digitSeparator;
	}

	public void setDigitSeparator(String digitSeparator) {
		this.digitSeparator = digitSeparator;
	}

	/*
	 * public Integer getCustomerIdLen() { return CustomerIdLen; }
	 * 
	 * public void setCustomerIdLen(Integer customerIdLen) { CustomerIdLen =
	 * customerIdLen; }
	 */

	public String getCustomerIdLenTypeCode() {
		if(null!=CustomerIdLenTypeCode ){} else {CustomerIdLenTypeCode = super.initString;}
		return CustomerIdLenTypeCode;
	}

	public void setCustomerIdLenTypeCode(String customerIdLenTypeCode) {
		CustomerIdLenTypeCode = customerIdLenTypeCode;
	}

	public Long getSetNo() {
		if(null!=setNo ){} else {setNo = super.initLongInt;}
		return setNo;
	}

	public void setSetNo(Long setNo) {
		this.setNo = setNo;
	}

	public String getCustomerIdGenType() {
		if(null!=customerIdGenType ){} else {customerIdGenType = super.initString;}
		return customerIdGenType;
	}

	public void setCustomerIdGenType(String customerIdGenType) {
		this.customerIdGenType = customerIdGenType;
	}

	public Integer getPaginationSize() {
		if(null!=paginationSize ){} else {paginationSize = super.initInteger;}
		return paginationSize;
	}

	public void setPaginationSize(Integer paginationSize) {
		this.paginationSize = paginationSize;
	}

//	public String getAuthStatus() {
//		if(null!=authStatus ){} else {authStatus = super.initString;}
//		return authStatus;
//	}
//
//	public void setAuthStatus(String authStatus) {
//		this.authStatus = authStatus;
//	}
//
//	public Boolean getIsActive() {
//		return isActive;
//	}
//
//	public void setIsActive(Boolean isActive) {
//		this.isActive = isActive;
//	}

	public Date getEffFromDate() {
		if(null!=effFromDate ){} else {effFromDate = super.initDate();}
		return effFromDate;
	}

	public void setEffFromDate(Date effFromDate) {
		this.effFromDate = effFromDate;
	}

	public Date getEffToDate() {
		if(null!=effToDate ){} else {effToDate = super.initDate();}
		return effToDate;
	}

	public void setEffToDate(Date effToDate) {
		this.effToDate = effToDate;
	}

	public String getSignPhotoUploadDirPath() {
		if(null!=signPhotoUploadDirPath ){} else {signPhotoUploadDirPath = super.initString;}
		return signPhotoUploadDirPath;
	}

	public void setSignPhotoUploadDirPath(String signPhotoUploadDirPath) {
		this.signPhotoUploadDirPath = signPhotoUploadDirPath;
	}

	public String getSignPhotoDownloadDirPath() {
		if(null!=signPhotoDownloadDirPath ){} else {signPhotoDownloadDirPath = super.initString;}
		return signPhotoDownloadDirPath;
	}

	public void setSignPhotoDownloadDirPath(String signPhotoDownloadDirPath) {
		this.signPhotoDownloadDirPath = signPhotoDownloadDirPath;
	}

	public Boolean getAllowConcurrentLogin() {
		if(null!=allowConcurrentLogin ){} else {allowConcurrentLogin = false;}	
		return allowConcurrentLogin;
	}

	public void setAllowConcurrentLogin(Boolean allowConcurrentLogin) {
		this.allowConcurrentLogin = allowConcurrentLogin;
	}

	public Integer getConsecutiveBadLoginCount() {
		if(null!=consecutiveBadLoginCount ){} else {consecutiveBadLoginCount = super.initInteger;}
		return consecutiveBadLoginCount;
	}

	public void setConsecutiveBadLoginCount(Integer consecutiveBadLoginCount) {
		this.consecutiveBadLoginCount = consecutiveBadLoginCount;
	}

	public String getRuleFilePath() {
		if(null!=ruleFilePath ){} else {ruleFilePath = super.initString;}
		return ruleFilePath;
	}

	public void setRuleFilePath(String ruleFilePath) {
		this.ruleFilePath = ruleFilePath;
	}

	public String getSystemFilePath() {
	if(null!=systemFilePath ){} else {systemFilePath = super.initString;}
		return systemFilePath;
	}

	public void setSystemFilePath(String systemFilePath) {
		this.systemFilePath = systemFilePath;
	}

//	public AuthMKCK setAuthMkCkFields(AuthMKCK authMkCk) {
//		authMkCk.setRefID(getId());
//		authMkCk.setMenuAction("appConfigCRUD.action");
//		authMkCk.setEntityEntryCode(getBranchCode());
//		return authMkCk;
//	}

	public Integer getRecentLinks() {
		if(null!=recentLinks ){} else {recentLinks = super.initInteger;}
		return recentLinks;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRecentLinks(Integer recentLinks) {
		this.recentLinks = recentLinks;
	}

	public Integer getQuickLinks() {
		if(null!=quickLinks ){} else {quickLinks = super.initInteger;}
		return quickLinks;
	}

	public void setQuickLinks(Integer quickLinks) {
		this.quickLinks = quickLinks;
	}

	public Integer getCustomerIdLen() {
		if(null!=CustomerIdLen ){} else {CustomerIdLen = super.initInteger;}
		return CustomerIdLen;
	}

	public void setCustomerIdLen(Integer customerIdLen) {
		CustomerIdLen = customerIdLen;
	}

	public Double getPerShareAmount() {
		if(null!=perShareAmount ){} else {perShareAmount = super.initDouble;}
		return perShareAmount;
	}

	public void setPerShareAmount(Double perShareAmount) {
		this.perShareAmount = perShareAmount;
	}

	public String getBorrowingRequired() {
		if(null!=borrowingRequired ){} else {borrowingRequired = super.initString;}
		return borrowingRequired;
	}

	public void setBorrowingRequired(String borrowingRequired) {
		this.borrowingRequired = borrowingRequired;
	}

	public String getHomeCurrency() {
		if(null!=homeCurrency ){} else {homeCurrency = super.initString;}
		return homeCurrency;
	}

	public void setHomeCurrency(String homeCurrency) {
		this.homeCurrency = homeCurrency;
	}
}
