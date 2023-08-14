package ai.kiya.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base;
import ai.kiya.key.D002001Key;

@Table(name = "D002001")
@Entity
@IdClass(D002001Key.class)
public class UserMst extends Base {

	private static final long serialVersionUID = 1701926931204630606L;

//		@EmbeddedId
//		private D002001Key d002001Key = new D002001Key();

	@Column(length = 2000, nullable = true)
	private String loginSession = "";

	@Column(length = 1200, nullable = true)
	private String userBiometricData = "";

	@Column(length = 40, nullable = false)
	private String roleCode = "";

	@Column(length = 40, nullable = true)
	private String userId = "";

	/////

	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 10, nullable = false)
	private String loginId = "";

	////
	@NotAudited
	@ElementCollection
	@JoinTable(name = "D002002", joinColumns = { @JoinColumn(name = "loginId", referencedColumnName = "loginId"),
			@JoinColumn(name = "tenantId", referencedColumnName = "tenantId") })
	@LazyCollection(LazyCollectionOption.FALSE)
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId(columns = {
			@Column(name = "allowConcurrentLogin") }, generator = "sequence_gen", type = @Type(type = "long"))
	private Collection<Address> userAddresses = new ArrayList<Address>();

	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private Collection<UserBranchMap> userBranchMaps = new ArrayList<UserBranchMap>();

	@Column(length = 40, nullable = true)
	private String addressProofType = "";

	@Column(nullable = true, length = 60)
	private String resiAddressProofRefNo = "";

	@Column(length = 40, nullable = true)
	private String telephone = "";

	@Column(length = 40, nullable = true)
	private String mobileNo1 = "";

	@Column(length = 40, nullable = true)
	private String mobileNo2 = "";

	@Column(length = 40, nullable = true)
	private String faxNum = "";

	@Column(length = 10, nullable = true)
	private String userCode = "";

	@Column(length = 40, nullable = true)
	private String userTypeCode = ""; // from Lookup - Internal, External,
										// WebUser

	@Column(nullable = true, length = 60)
	private String reportingUserCode = ""; // to create Users' reporting
											// hierarchy

	@Column(length = 2000, nullable = true)
	private String pwd = ""; // Encrypted value
	@Column(length = 2000, nullable = true)
	private String pwdSalt = ""; // Encrypted value

	@Column(length = 60, nullable = true)
	private String permissionNo = "";

	@Column(length = 20, nullable = true)
	private String userSalutation = "";
	@Column(length = 60, nullable = true)
	private String userFName = ""; // This can also be a System Name (ATM, etc.)
	@Column(length = 60, nullable = true)
	private String userMName = "";
	@Column(length = 60, nullable = true)
	private String userLName = "";

	@Column(length = 60, nullable = true)
	private String userFNameOnPhotoId = ""; // This can also be a System Name
											// (ATM, etc.)
	@Column(length = 60, nullable = true)
	private String userMNameOnPhotoId = "";
	@Column(length = 60, nullable = true)
	private String userLNameOnPhotoId = "";

	@Column(length = 60, nullable = true)
	private String userDisplayName = "";

	@Column(length = 6, nullable = true)
	private String userBaseBranchCode = "";

	@Column(length = 200, nullable = true)
	private String emailId = "";

	@Column(nullable = true, length = 1)
	private Integer forcePwdChgYN;

	@Column(nullable = true, length = 1)
	private Integer forcePwdChgDays = 0;

	@Column(nullable = true, length = 1)
	private Integer forceMinLoginFreqYN;

	@Column(nullable = true)
	private Integer forceMinLoginFreqDays = 0;

	@Column(nullable = true)
	private Integer maxConseBadLoginPerDay = 0;

	@Temporal(TemporalType.DATE)
	private Date lastSuccessfulLoginDateTime;

	@Temporal(TemporalType.DATE)
	private Date prevPwdChgOn;

	@Column(nullable = true)
	private Date nextPwdChgOn;

	@Temporal(TemporalType.DATE)
	private Date userDateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date userDateOfJoining;

	@Temporal(TemporalType.DATE)
	private Date userDateOfResignation;

	@Temporal(TemporalType.DATE)
	private Date userDateOfRetirement;

	@Column(nullable = true, length = 1)
	private Integer isUserLocked;

	@Column(nullable = true, length = 1)
	private Integer isUserLoggedin;

	@Column(nullable = true)
	private Integer consequetiveBadLoginCount = 0;

	@Column(nullable = true, length = 1)
	private Integer allowConcurrentLogin;

	@Temporal(TemporalType.DATE)
	private Date inActiveFromDateTime = super.initDate();

	@Temporal(TemporalType.DATE)
	private Date inActiveTillDateTime = super.initDate();

	@Column(nullable = true, length = 60)
	private String employeeId = "";

	@Column(nullable = true, length = 60)
	private String gender = "";

	@Column(nullable = true, length = 60)
	private String bloodGroup = "";

	@Column(nullable = true, length = 60)
	private String religion = "";

	@Column(nullable = true, length = 60)
	private String education = "";

	@Column(nullable = true, length = 60)
	private String typeOfEmployee = "";

	@Column(nullable = true, length = 60)
	private String photoIdType = "";

	@Column(nullable = true, length = 60)
	private String issuedAuthority = "";

	@Column(nullable = true, length = 60)
	private String proofIdNumber = "";

	@Column(nullable = true, length = 60)
	private Integer isSuspended = 0;

	// NEW FIELDS - START
	@Column(nullable = true, length = 50)
	private String assignedBranch = "";

	@Column(nullable = true, length = 5)
	private String preferLang = "";

	@Column(nullable = true, length = 2)
	private String hnwCategory = "";

	@Column(nullable = true, length = 1)
	private Integer ssoLoginAllow;

	@Column(nullable = true, length = 20)
	private String ssoLoginId = "";

	@Column(nullable = true, length = 1)
	private Integer ssoAutoLoginAllow;

	@Column(nullable = true, length = 1)
	private Integer mulBranchAcccess;

	@Column(nullable = true)
	private Integer coolingPeriod = 0;

	@Column(nullable = true)
	private Integer lockUserAfterfailLogin = 0;
	// NEW FIELDS - END

	@Temporal(TemporalType.DATE)
	private Date dateOfIssue = super.initDate();

	@Lob
	private byte[] userSignature;

	@Lob
	private byte[] userPhoto;

	@Column(nullable = true, length = 2)
	private Integer userStatus = 0;

	@Column(nullable = true, length = 1)
	private Integer noOfBadLogin = 0;

	private Date badLoginDate;

	// @Column(columnDefinition="DATETIME")
	// @Temporal(TemporalType.TIMESTAMP)
	private Date lockTime;

	// @Column(columnDefinition="DATETIME")
	// @Temporal(TemporalType.TIMESTAMP)
	private Date passwordDate;
	// new field by shadma
	/*
	 * @Column(nullable = true, columnDefinition="nvarchar(255)") private String
	 * multipleBranchCd = "";
	 */

	// new field end by shadma

	@Column(nullable = true, length = 1)
	private Integer isSessionIdle;

	@Column(nullable = true, length = 1)
	private Integer loginFrmAnotherBranch;

	@Column(nullable = true, length = 20)
	private String userDepartment = "";

	@Column(nullable = true, length = 100)
	private String taggedVillage = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collection<UserBranchMap> getUserBranchMaps() {
		return userBranchMaps;
	}

	public void setUserBranchMaps(Collection<UserBranchMap> userBranchMaps) {
		this.userBranchMaps = userBranchMaps;
	}

	public String getUserCode() {
		if (null != userCode) {
		} else {
			userCode = super.initString;
		}
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserTypeCode() {
		if (null != userTypeCode) {
		} else {
			userTypeCode = super.initString;
		}
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getPwd() {
		if (null != pwd) {
		} else {
			pwd = super.initString;
		}
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdSalt() {
		if (null != pwdSalt) {
		} else {
			pwdSalt = super.initString;
		}
		return pwdSalt;
	}

	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}

	public String getPermissionNo() {
		if (null != permissionNo) {
		} else {
			permissionNo = super.initString;
		}
		return permissionNo;
	}

	public void setPermissionNo(String permissionNo) {
		this.permissionNo = permissionNo;
	}

	public String getUserSalutation() {
		if (null != userSalutation) {
		} else {
			userSalutation = super.initString;
		}
		return userSalutation;
	}

	public void setUserSalutation(String userSalutation) {
		this.userSalutation = userSalutation;
	}

	public String getUserFName() {
		if (null != userFName) {
		} else {
			userFName = super.initString;
		}
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserMName() {
		if (null != userMName) {
		} else {
			userMName = super.initString;
		}
		return userMName;
	}

	public void setUserMName(String userMName) {
		this.userMName = userMName;
	}

	public String getUserLName() {
		if (null != userLName) {
		} else {
			userLName = super.initString;
		}
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserDisplayName() {
		if (null != userDisplayName) {
		} else {
			userDisplayName = super.initString;
		}
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getUserBaseBranchCode() {
		if (null != userBaseBranchCode) {
		} else {
			userBaseBranchCode = super.initString;
		}
		return userBaseBranchCode;
	}

	public void setUserBaseBranchCode(String userBaseBranchCode) {
		this.userBaseBranchCode = userBaseBranchCode;
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

	public Integer getForcePwdChgDays() {
		if (null != forcePwdChgDays) {
		} else {
			forcePwdChgDays = super.initInteger;
		}
		return forcePwdChgDays;
	}

	public void setForcePwdChgDays(Integer forcePwdChgDays) {
		this.forcePwdChgDays = forcePwdChgDays;
	}

	public Integer getForceMinLoginFreqDays() {
		if (null != forceMinLoginFreqDays) {
		} else {
			forceMinLoginFreqDays = super.initInteger;
		}
		return forceMinLoginFreqDays;
	}

	public void setForceMinLoginFreqDays(Integer forceMinLoginFreqDays) {
		this.forceMinLoginFreqDays = forceMinLoginFreqDays;
	}

	public Integer getMaxConseBadLoginPerDay() {
		if (null != maxConseBadLoginPerDay) {
		} else {
			maxConseBadLoginPerDay = super.initInteger;
		}
		return maxConseBadLoginPerDay;
	}

	public void setMaxConseBadLoginPerDay(Integer maxConseBadLoginPerDay) {
		this.maxConseBadLoginPerDay = maxConseBadLoginPerDay;
	}

	public Date getLastSuccessfulLoginDateTime() {
		if (null != lastSuccessfulLoginDateTime) {
		} else {
			lastSuccessfulLoginDateTime = super.initDate();
		}
		return lastSuccessfulLoginDateTime;
	}

	public void setLastSuccessfulLoginDateTime(Date lastSuccessfulLoginDateTime) {
		this.lastSuccessfulLoginDateTime = lastSuccessfulLoginDateTime;
	}

	public Date getPrevPwdChgOn() {
		if (null != prevPwdChgOn) {
		} else {
			prevPwdChgOn = super.initDate();
		}
		return prevPwdChgOn;
	}

	public void setPrevPwdChgOn(Date prevPwdChgOn) {
		this.prevPwdChgOn = prevPwdChgOn;
	}

	public Date getNextPwdChgOn() {
		if (null != nextPwdChgOn) {
		} else {
			nextPwdChgOn = super.initDate();
		}
		return nextPwdChgOn;
	}

	public void setNextPwdChgOn(Date nextPwdChgOn) {
		this.nextPwdChgOn = nextPwdChgOn;
	}

	public Integer getConsequetiveBadLoginCount() {
		if (null != consequetiveBadLoginCount) {
		} else {
			consequetiveBadLoginCount = super.initInteger;
		}
		return consequetiveBadLoginCount;
	}

	public void setConsequetiveBadLoginCount(Integer consequetiveBadLoginCount) {
		this.consequetiveBadLoginCount = consequetiveBadLoginCount;
	}

	public Date getInActiveFromDateTime() {
		if (null != inActiveFromDateTime) {
		} else {
			inActiveFromDateTime = super.initDate();
		}
		return inActiveFromDateTime;
	}

	public void setInActiveFromDateTime(Date inActiveFromDateTime) {
		this.inActiveFromDateTime = inActiveFromDateTime;
	}

	public Date getInActiveTillDateTime() {
		if (null != inActiveTillDateTime) {
		} else {
			inActiveTillDateTime = super.initDate();
		}
		return inActiveTillDateTime;
	}

	public void setInActiveTillDateTime(Date inActiveTillDateTime) {
		this.inActiveTillDateTime = inActiveTillDateTime;
	}

	public String getLoginSession() {
		if (null != loginSession) {
		} else {
			loginSession = super.initString;
		}
		return loginSession;
	}

	public void setLoginSession(String loginSession) {
		this.loginSession = loginSession;
	}

	public String getReportingUserCode() {
		if (null != reportingUserCode) {
		} else {
			reportingUserCode = super.initString;
		}
		return reportingUserCode;
	}

	public void setReportingUserCode(String reportingUserCode) {
		this.reportingUserCode = reportingUserCode;
	}

	public String getRoleCode() {
		if (null != roleCode) {
		} else {
			roleCode = super.initString;
		}
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Collection<Address> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(Collection<Address> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public String getTelephone() {
		if (null != telephone) {
		} else {
			telephone = super.initString;
		}
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobileNo1() {
		if (null != mobileNo1) {
		} else {
			mobileNo1 = super.initString;
		}
		return mobileNo1;
	}

	public void setMobileNo1(String mobileNo1) {
		this.mobileNo1 = mobileNo1;
	}

	public String getMobileNo2() {
		if (null != mobileNo2) {
		} else {
			mobileNo2 = super.initString;
		}
		return mobileNo2;
	}

	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}

	public String getFaxNum() {
		if (null != faxNum) {
		} else {
			faxNum = super.initString;
		}
		return faxNum;
	}

	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}

	public Date getUserDateOfBirth() {
		if (null != userDateOfBirth) {
		} else {
			userDateOfBirth = super.initDate();
		}
		return userDateOfBirth;
	}

	public void setUserDateOfBirth(Date userDateOfBirth) {
		this.userDateOfBirth = userDateOfBirth;
	}

	public Date getUserDateOfJoining() {
		if (null != userDateOfJoining) {
		} else {
			userDateOfJoining = super.initDate();
		}
		return userDateOfJoining;
	}

	public void setUserDateOfJoining(Date userDateOfJoining) {
		this.userDateOfJoining = userDateOfJoining;
	}

	public Date getUserDateOfResignation() {
		if (null != userDateOfResignation) {
		} else {
			userDateOfResignation = super.initDate();
		}
		return userDateOfResignation;
	}

	public void setUserDateOfResignation(Date userDateOfResignation) {
		this.userDateOfResignation = userDateOfResignation;
	}

	public Date getUserDateOfRetirement() {
		if (null != userDateOfRetirement) {
		} else {
			userDateOfRetirement = super.initDate();
		}
		return userDateOfRetirement;
	}

	public void setUserDateOfRetirement(Date userDateOfRetirement) {
		this.userDateOfRetirement = userDateOfRetirement;
	}

	public String getEmployeeId() {
		if (null != employeeId) {
		} else {
			employeeId = super.initString;
		}
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getGender() {
		if (null != gender) {
		} else {
			gender = super.initString;
		}
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		if (null != bloodGroup) {
		} else {
			bloodGroup = super.initString;
		}
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getReligion() {
		if (null != religion) {
		} else {
			religion = super.initString;
		}
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getEducation() {
		if (null != education) {
		} else {
			education = super.initString;
		}
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTypeOfEmployee() {
		if (null != typeOfEmployee) {
		} else {
			typeOfEmployee = super.initString;
		}
		return typeOfEmployee;
	}

	public void setTypeOfEmployee(String typeOfEmployee) {
		this.typeOfEmployee = typeOfEmployee;
	}

	public String getPhotoIdType() {
		if (null != photoIdType) {
		} else {
			photoIdType = super.initString;
		}
		return photoIdType;
	}

	public void setPhotoIdType(String photoIdType) {
		this.photoIdType = photoIdType;
	}

	public String getIssuedAuthority() {
		if (null != issuedAuthority) {
		} else {
			issuedAuthority = super.initString;
		}
		return issuedAuthority;
	}

	public void setIssuedAuthority(String issuedAuthority) {
		this.issuedAuthority = issuedAuthority;
	}

	public String getProofIdNumber() {
		if (null != proofIdNumber) {
		} else {
			proofIdNumber = super.initString;
		}
		return proofIdNumber;
	}

	public void setProofIdNumber(String proofIdNumber) {
		this.proofIdNumber = proofIdNumber;
	}

	public Date getDateOfIssue() {
		if (null != dateOfIssue) {
		} else {
			dateOfIssue = super.initDate();
		}
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public byte[] getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(byte[] userSignature) {
		this.userSignature = userSignature;
	}

	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(byte[] userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getAddressProofType() {
		if (null != addressProofType) {
		} else {
			addressProofType = super.initString;
		}
		return addressProofType;
	}

	public void setAddressProofType(String addressProofType) {
		this.addressProofType = addressProofType;
	}

	public String getUserFNameOnPhotoId() {
		if (null != userFNameOnPhotoId) {
		} else {
			userFNameOnPhotoId = super.initString;
		}
		return userFNameOnPhotoId;
	}

	public void setUserFNameOnPhotoId(String userFNameOnPhotoId) {
		this.userFNameOnPhotoId = userFNameOnPhotoId;
	}

	public String getUserMNameOnPhotoId() {
		if (null != userMNameOnPhotoId) {
		} else {
			userMNameOnPhotoId = super.initString;
		}
		return userMNameOnPhotoId;
	}

	public void setUserMNameOnPhotoId(String userMNameOnPhotoId) {
		this.userMNameOnPhotoId = userMNameOnPhotoId;
	}

	public String getUserLNameOnPhotoId() {
		if (null != userLNameOnPhotoId) {
		} else {
			userLNameOnPhotoId = super.initString;
		}
		return userLNameOnPhotoId;
	}

	public void setUserLNameOnPhotoId(String userLNameOnPhotoId) {
		this.userLNameOnPhotoId = userLNameOnPhotoId;
	}

	/*
	 * public AuthMKCK setAuthMkCkFields(AuthMKCK authMkCk) {
	 * authMkCk.setRefID(getId()); authMkCk.setMenuAction("userEdit.action");
	 * authMkCk.setEntityEntryCode(getLoginId()); return authMkCk; }
	 */

	public String getUserBiometricData() {
		if (null != userBiometricData) {
		} else {
			userBiometricData = super.initString;
		}
		return userBiometricData;
	}

	public void setUserBiometricData(String userBiometricData) {
		this.userBiometricData = userBiometricData;
	}

	public String getResiAddressProofRefNo() {
		if (null != resiAddressProofRefNo) {
		} else {
			resiAddressProofRefNo = super.initString;
		}
		return resiAddressProofRefNo;
	}

	public void setResiAddressProofRefNo(String resiAddressProofRefNo) {
		this.resiAddressProofRefNo = resiAddressProofRefNo;
	}

	public String getPreferLang() {
		if (null != preferLang) {
		} else {
			preferLang = super.initString;
		}
		return preferLang;
	}

	public void setPreferLang(String preferLang) {
		this.preferLang = preferLang;
	}

	public String getHnwCategory() {
		if (null != hnwCategory) {
		} else {
			hnwCategory = super.initString;
		}
		return hnwCategory;
	}

	public void setHnwCategory(String hnwCategory) {
		this.hnwCategory = hnwCategory;
	}

	public String getSsoLoginId() {
		if (null != ssoLoginId) {
		} else {
			ssoLoginId = super.initString;
		}
		return ssoLoginId;
	}

	public void setSsoLoginId(String ssoLoginId) {
		this.ssoLoginId = ssoLoginId;
	}

	public Integer getCoolingPeriod() {
		if (null != coolingPeriod) {
		} else {
			coolingPeriod = super.initInteger;
		}
		return coolingPeriod;
	}

	public void setCoolingPeriod(Integer coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}

	public Integer getLockUserAfterfailLogin() {
		if (null != lockUserAfterfailLogin) {
		} else {
			lockUserAfterfailLogin = super.initInteger;
		}
		return lockUserAfterfailLogin;
	}

	public void setLockUserAfterfailLogin(Integer lockUserAfterfailLogin) {
		this.lockUserAfterfailLogin = lockUserAfterfailLogin;
	}

	public String getAssignedBranch() {
		if (null != assignedBranch) {
		} else {
			assignedBranch = super.initString;
		}
		return assignedBranch;
	}

	public void setAssignedBranch(String assignedBranch) {
		this.assignedBranch = assignedBranch;
	}

	public Integer getForcePwdChgYN() {
		if (null != forcePwdChgYN) {
		} else {
			forcePwdChgYN = super.initInteger;
		}
		return forcePwdChgYN;
	}

	public void setForcePwdChgYN(Integer forcePwdChgYN) {
		this.forcePwdChgYN = forcePwdChgYN;
	}

	public Integer getForceMinLoginFreqYN() {
		if (null != forceMinLoginFreqYN) {
		} else {
			forceMinLoginFreqYN = super.initInteger;
		}
		return forceMinLoginFreqYN;
	}

	public void setForceMinLoginFreqYN(Integer forceMinLoginFreqYN) {
		this.forceMinLoginFreqYN = forceMinLoginFreqYN;
	}

	public Integer getIsUserLocked() {
		if (null != isUserLocked) {
		} else {
			isUserLocked = super.initInteger;
		}
		return isUserLocked;
	}

	public void setIsUserLocked(Integer isUserLocked) {
		this.isUserLocked = isUserLocked;
	}

	public Integer getIsUserLoggedin() {
		if (null != isUserLoggedin) {
		} else {
			isUserLoggedin = super.initInteger;
		}
		return isUserLoggedin;
	}

	public void setIsUserLoggedin(Integer isUserLoggedin) {
		this.isUserLoggedin = isUserLoggedin;
	}

	public Integer getAllowConcurrentLogin() {
		return allowConcurrentLogin;
	}

	public void setAllowConcurrentLogin(Integer allowConcurrentLogin) {
		this.allowConcurrentLogin = allowConcurrentLogin;
	}

	public Integer getIsSuspended() {
		if (null != isSuspended) {
		} else {
			isSuspended = super.initInteger;
		}
		return isSuspended;
	}

	public void setIsSuspended(Integer isSuspended) {
		this.isSuspended = isSuspended;
	}

	public Integer getSsoLoginAllow() {
		if (null != ssoLoginAllow) {
		} else {
			ssoLoginAllow = super.initInteger;
		}
		return ssoLoginAllow;
	}

	public void setSsoLoginAllow(Integer ssoLoginAllow) {
		this.ssoLoginAllow = ssoLoginAllow;
	}

	public Integer getSsoAutoLoginAllow() {
		if (null != ssoAutoLoginAllow) {
		} else {
			ssoAutoLoginAllow = super.initInteger;
		}
		return ssoAutoLoginAllow;
	}

	public void setSsoAutoLoginAllow(Integer ssoAutoLoginAllow) {
		this.ssoAutoLoginAllow = ssoAutoLoginAllow;
	}

	public Integer getMulBranchAcccess() {
		if (null != mulBranchAcccess) {
		} else {
			mulBranchAcccess = super.initInteger;
		}
		return mulBranchAcccess;
	}

	public void setMulBranchAcccess(Integer mulBranchAcccess) {
		this.mulBranchAcccess = mulBranchAcccess;
	}

	public Integer getUserStatus() {
		if (null != userStatus) {
		} else {
			userStatus = super.initInteger;
		}
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public Integer getNoOfBadLogin() {
		if (null != noOfBadLogin) {
		} else {
			noOfBadLogin = super.initInteger;
		}
		return noOfBadLogin;
	}

	public void setNoOfBadLogin(Integer noOfBadLogin) {
		this.noOfBadLogin = noOfBadLogin;
	}

	public Date getBadLoginDate() {
		if (null != badLoginDate) {
		} else {
			badLoginDate = super.initDate();
		}
		return badLoginDate;
	}

	public void setBadLoginDate(Date badLoginDate) {
		this.badLoginDate = badLoginDate;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public Date getPasswordDate() {
		return passwordDate;
	}

	public void setPasswordDate(Date passwordDate) {
		this.passwordDate = passwordDate;
	}

	public Integer getIsSessionIdle() {
		return isSessionIdle;
	}

	public void setIsSessionIdle(Integer isSessionIdle) {
		this.isSessionIdle = isSessionIdle;
	}

	public Integer getLoginFrmAnotherBranch() {
		return loginFrmAnotherBranch;
	}

	public void setLoginFrmAnotherBranch(Integer loginFrmAnotherBranch) {
		this.loginFrmAnotherBranch = loginFrmAnotherBranch;
	}

	public String getUserDepartment() {
		return userDepartment;
	}

	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}

	public String getTaggedVillage() {
		return taggedVillage;
	}

	public void setTaggedVillage(String taggedVillage) {
		this.taggedVillage = taggedVillage;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
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
		UserMst other = (UserMst) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D002001Key getD002001Key() {
		D002001Key d002001Key = new D002001Key();
		d002001Key.setLoginId(this.loginId);
		d002001Key.setTenantId(this.tenantId);
		return d002001Key;
	}
}
