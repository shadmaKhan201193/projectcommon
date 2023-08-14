package ai.kiya.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D001003Key;

@Table(name = "D001003")
@Entity
@IdClass(D001003Key.class)
public class BranchMst extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D001003Key d001003Key = new D001003Key();

	//
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 6, nullable = false)
	private Integer branchCode = 0;//

	//
	@Column(length = 200, nullable = true)
	private String branchName = "";

	@Column(length = 200, nullable = false)
	private String branchId = "";

	@Transient
	private String branchTypeName = "";

	@Column(length = 6, nullable = false)
	private Integer branchTypeCode = 0;

	@Column(length = 6, nullable = true)
	private Integer branchCategoryType = 0;

	@Column(length = 6, nullable = false)
	private Integer parentBranchCode = 0;

	@Column(length = 6, nullable = true)
	private Integer parentBranchCode1 = 0;

	@Column(length = 6, nullable = true)
	private Integer parentBranchCode2 = 0;

	@Column(length = 6, nullable = true)
	private Integer parentBranchCode3 = 0;

	@Column(length = 4, nullable = true)
	private Integer branchStatus = 0;

	@Column(length = 4, nullable = true)
	private String accountingBranchCode = "";

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getAccountingBranchCode() {
		return accountingBranchCode;
	}

	public void setAccountingBranchCode(String accountingBranchCode) {
		this.accountingBranchCode = accountingBranchCode;
	}

	public Integer getBranchStatus() {
		return branchStatus;
	}

	public void setBranchStatus(Integer branchStatus) {
		this.branchStatus = branchStatus;
	}

	@Column(length = 200, nullable = true)
	private String address1 = "";
	@Column(length = 200, nullable = true)
	private String address2 = "";
	@Column(length = 200, nullable = true)
	private String address3 = "";
	@Column(length = 4, nullable = true)
	private String villageCode = "";
	@Column(length = 4, nullable = true)
	private String municipalityCode = "";
	@Column(length = 4, nullable = true)
	private String districtCode = "";
	@Column(length = 4, nullable = true)
	private String stateCode = "";
	@Column(length = 4, nullable = true)
	private String countryCode = "";
	@Column(length = 15, nullable = true)
	private String postalCode = "";

	@Transient
	private Map<Integer, String> moduleMap = new HashMap<Integer, String>();

	@Column(length = 6, nullable = false)
	private Integer branchRefCode = 0;

	@Column(length = 200, nullable = true)
	private String contactPerson = "";

	@Column(length = 15, nullable = true)
	private String faxNumber = "";

	@Column(length = 15, nullable = true)
	private String tele1 = "";

	@Column(length = 15, nullable = true)
	private String tele2 = "";

	@Column(length = 60, nullable = true)
	private String emailId = "";

	@Column(length = 40, nullable = true)
	private String branchDayFromCode = "";

	@Column(length = 40, nullable = true)
	private String branchDayToCode = "";

	// @Column(columnDefinition = "DATETIME")
	@Column(nullable = true)
	private Date branchFromTime;

	// @Column(columnDefinition = "DATETIME")
	@Column(nullable = true)
	private Date branchToTime;

	@Column(length = 40, nullable = true)
	private String finYearFromCode = "";

	@Column(length = 40, nullable = true)
	private String finYearToCode = "";

	@Column(length = 40, nullable = true)
	private String weeklyOff1Code = "";

	@Column(length = 40, nullable = true)
	private String weeklyOff2Code = "";

	@Column(length = 40, nullable = true)
	private String weeklyHalfOff1Code = "";

	@Column(length = 40, nullable = true)
	private String weeklyHalfOff2Code = "";

//	@Column(length = 40, nullable = true)
//	private String nonWorkingHalfOffs = ""; // comma separated values: 1,2,3,4,5

	@Column(length = 3, nullable = true)
	private String baseCurrency = ""; // Reference: Currency Master

	@Column(length = 60, nullable = true)
	private String ipNo = "";

	@Column(length = 60, nullable = true)
	private String clusterNo = "";

	@Column(length = 1, nullable = false)
	private Integer isActive;

	@Column(nullable = true, length = 1)
	private String authStatus = "";

	@Column(nullable = true, length = 20)
	private String ifscCode = "";

	@Column(nullable = true, length = 20)
	private String micrCode = "";

	@Column(nullable = true, length = 32)
	private String glCode = "";

	// @Column(columnDefinition = "DATETIME")
	@Column(nullable = true)
	private Date bod;

	// @Column(columnDefinition = "DATETIME")
	@Column(nullable = true)
	private Date eod;

	@Column(length = 1, nullable = true)
	private Integer bodFlag = 0;

	@Column(length = 1, nullable = true)
	private Integer eodFlag = 0;

	@Column(nullable = true, length = 15)
	private String swiftCode = "";

	@Transient
	private String branchFromTime_str = "";

	@Transient
	private String branchToTime_str = "";

	@Column(length = 10, nullable = true)
	private String areaManager = "";

	@Column(length = 10, nullable = true)
	private String sfo1 = "";

	@Column(length = 10, nullable = true)
	private String sfo2 = "";

	@Column(length = 10, nullable = true)
	private String sfo3 = "";

	@Column(length = 10, nullable = true)
	private String sfo4 = "";

	@Column(length = 4, nullable = true)
	private Integer category = 0;

	@Column(length = 4, nullable = true)
	private Integer maxMembSubVillage = 0;

	@Column(length = 4, nullable = true)
	private Integer minMembGroup = 0;

	@Column(length = 4, nullable = true)
	private Integer maxMembGroup = 0;

	@Column(length = 4, nullable = true)
	private Integer minGrpSubVillage = 0;

	@Column(length = 4, nullable = true)
	private Integer maxGrpSubVillage = 0;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingOffs1;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingOffs2;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingOffs3;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingOffs4;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingHalfOffs1;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingHalfOffs2;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingHalfOffs3;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingHalfOffs4;

	@Column(nullable = true, length = 1)
	private Integer nonWorkingHalfOffs5;

	@Column(nullable = true, length = 7)
	private Double latitude = 0.0;

	@Column(nullable = true, length = 7)
	private Double longitude = 0.0;

	@Column(nullable = true, length = 6)
	private String area;

	@Column(nullable = true, length = 6)
	private String municipalityBlock;

	@Column(nullable = true, length = 6)
	private String villCode;

	@Column(nullable = true)
	private Integer branchBusinessType;

	@Column(nullable = true)
	private Date brOpeningDate;

	@Column(nullable = true, length = 8)
	private String legacyBranchCode;

	@Column(nullable = true, length = 20)
	private String phoneNumber1;

	@Column(nullable = true, length = 20)
	private String phoneNumber2;

	@Column(nullable = true, length = 20)
	private String phoneNumber3;

	@Column(nullable = true, length = 20)
	private String phoneNumber4;

	public String getBranchFromTime_str() {
		return branchFromTime_str;
	}

	public void setBranchFromTime_str(String branchFromTime_str) {
		this.branchFromTime_str = branchFromTime_str;
	}

	public String getBranchToTime_str() {
		return branchToTime_str;
	}

	public void setBranchToTime_str(String branchToTime_str) {
		this.branchToTime_str = branchToTime_str;
	}

	public String getIfscCode() {
		if (null != ifscCode) {
		} else {
			ifscCode = super.initString;
		}
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getMicrCode() {
		if (null != micrCode) {
		} else {
			micrCode = super.initString;
		}
		return micrCode;
	}

	public void setMicrCode(String micrCode) {
		this.micrCode = micrCode;
	}

	public Integer getBodFlag() {
		if (null != bodFlag) {
		} else {
			bodFlag = super.initInteger;
		}
		return bodFlag;
	}

	public void setBodFlag(Integer bodFlag) {
		this.bodFlag = bodFlag;
	}

	public Integer getEodFlag() {
		if (null != eodFlag) {
		} else {
			eodFlag = super.initInteger;
		}
		return eodFlag;
	}

	public void setEodFlag(Integer eodFlag) {
		this.eodFlag = eodFlag;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getGlCode() {
		if (null != glCode) {
		} else {
			glCode = super.initString;
		}
		return glCode;
	}

	public void setGlCodeCode(String glCode) {
		this.glCode = glCode;
	}

	public String getBranchName() {
		if (null != branchName) {
		} else {
			branchName = super.initString;
		}
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Integer getBranchTypeCode() {
		if (null != branchTypeCode) {
		} else {
			branchTypeCode = super.initInteger;
		}
		return branchTypeCode;
	}

	public void setBranchTypeCode(Integer branchTypeCode) {
		this.branchTypeCode = branchTypeCode;
	}

	public Integer getParentBranchCode() {
		if (null != parentBranchCode) {
		} else {
			parentBranchCode = super.initInteger;
		}
		return parentBranchCode;
	}

	public void setParentBranchCode(Integer parentBranchCode) {
		this.parentBranchCode = parentBranchCode;
	}

	public void setBranchRefCode(Integer branchRefCode) {
		this.branchRefCode = branchRefCode;
	}

	public String getAddress1() {
		if (null != address1) {
		} else {
			address1 = super.initString;
		}
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		if (null != address2) {
		} else {
			address2 = super.initString;
		}
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		if (null != address3) {
		} else {
			address3 = super.initString;
		}
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getVillageCode() {
		if (null != villageCode) {
		} else {
			villageCode = super.initString;
		}
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getMunicipalityCode() {
		if (null != municipalityCode) {
		} else {
			municipalityCode = super.initString;
		}
		return municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

	public String getDistrictCode() {
		if (null != districtCode) {
		} else {
			districtCode = super.initString;
		}
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getStateCode() {
		if (null != stateCode) {
		} else {
			stateCode = super.initString;
		}
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		if (null != countryCode) {
		} else {
			countryCode = super.initString;
		}
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPostalCode() {
		if (null != postalCode) {
		} else {
			postalCode = super.initString;
		}
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

//	public List<D009021> getProducts() {
//		return products;
//	}
//
//	public void setProducts(List<D009021> products) {
//		this.products = products;
//	}

	/*
	 * public List<ModuleMst> getModules() { return modules; }
	 * 
	 * public void setModules(List<ModuleMst> modules) { this.modules = modules; }
	 */

	public Integer getBranchRefCode() {
		if (null != branchRefCode) {
		} else {
			branchRefCode = super.initInteger;
		}
		return branchRefCode;
	}

	/*
	 * public Collection<Address> getBranchAddresses() { return branchAddresses; }
	 * 
	 * public void setBranchAddresses(Collection<Address> branchAddresses) {
	 * this.branchAddresses = branchAddresses; }
	 */

	public String getContactPerson() {
		if (null != contactPerson) {
		} else {
			contactPerson = super.initString;
		}
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getFaxNumber() {
		if (null != faxNumber) {
		} else {
			faxNumber = super.initString;
		}
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getTele1() {
		if (null != tele1) {
		} else {
			tele1 = super.initString;
		}
		return tele1;
	}

	public void setTele1(String tele1) {
		this.tele1 = tele1;
	}

	public String getTele2() {
		if (null != tele2) {
		} else {
			tele2 = super.initString;
		}
		return tele2;
	}

	public void setTele2(String tele2) {
		this.tele2 = tele2;
	}

	public String getEmailId() {
		if (null != emailId) {
		} else {
			emailId = super.initString;
		}
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBranchDayFromCode() {
		if (null != branchDayFromCode) {
		} else {
			branchDayFromCode = super.initString;
		}
		return branchDayFromCode;
	}

	public void setBranchDayFromCode(String branchDayFromCode) {
		this.branchDayFromCode = branchDayFromCode;
	}

	public String getBranchDayToCode() {
		if (null != branchDayToCode) {
		} else {
			branchDayToCode = super.initString;
		}
		return branchDayToCode;
	}

	public void setBranchDayToCode(String branchDayToCode) {
		this.branchDayToCode = branchDayToCode;
	}

	public Date getBranchFromTime() {
		if (null != branchFromTime) {
		} else {
			branchFromTime = super.initDate();
		}
		return branchFromTime;
	}

	public void setBranchFromTime(Date branchFromTime) {
		this.branchFromTime = branchFromTime;
	}

	public Date getBranchToTime() {
		if (null != branchToTime) {
		} else {
			branchToTime = super.initDate();
		}
		return branchToTime;
	}

	public void setBranchToTime(Date branchToTime) {
		this.branchToTime = branchToTime;
	}

	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}

	public String getFinYearFromCode() {
		if (null != finYearFromCode) {
		} else {
			finYearFromCode = super.initString;
		}
		return finYearFromCode;
	}

	public void setFinYearFromCode(String finYearFromCode) {
		this.finYearFromCode = finYearFromCode;
	}

	public String getFinYearToCode() {
		if (null != finYearToCode) {
		} else {
			finYearToCode = super.initString;
		}
		return finYearToCode;
	}

	public void setFinYearToCode(String finYearToCode) {
		this.finYearToCode = finYearToCode;
	}

	public String getWeeklyOff1Code() {
		if (null != weeklyOff1Code) {
		} else {
			weeklyOff1Code = super.initString;
		}
		return weeklyOff1Code;
	}

	public void setWeeklyOff1Code(String weeklyOff1Code) {
		this.weeklyOff1Code = weeklyOff1Code;
	}

	public String getWeeklyOff2Code() {
		if (null != weeklyOff2Code) {
		} else {
			weeklyOff2Code = super.initString;
		}
		return weeklyOff2Code;
	}

	public void setWeeklyOff2Code(String weeklyOff2Code) {
		this.weeklyOff2Code = weeklyOff2Code;
	}

	public String getWeeklyHalfOff1Code() {
		if (null != weeklyHalfOff1Code) {
		} else {
			weeklyHalfOff1Code = super.initString;
		}
		return weeklyHalfOff1Code;
	}

	public void setWeeklyHalfOff1Code(String weeklyHalfOff1Code) {
		this.weeklyHalfOff1Code = weeklyHalfOff1Code;
	}

	public String getWeeklyHalfOff2Code() {
		if (null != weeklyHalfOff2Code) {
		} else {
			weeklyHalfOff2Code = super.initString;
		}
		return weeklyHalfOff2Code;
	}

	public void setWeeklyHalfOff2Code(String weeklyHalfOff2Code) {
		this.weeklyHalfOff2Code = weeklyHalfOff2Code;
	}

//	public String getNonWorkingHalfOffs() {
//		if (null != nonWorkingHalfOffs) {
//		} else {
//			nonWorkingHalfOffs = super.initString;
//		}
//		return nonWorkingHalfOffs;
//	}
//
//	public void setNonWorkingHalfOffs(String nonWorkingHalfOffs) {
//		this.nonWorkingHalfOffs = nonWorkingHalfOffs;
//	}

	public String getBaseCurrency() {
		if (null != baseCurrency) {
		} else {
			baseCurrency = super.initString;
		}
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getIpNo() {
		if (null != ipNo) {
		} else {
			ipNo = super.initString;
		}
		return ipNo;
	}

	public void setIpNo(String ipNo) {
		this.ipNo = ipNo;
	}

	public String getClusterNo() {
		if (null != clusterNo) {
		} else {
			clusterNo = super.initString;
		}
		return clusterNo;
	}

	public void setClusterNo(String clusterNo) {
		this.clusterNo = clusterNo;
	}

	public Integer getIsActive() {
		if (null != isActive) {
		} else {
			isActive = super.initInteger;
		}
		return isActive;
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

	public Date getBod() {
		if (null != bod) {
		} else {
			bod = super.initDate();
		}
		return bod;
	}

	public void setBod(Date bod) {
		this.bod = bod;
	}

	public Date getEod() {
		if (null != eod) {
		} else {
			eod = super.initDate();
		}
		return eod;
	}

	public void setEod(Date eod) {
		this.eod = eod;
	}

	public Map<Integer, String> getModuleMap() {
		return moduleMap;
	}

	public void setModuleMap(Map<Integer, String> moduleMap) {
		this.moduleMap = moduleMap;
	}

	public String getBranchTypeName() {
		if (null != branchTypeName) {
		} else {
			branchTypeName = super.initString;
		}
		return branchTypeName;
	}

	public void setBranchTypeName(String branchTypeName) {
		this.branchTypeName = branchTypeName;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getSfo1() {
		return sfo1;
	}

	public void setSfo1(String sfo1) {
		this.sfo1 = sfo1;
	}

	public String getSfo2() {
		return sfo2;
	}

	public void setSfo2(String sfo2) {
		this.sfo2 = sfo2;
	}

	public String getSfo3() {
		return sfo3;
	}

	public void setSfo3(String sfo3) {
		this.sfo3 = sfo3;
	}

	public String getSfo4() {
		return sfo4;
	}

	public void setSfo4(String sfo4) {
		this.sfo4 = sfo4;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public Integer getMaxMembSubVillage() {
		return maxMembSubVillage;
	}

	public void setMaxMembSubVillage(Integer maxMembSubVillage) {
		this.maxMembSubVillage = maxMembSubVillage;
	}

	public Integer getMinMembGroup() {
		return minMembGroup;
	}

	public void setMinMembGroup(Integer minMembGroup) {
		this.minMembGroup = minMembGroup;
	}

	public Integer getMaxMembGroup() {
		return maxMembGroup;
	}

	public void setMaxMembGroup(Integer maxMembGroup) {
		this.maxMembGroup = maxMembGroup;
	}

	public Integer getMinGrpSubVillage() {
		return minGrpSubVillage;
	}

	public void setMinGrpSubVillage(Integer minGrpSubVillage) {
		this.minGrpSubVillage = minGrpSubVillage;
	}

	public Integer getMaxGrpSubVillage() {
		return maxGrpSubVillage;
	}

	public void setMaxGrpSubVillage(Integer maxGrpSubVillage) {
		this.maxGrpSubVillage = maxGrpSubVillage;
	}

	public Integer getNonWorkingOffs1() {
		return nonWorkingOffs1;
	}

	public void setNonWorkingOffs1(Integer nonWorkingOffs1) {
		this.nonWorkingOffs1 = nonWorkingOffs1;
	}

	public Integer getNonWorkingOffs2() {
		return nonWorkingOffs2;
	}

	public void setNonWorkingOffs2(Integer nonWorkingOffs2) {
		this.nonWorkingOffs2 = nonWorkingOffs2;
	}

	public Integer getNonWorkingOffs3() {
		return nonWorkingOffs3;
	}

	public void setNonWorkingOffs3(Integer nonWorkingOffs3) {
		this.nonWorkingOffs3 = nonWorkingOffs3;
	}

	public Integer getNonWorkingOffs4() {
		return nonWorkingOffs4;
	}

	public void setNonWorkingOffs4(Integer nonWorkingOffs4) {
		this.nonWorkingOffs4 = nonWorkingOffs4;
	}

	public Integer getNonWorkingHalfOffs1() {
		return nonWorkingHalfOffs1;
	}

	public void setNonWorkingHalfOffs1(Integer nonWorkingHalfOffs1) {
		this.nonWorkingHalfOffs1 = nonWorkingHalfOffs1;
	}

	public Integer getNonWorkingHalfOffs2() {
		return nonWorkingHalfOffs2;
	}

	public void setNonWorkingHalfOffs2(Integer nonWorkingHalfOffs2) {
		this.nonWorkingHalfOffs2 = nonWorkingHalfOffs2;
	}

	public Integer getNonWorkingHalfOffs3() {
		return nonWorkingHalfOffs3;
	}

	public void setNonWorkingHalfOffs3(Integer nonWorkingHalfOffs3) {
		this.nonWorkingHalfOffs3 = nonWorkingHalfOffs3;
	}

	public Integer getNonWorkingHalfOffs4() {
		return nonWorkingHalfOffs4;
	}

	public void setNonWorkingHalfOffs4(Integer nonWorkingHalfOffs4) {
		this.nonWorkingHalfOffs4 = nonWorkingHalfOffs4;
	}

	public Integer getNonWorkingHalfOffs5() {
		return nonWorkingHalfOffs5;
	}

	public void setNonWorkingHalfOffs5(Integer nonWorkingHalfOffs5) {
		this.nonWorkingHalfOffs5 = nonWorkingHalfOffs5;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMunicipalityBlock() {
		return municipalityBlock;
	}

	public void setMunicipalityBlock(String municipalityBlock) {
		this.municipalityBlock = municipalityBlock;
	}

	public String getVillCode() {
		return villCode;
	}

	public void setVillCode(String villCode) {
		this.villCode = villCode;
	}

	public Integer getBranchBusinessType() {
		return branchBusinessType;
	}

	public void setBranchBusinessType(Integer branchBusinessType) {
		this.branchBusinessType = branchBusinessType;
	}

	public String getAreaManager() {
		return areaManager;
	}

	public void setAreaManager(String areaManager) {
		this.areaManager = areaManager;
	}

	public Date getBrOpeningDate() {
		return brOpeningDate;
	}

	public void setBrOpeningDate(Date brOpeningDate) {
		this.brOpeningDate = brOpeningDate;
	}

	public String getLegacyBranchCode() {
		return legacyBranchCode;
	}

	public void setLegacyBranchCode(String legacyBranchCode) {
		this.legacyBranchCode = legacyBranchCode;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
	}

	public String getPhoneNumber4() {
		return phoneNumber4;
	}

	public void setPhoneNumber4(String phoneNumber4) {
		this.phoneNumber4 = phoneNumber4;
	}

	public Integer getParentBranchCode1() {
		return parentBranchCode1;
	}

	public void setParentBranchCode1(Integer parentBranchCode1) {
		this.parentBranchCode1 = parentBranchCode1;
	}

	public Integer getParentBranchCode2() {
		return parentBranchCode2;
	}

	public void setParentBranchCode2(Integer parentBranchCode2) {
		this.parentBranchCode2 = parentBranchCode2;
	}

	public Integer getParentBranchCode3() {
		return parentBranchCode3;
	}

	public void setParentBranchCode3(Integer parentBranchCode3) {
		this.parentBranchCode3 = parentBranchCode3;
	}

	public Integer getBranchCategoryType() {
		return branchCategoryType;
	}

	public void setBranchCategoryType(Integer branchCategoryType) {
		this.branchCategoryType = branchCategoryType;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		BranchMst other = (BranchMst) obj;
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

	public D001003Key getD001003Key() {
		D001003Key d001003Key = new D001003Key();
		d001003Key.setBranchCode(this.branchCode);
		d001003Key.setTenantId(this.tenantId);
		return d001003Key;
	}
}
