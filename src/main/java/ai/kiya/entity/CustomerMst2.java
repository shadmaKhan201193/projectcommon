package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D009011Key;

@Table(name = "D009011")
@Entity
@IdClass(D009011Key.class)
public class CustomerMst2 extends Base {

	private static final long serialVersionUID = 1701926931204630606L;

	//
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Id
	@Column(nullable = false, length = 10)
	private Integer memberCode = 0;//

	//
	@Column
	private Long code;

	@Column(nullable = true, length = 1)
	private String legalEntity;

	@Column(nullable = true, length = 40)
	private String seqType = "";

	@Column(nullable = true, length = 50)
	private String mbrAppNo = "";

	@Column(nullable = true)
	private Double maxLoanLimit = 0.0D;

	@Column(nullable = true, length = 6)
	private Integer baseTenantCode = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(4)")
	@Column(nullable = true, length = 4)
	private String nameTitle = "";

	/*
	 * @Column(nullable = true, length = 300) private Integer noOfShareApplied = 0;
	 */

	// For Corporate Members, their name can be longer then fName
	// @Column(nullable = true, columnDefinition = "nvarchar(200)")
	@Column(nullable = true, length = 200)
	private String memberFName = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String memberMName = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String memberLName = "";

	@Column(nullable = false)
	private Date memberDOB;

	@Column(nullable = false)
	private Date dateOfApplication;

	@Column(nullable = true)
	private Date dateOfIssue;

	@Column(nullable = true)
	private Date memberSince;

	@Column(nullable = true, length = 4)
	private Integer religion = 0;

	@Column(nullable = true, length = 4)
	private Integer memberCaste = 0; // from Lookup

	@Column(nullable = true, length = 4)
	private Integer subCaste = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(1)")
	@Column(nullable = true, length = 1)
	private String memberGender = ""; // from Lookup

	@Column(nullable = true, length = 4)
	private Integer mbrMaritalStatus = 0; // from Lookup

	// @Column(nullable = true, columnDefinition = "nvarchar(150)")
	@Column(nullable = true, length = 150)
	private String spouseName = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String spouseMbrNum = "";

	@Column(nullable = true, length = 4)
	private Integer totalMaleChild = 0;

	@Column(nullable = true, length = 4)
	private Integer totalFemaleChild = 0;

	@Column(nullable = true, length = 4)
	private Integer totalFamilyMbr = 0;

	@Column(nullable = true, length = 4)
	private Integer qualification = 0;

	@Column(nullable = true, length = 4)
	private Integer bloodGroup = 0;

	@Column(nullable = true, length = 4)
	private Integer resAddProofID = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String tempDate = "";

	@Column(nullable = true, length = 30)
	private String custUniqueId = "";

	@Transient
	private String dateOfBirthStr;
	@Transient
	private String memberFullName;

	@Transient
	private String strAddress1 = "";

	@Transient
	private String strAddress2 = "";

	@Transient
	private String strAddress3 = "";

	@Transient
	private String strCountryCode = "";

	@Transient
	private String strStateCode = "";

	@Transient
	private String strDistrictCode = "";

	@Transient
	private String strMunicipalityId = "";

	@Transient
	private String strVillage = "";

	@Transient
	private String strPinCode = "";

	@Column(length = 150, nullable = true)
	private String postOfcName = "";

	@Column(length = 150, nullable = true)
	private String hobliName = "";

	@Column(length = 20, nullable = true)
	private String phone = "";

	@Column(length = 20, nullable = true)
	private String mobileNo1 = "";

	@Column(length = 20, nullable = true)
	private String mobileNo2 = "";

	@Column(length = 20, nullable = true)
	private String fax = "";

	@Column(length = 50, nullable = true)
	private String emailId = "";

	@Column(length = 4, nullable = true)
	private Integer occupation = 0;

	/*
	 * @Column(nullable = true, length = 8) private Integer totalShares = 0;
	 */

	/*
	 * @Column(nullable = true, length = 8) private Integer availableShares = 0;
	 */

	// *********************Extra*************************

	@Column(nullable = true, length = 4)
	private Integer memberTypeCode = 0; // from Lookup - Individual, Corporate

	@Column(nullable = true, length = 4)
	private Integer KYCType = 0; // from Lookup

	@Column(nullable = true, length = 4)
	private Integer HNWCategory = 0;

	@Column(nullable = true, length = 4)
	private Integer noOfChildren = 0;

	@Column(nullable = true, length = 150)
	private String fatherSpouseName = "";

	@Column(nullable = true, length = 50)
	private String memberRegNo = "";

	@Column(nullable = true, length = 50)
	private String mbrAdditionalInfo = "";

	@Column(nullable = true, length = 4)
	private Integer transactionFreeze = 0;

	@Column(nullable = true, length = 4)
	private String freezeType = "";

	@Column(nullable = true, length = 2)
	private Integer frzReasonCd = 0;

	@Column(nullable = true, length = 4)
	private Integer customerStatus = 0;

	@Column(nullable = true, length = 4)
	private Integer closeReason = 0;

	@Column(nullable = true)
	private Date kycExpiryDate = null;

	@Column(nullable = true, length = 4)
	private Integer transactionFreezeReason = 0;

	@Column(nullable = true, length = 60)
	private String splInstr1 = "";

	@Column(nullable = true, length = 4)
	private Integer NPARating = 0;

	@Column(nullable = true, length = 4)
	private Integer NPAReason = 0;

	@Column(nullable = true, length = 6)
	private Integer baseBranchCode = 0;

	@Column(nullable = true)
	private Double memberAmtLimit = 0D;

	/*
	 * @Column(nullable = true) private Double shareAmount =0.0D ;
	 */

	@Column(nullable = true, length = 3)
	private String memberAmtCurrency = "";

	@Column(nullable = true, length = 4)
	private Integer memberCasteCategory = 0; // from Lookup

	// from lookup
	@Column(nullable = true, length = 4)
	private Integer memberCategory = 0;

	// from lookup
	@Column(nullable = true, length = 4)
	private Integer memberType = 0;

	@Column(nullable = true, length = 30)
	private String memberNumber = "";

	@Column(nullable = true, length = 1)
	private Integer residentYN = 0;

	// from lookup
	@Column(nullable = true, length = 4)
	private String residentCountry = "";

	// from lookup
	@Column(nullable = true, length = 4)
	private Integer residentialStatus = 0;

	// NRI/FOREIGNER DOC DETAILS
	@Column(nullable = true, length = 30)
	private String passportNumber = "";

	// from lookup
	@Column(nullable = true, length = 4)
	private String issuedByCountry = "";

	@Column(nullable = true, length = 4)
	private Integer visaType = 0;

	@Column(nullable = true, length = 30)
	private String visaNumber = "";

	@Column(nullable = true)
	private Date passportIssuedDate;

	@Column(nullable = true)
	private Date passportExpiryDate;

	@Column(nullable = true)
	private Date visaIssuedDate;

	@Column(nullable = true, length = 6)
	private Integer memberCreationBranch = 0;
	// ADHOC DETAILS

	@Column(nullable = true, length = 20)
	private String refDocNo = "";

	@Column(nullable = true, length = 4)
	private Integer customerType = 0;

	@Transient
	private String customerTypeStr = "";

	@Column(nullable = true, length = 4)
	private Integer numberOfDependants = 0;

	@Column(nullable = true, length = 1)
	private Integer introducerCon = 0;

	@Column(nullable = true, length = 4)
	// from lookup
	private Integer residenceType = 0;

	@Column(nullable = true, length = 10)
	private Integer introducerNumber = 0;

	@Column(nullable = true, length = 4)
	private Integer AMLRating = 0;

	@Column(nullable = true, length = 1)
	private Integer tdsYN = 0;

	@Column(nullable = true)
	private Double tdsPercentage = 0D;

	@Column(nullable = true, length = 4)
	private Integer tdsReasonCd = 0;

	@Column(nullable = true, length = 30)
	private Long aadhaarEnrollmentId = 0L;

	@Column(nullable = true, length = 30)
	private Long aadhaarCardNumber = 0L;

	@Column(nullable = true, length = 4)
	private Integer nationality = 0; // from Lookup

	@Column(nullable = true, length = 30)
	private String tempPhoto = "";

	@Column(nullable = true, length = 4)
	private Integer orgType = 0;

	@Column(nullable = true, length = 4)
	private Integer businessType = 0;

	@Column(nullable = true, length = 4)
	private String placeOfEstablishment = "";

	@Column(nullable = true, length = 30)
	private String registrationNo = "";

	@Column(nullable = true, length = 4)
	private Integer noOfBranches = 0;

	@Column(nullable = true)
	private Date commencementDate;

	@Column(nullable = true)
	private Date freezeDate;

	@Column(nullable = true)
	private Date dateOfEstablishment;

	@Column(nullable = true, length = 1)
	private Integer KYCAvailableYN = 0;

	@Lob
	private byte[] signature;

	@Lob
	private byte[] photo;

	@Column(nullable = true, length = 50)
	private String customerTwitterHandle = "";

	@Column(nullable = true, length = 1)
	private Integer introducerConfirmedYN = 0;

	@Column(nullable = true, length = 10)
	private Integer introducerCustNo = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(150)")
	@Column(nullable = true, length = 150)
	private String introducerCustName = "";
	/*
	 * 1: Excellent, 2: Caution, 3: Poor
	 */
	@Column(nullable = true, length = 2)
	private Integer rating = 0;

	@Column(nullable = true, length = 4)
	private Integer customerCategory = 0;

	@Column(nullable = true)
	private Date photoIdExpiryDate = null;

	@Column(nullable = true, length = 4)
	private Integer photoIdProofType = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(20)")
	@Column(nullable = true, length = 20)
	private String homeTelNo = "";

	@Column(nullable = true, length = 4)
	private Integer npaRiskRating = 0;

	@Column(nullable = true, length = 4)
	private Integer occupationType = 0;

	@Column(nullable = true, length = 1)
	private Integer pepYN = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 35)
	private String relOff = "";

	@Column(nullable = true, length = 1)
	private Integer staffYN = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String staffId = "";

	@Column(nullable = true)
	private Double tdsProjected = 0D;

	@Column(nullable = true)
	private Double tdsProvision = 0D;

	@Column(nullable = true)
	private Date tdsFrm15SubDt;

	@Column(nullable = true)
	private Double intProjected = 0D;

	@Column(nullable = true)
	private Double intProvision = 0D;

	@Column(nullable = true)
	private Date memberDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String serviceManager = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String groupCode = "";

	@Column(nullable = true, length = 6)
	private Integer customerBranch = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String dematId = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String dematAccountNo = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String bankName = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String bankAccountNo = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String bankIFSCCode = "";

	// CORPORATE FIELDS - START
	// @Column(nullable = true, columnDefinition = "nvarchar(8)")
	@Column(nullable = true, length = 8)
	private String shortName = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(4)")
	@Column(nullable = true, length = 4)
	private String businessOperationCountry = "";

	@Column(nullable = true, length = 4)
	private Integer subBusinessType = 0;

	@Column(nullable = true, length = 4)
	private Integer operationYears = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(2)")
	@Column(nullable = true, length = 2)
	private String taxResidenceStatus = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String pan = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String taxIdNo = "";

	@Column(nullable = true, length = 1)
	private Integer form60YN = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(30)")
	@Column(nullable = true, length = 30)
	private String gstNo = "";

	@Column(nullable = true)
	private Date gstRegDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String vatRegNo = "";

	@Column(nullable = true)
	private Date vatRegDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String salesTaxRegNo = "";

	@Column(nullable = true)
	private Date salesTaxRegDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(10)")
	@Column(nullable = true, length = 10)
	private String ieCode = "";

	@Column(nullable = true)
	private Date ieCodeRegDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(150)")
	@Column(nullable = true, length = 150)
	private String contactPerson = "";

	@Column(nullable = true, length = 4)
	private Integer annualTurnover = 0;

	@Column(nullable = true, length = 8)
	private Integer noOfEmployees = 0;

	@Column(nullable = true, length = 4)
	private Integer riskRating = 0;

	@Column(nullable = true, length = 1)
	private Integer affiliatedEntityYN = 0;

	@Column(nullable = true, length = 4)
	private Integer affiliationType = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(4)")
	@Column(nullable = true, length = 4)
	private String operationCountry = "";

	@Column(nullable = true, length = 4)
	private Integer custReason = 0;

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String specialInstruct1 = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String specialInstruct2 = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String website = "";
	// CORPORATE FIELDS - END

	// KAFALAH FIELDS - START
	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String nationalId = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String firstnameArabic = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String lastnameArabic = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(50)")
	@Column(nullable = true, length = 50)
	private String companynameArabic = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(8)")
	@Column(nullable = true, length = 8)
	private String smeSize = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(15)")
	@Column(nullable = true, length = 15)
	private String cR700number = "";
	// KAFALAH FIELDS - END

	// For Dedup Start
	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String companyRegistrationNo = "";

	// @Column(nullable = true, columnDefinition = "nvarchar(60)")
	@Column(nullable = true, length = 60)
	private String companyName = "";

	@Column(nullable = true)
	private Date companyDateOfIncorporation;

	// For Dedup End

	// MFI Adding Field

	@Column(nullable = true, length = 1)
	private Integer memGrpYN;

	@Column(nullable = true, length = 10)
	private Integer grpCode;

	@Column(nullable = true, length = 3)
	private Integer grptype;

	@Column(nullable = true, length = 2)
	private Integer memRole;

	@Column(nullable = true)
	private Date grpDate;

	@Column(nullable = true, length = 10)
	private String grpApprovedBy = "";

	@Column(nullable = true, length = 50)
	private String referBy = "";
	// End here

	@Column(nullable = true, length = 2)
	private Integer loanCycleNo;

	@Column(nullable = true, length = 15)
	private String sizeOfFirm = "";

	@Column(nullable = true, length = 15)
	private String lendingUnit = "";

	// @Column(columnDefinition = "nvarchar(8)", nullable = false)
	@Column(nullable = true, length = 8)
	private String fileType = "";

	@Column(nullable = true)
	private Date fileDate;

	// @Column(nullable = true, columnDefinition = "nvarchar(95)")
	@Column(nullable = true, length = 95)
	private String fileName = "";

//		@Transient
//		private List<CustomerKYCDocs> CustomerKYCDocsList= new ArrayList<>();
//		
//		@Transient
//		private List<CustomerAddresses> CustomerAddressesList= new ArrayList<>();
//		
//		public List<CustomerAddresses> getCustomerAddressesList() {
//			return CustomerAddressesList;
//		}
//
//		public void setCustomerAddressesList(List<CustomerAddresses> customerAddressesList) {
//			CustomerAddressesList = customerAddressesList;
//		}
//
//		public List<CustomerKYCDocs> getCustomerKYCDocsList() {
//			return CustomerKYCDocsList;
//		}
//
//		public void setCustomerKYCDocsList(List<CustomerKYCDocs> customerKYCDocsList) {
//			CustomerKYCDocsList = customerKYCDocsList;
//		}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getCustUniqueId() {
		return custUniqueId;
	}

	public void setCustUniqueId(String custUniqueId) {
		this.custUniqueId = custUniqueId;
	}

	public String getFirstnameArabic() {
		if (null != firstnameArabic) {
		} else {
			firstnameArabic = super.initString;
		}
		return firstnameArabic;
	}

	public void setFirstnameArabic(String firstnameArabic) {
		this.firstnameArabic = firstnameArabic;
	}

	public String getLastnameArabic() {
		if (null != lastnameArabic) {
		} else {
			lastnameArabic = super.initString;
		}
		return lastnameArabic;
	}

	public void setLastnameArabic(String lastnameArabic) {
		this.lastnameArabic = lastnameArabic;
	}

	public String getCompanynameArabic() {
		if (null != companynameArabic) {
		} else {
			companynameArabic = super.initString;
		}
		return companynameArabic;
	}

	public void setCompanynameArabic(String companynameArabic) {
		this.companynameArabic = companynameArabic;
	}

	public String getSmeSize() {
		if (null != smeSize) {
		} else {
			smeSize = super.initString;
		}
		return smeSize;
	}

	public void setSmeSize(String smeSize) {
		this.smeSize = smeSize;
	}

	public String getcR700number() {
		if (null != cR700number) {
		} else {
			cR700number = super.initString;
		}
		return cR700number;
	}

	public void setcR700number(String cR700number) {
		this.cR700number = cR700number;
	}

	public String getNationalId() {
		if (null != nationalId) {
		} else {
			nationalId = super.initString;
		}
		return nationalId;
	}

	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}

	public Date getMemberDate() {
		if (null != memberDate) {
		} else {
			memberDate = super.initDate();
		}
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public Double getTdsProvision() {
		if (null != tdsProvision) {
		} else {
			tdsProvision = super.initDouble;
		}
		return tdsProvision;
	}

	public void setTdsProvision(Double tdsProvision) {
		this.tdsProvision = tdsProvision;
	}

	public Double getIntProjected() {
		if (null != intProjected) {
		} else {
			intProjected = super.initDouble;
		}
		return intProjected;
	}

	public void setIntProjected(Double intProjected) {
		this.intProjected = intProjected;
	}

	public Date getPhotoIdExpiryDate() {
		if (null != photoIdExpiryDate) {
		} else {
			photoIdExpiryDate = super.initDate();
		}
		return photoIdExpiryDate;
	}

	public void setPhotoIdExpiryDate(Date photoIdExpiryDate) {
		this.photoIdExpiryDate = photoIdExpiryDate;
	}

	public String getHomeTelNo() {
		if (null != homeTelNo) {
		} else {
			homeTelNo = super.initString;
		}
		return homeTelNo;
	}

	public void setHomeTelNo(String homeTelNo) {
		this.homeTelNo = homeTelNo;
	}

	public String getStaffId() {
		if (null != staffId) {
		} else {
			staffId = super.initString;
		}
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getIntroducerCustName() {
		if (null != introducerCustName) {
		} else {
			introducerCustName = super.initString;
		}
		return introducerCustName;
	}

	public void setIntroducerCustName(String introducerCustName) {
		this.introducerCustName = introducerCustName;
	}

	public Long getCode() {
		if (null != code) {
		} else {
			code = super.initLongInt;
		}
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	/*
	 * public Integer getNoOfShareApplied() { return noOfShareApplied; }
	 * 
	 * public void setNoOfShareApplied(Integer noOfShareApplied) {
	 * this.noOfShareApplied = noOfShareApplied; }
	 */

	public Double getMaxLoanLimit() {
		if (null != maxLoanLimit) {
		} else {
			maxLoanLimit = super.initDouble;
		}
		return maxLoanLimit;
	}

	public void setMaxLoanLimit(Double maxLoanLimit) {
		this.maxLoanLimit = maxLoanLimit;
	}

	public String getMemberFName() {
		if (null != memberFName) {
		} else {
			memberFName = super.initString;
		}
		return getterStringReplace(memberFName);
	}

	public void setMemberFName(String memberFName) {
		this.memberFName = setterStringReplace(memberFName);
	}

	public String getMemberMName() {
		if (null != memberMName) {
		} else {
			memberMName = super.initString;
		}
		return getterStringReplace(memberMName);
	}

	public void setMemberMName(String memberMName) {
		this.memberMName = setterStringReplace(memberMName);
	}

	public String getMemberLName() {
		if (null != memberLName) {
		} else {
			memberLName = super.initString;
		}
		return getterStringReplace(memberLName);
	}

	public void setMemberLName(String memberLName) {
		this.memberLName = setterStringReplace(memberLName);
	}

	public Date getMemberDOB() {
		if (null != memberDOB) {
		} else {
			memberDOB = super.initDate();
		}
		return memberDOB;
	}

	public void setMemberDOB(Date memberDOB) {
		this.memberDOB = memberDOB;
	}

	public Date getDateOfApplication() {
		if (null != dateOfApplication) {
		} else {
			dateOfApplication = super.initDate();
		}
		return dateOfApplication;
	}

	public void setDateOfApplication(Date dateOfApplication) {
		this.dateOfApplication = dateOfApplication;
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

	public Date getMemberSince() {
		if (null != memberSince) {
		} else {
			memberSince = super.initDate();
		}
		return memberSince;
	}

	public void setMemberSince(Date memberSince) {
		this.memberSince = memberSince;
	}

	public String getMemberGender() {
		if (null != memberGender) {
		} else {
			memberGender = super.initString;
		}
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getSpouseName() {
		if (null != spouseName) {
		} else {
			spouseName = super.initString;
		}
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseMbrNum() {
		if (null != spouseMbrNum) {
		} else {
			spouseMbrNum = super.initString;
		}
		return spouseMbrNum;
	}

	public void setSpouseMbrNum(String spouseMbrNum) {
		this.spouseMbrNum = spouseMbrNum;
	}

	public Integer getTotalMaleChild() {
		if (null != totalMaleChild) {
		} else {
			totalMaleChild = super.initInteger;
		}
		return totalMaleChild;
	}

	public void setTotalMaleChild(Integer totalMaleChild) {
		this.totalMaleChild = totalMaleChild;
	}

	public Integer getTotalFemaleChild() {
		if (null != totalFemaleChild) {
		} else {
			totalFemaleChild = super.initInteger;
		}
		return totalFemaleChild;
	}

	public void setTotalFemaleChild(Integer totalFemaleChild) {
		this.totalFemaleChild = totalFemaleChild;
	}

	public Integer getTotalFamilyMbr() {
		if (null != totalFamilyMbr) {
		} else {
			totalFamilyMbr = super.initInteger;
		}
		return totalFamilyMbr;
	}

	public void setTotalFamilyMbr(Integer totalFamilyMbr) {
		this.totalFamilyMbr = totalFamilyMbr;
	}

	public String getPostOfcName() {
		if (null != postOfcName) {
		} else {
			postOfcName = super.initString;
		}
		return postOfcName;
	}

	public void setPostOfcName(String postOfcName) {
		this.postOfcName = postOfcName;
	}

	public String getHobliName() {
		if (null != hobliName) {
		} else {
			hobliName = super.initString;
		}
		return hobliName;
	}

	public void setHobliName(String hobliName) {
		this.hobliName = hobliName;
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

	public Integer getNoOfChildren() {
		if (null != noOfChildren) {
		} else {
			noOfChildren = super.initInteger;
		}
		return noOfChildren;
	}

	public void setNoOfChildren(Integer noOfChildren) {
		this.noOfChildren = noOfChildren;
	}

	public String getFatherSpouseName() {
		if (null != fatherSpouseName) {
		} else {
			fatherSpouseName = super.initString;
		}
		return fatherSpouseName;
	}

	public void setFatherSpouseName(String fatherSpouseName) {
		this.fatherSpouseName = fatherSpouseName;
	}

	public String getMemberRegNo() {
		if (null != memberRegNo) {
		} else {
			memberRegNo = super.initString;
		}
		return memberRegNo;
	}

	public void setMemberRegNo(String memberRegNo) {
		this.memberRegNo = memberRegNo;
	}

	public String getMbrAdditionalInfo() {
		if (null != mbrAdditionalInfo) {
		} else {
			mbrAdditionalInfo = super.initString;
		}
		return mbrAdditionalInfo;
	}

	public void setMbrAdditionalInfo(String mbrAdditionalInfo) {
		this.mbrAdditionalInfo = mbrAdditionalInfo;
	}

	public Double getMemberAmtLimit() {
		if (null != memberAmtLimit) {
		} else {
			memberAmtLimit = super.initDouble;
		}
		return memberAmtLimit;
	}

	public void setMemberAmtLimit(Double memberAmtLimit) {
		this.memberAmtLimit = memberAmtLimit;
	}

	public String getMemberAmtCurrency() {
		if (null != memberAmtCurrency) {
		} else {
			memberAmtCurrency = super.initString;
		}
		return memberAmtCurrency;
	}

	public void setMemberAmtCurrency(String memberAmtCurrency) {
		this.memberAmtCurrency = memberAmtCurrency;
	}

	public String getMemberNumber() {
		if (null != memberNumber) {
		} else {
			memberNumber = super.initString;
		}
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getResidentCountry() {
		if (null != residentCountry) {
		} else {
			residentCountry = super.initString;
		}
		return residentCountry;
	}

	public void setResidentCountry(String residentCountry) {
		this.residentCountry = residentCountry;
	}

	public String getPassportNumber() {
		if (null != passportNumber) {
		} else {
			passportNumber = super.initString;
		}
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getIssuedByCountry() {
		if (null != issuedByCountry) {
		} else {
			issuedByCountry = super.initString;
		}
		return issuedByCountry;
	}

	public void setIssuedByCountry(String issuedByCountry) {
		this.issuedByCountry = issuedByCountry;
	}

	public String getVisaNumber() {
		if (null != visaNumber) {
		} else {
			visaNumber = super.initString;
		}
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

	public Date getPassportIssuedDate() {
		if (null != passportIssuedDate) {
		} else {
			passportIssuedDate = super.initDate();
		}
		return passportIssuedDate;
	}

	public void setPassportIssuedDate(Date passportIssuedDate) {
		this.passportIssuedDate = passportIssuedDate;
	}

	public String getMbrAppNo() {
		if (null != mbrAppNo) {
		} else {
			mbrAppNo = super.initString;
		}
		return mbrAppNo;
	}

	public void setMbrAppNo(String mbrAppNo) {
		this.mbrAppNo = mbrAppNo;
	}

	public Date getPassportExpiryDate() {
		if (null != passportExpiryDate) {
		} else {
			passportExpiryDate = super.initDate();
		}
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public Date getVisaIssuedDate() {
		if (null != visaIssuedDate) {
		} else {
			visaIssuedDate = super.initDate();
		}
		return visaIssuedDate;
	}

	public void setVisaIssuedDate(Date visaIssuedDate) {
		this.visaIssuedDate = visaIssuedDate;
	}

	public Integer getNumberOfDependants() {
		if (null != numberOfDependants) {
		} else {
			numberOfDependants = super.initInteger;
		}
		return numberOfDependants;
	}

	public void setNumberOfDependants(Integer numberOfDependants) {
		this.numberOfDependants = numberOfDependants;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getRefDocNo() {
		if (null != refDocNo) {
		} else {
			refDocNo = super.initString;
		}
		return refDocNo;
	}

	public void setRefDocNo(String refDocNo) {
		this.refDocNo = refDocNo;
	}

	public Long getAadhaarEnrollmentId() {
		if (null != aadhaarEnrollmentId) {
		} else {
			aadhaarEnrollmentId = super.initLongInt;
		}
		return aadhaarEnrollmentId;
	}

	public void setAadhaarEnrollmentId(Long aadhaarEnrollmentId) {
		this.aadhaarEnrollmentId = aadhaarEnrollmentId;
	}

	public Long getAadhaarCardNumber() {
		if (null != aadhaarCardNumber) {
		} else {
			aadhaarCardNumber = super.initLongInt;
		}
		return aadhaarCardNumber;
	}

	public void setAadhaarCardNumber(Long aadhaarCardNumber) {
		this.aadhaarCardNumber = aadhaarCardNumber;
	}

	public String getTempDate() {
		if (null != tempDate) {
		} else {
			tempDate = super.initString;
		}
		return tempDate;
	}

	public void setTempDate(String tempDate) {
		this.tempDate = tempDate;
	}

	/*
	 * public AuthMKCK setAuthMkCkFields(AuthMKCK authMkCk) {
	 * authMkCk.setRefID(getId());
	 * authMkCk.setMenuAction("customerCRUDById.action");
	 * authMkCk.setEntityEntryCode(getMemberCode()); return authMkCk; }
	 */

	public String getDateOfBirthStr() {
		if (null != dateOfBirthStr) {
		} else {
			dateOfBirthStr = super.initString;
		}
		return dateOfBirthStr;
	}

	public void setDateOfBirthStr(String dateOfBirthStr) {
		this.dateOfBirthStr = dateOfBirthStr;
	}

	public String getTempPhoto() {
		if (null != tempPhoto) {
		} else {
			tempPhoto = super.initString;
		}
		return tempPhoto;
	}

	public void setTempPhoto(String tempPhoto) {
		this.tempPhoto = tempPhoto;
	}

	public String getMemberFullName() {
		if (null != memberFullName) {
		} else {
			memberFullName = super.initString;
		}
		return memberFullName;
	}

	public String getPlaceOfEstablishment() {
		if (null != placeOfEstablishment) {
		} else {
			placeOfEstablishment = super.initString;
		}
		return placeOfEstablishment;
	}

	public void setPlaceOfEstablishment(String placeOfEstablishment) {
		this.placeOfEstablishment = placeOfEstablishment;
	}

	public String getRegistrationNo() {
		if (null != registrationNo) {
		} else {
			registrationNo = super.initString;
		}
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Integer getNoOfBranches() {
		if (null != noOfBranches) {
		} else {
			noOfBranches = super.initInteger;
		}
		return noOfBranches;
	}

	public void setNoOfBranches(Integer noOfBranches) {
		this.noOfBranches = noOfBranches;
	}

	public Date getCommencementDate() {
		if (null != commencementDate) {
		} else {
			commencementDate = super.initDate();
		}
		return commencementDate;
	}

	public void setCommencementDate(Date commencementDate) {
		this.commencementDate = commencementDate;
	}

	public Date getDateOfEstablishment() {
		if (null != dateOfEstablishment) {
		} else {
			dateOfEstablishment = super.initDate();
		}
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(Date dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public void setMemberFullName(String memberFullName) {
		this.memberFullName = memberFullName;
	}

	/**
	 * Returns full name of the customer e.g. Mr Sachin Ramesh Tendulkar.
	 * 
	 * @return Full name of the customer.
	 */

	public String getFreezeType() {
		if (null != freezeType) {
		} else {
			freezeType = super.initString;
		}
		return freezeType;
	}

	public void setFreezeType(String freezeType) {
		this.freezeType = freezeType;
	}

	public String getCustomerTwitterHandle() {
		if (null != customerTwitterHandle) {
		} else {
			customerTwitterHandle = super.initString;
		}
		return customerTwitterHandle;
	}

	public void setCustomerTwitterHandle(String customerTwitterHandle) {
		this.customerTwitterHandle = customerTwitterHandle;
	}

	public Date getKycExpiryDate() {
		if (null != kycExpiryDate) {
		} else {
			kycExpiryDate = super.initDate();
		}
		return kycExpiryDate;
	}

	public void setKycExpiryDate(Date kycExpiryDate) {
		this.kycExpiryDate = kycExpiryDate;
	}

	public String getStrAddress1() {
		if (null != strAddress1) {
		} else {
			strAddress1 = super.initString;
		}
		return strAddress1;
	}

	public void setStrAddress1(String strAddress1) {
		this.strAddress1 = strAddress1;
	}

	public String getStrAddress2() {
		if (null != strAddress2) {
		} else {
			strAddress2 = super.initString;
		}
		return strAddress2;
	}

	public void setStrAddress2(String strAddress2) {
		this.strAddress2 = strAddress2;
	}

	public String getStrAddress3() {
		if (null != strAddress3) {
		} else {
			strAddress3 = super.initString;
		}
		return strAddress3;
	}

	public void setStrAddress3(String strAddress3) {
		this.strAddress3 = strAddress3;
	}

	public String getStrCountryCode() {
		if (null != strCountryCode) {
		} else {
			strCountryCode = super.initString;
		}
		return strCountryCode;
	}

	public void setStrCountryCode(String strCountryCode) {
		this.strCountryCode = strCountryCode;
	}

	public String getStrStateCode() {
		if (null != strStateCode) {
		} else {
			strStateCode = super.initString;
		}
		return strStateCode;
	}

	public void setStrStateCode(String strStateCode) {
		this.strStateCode = strStateCode;
	}

	public String getStrDistrictCode() {
		if (null != strDistrictCode) {
		} else {
			strDistrictCode = super.initString;
		}
		return strDistrictCode;
	}

	public void setStrDistrictCode(String strDistrictCode) {
		this.strDistrictCode = strDistrictCode;
	}

	public String getStrMunicipalityId() {
		if (null != strMunicipalityId) {
		} else {
			strMunicipalityId = super.initString;
		}
		return strMunicipalityId;
	}

	public void setStrMunicipalityId(String strMunicipalityId) {
		this.strMunicipalityId = strMunicipalityId;
	}

	public String getStrVillage() {
		if (null != strVillage) {
		} else {
			strVillage = super.initString;
		}
		return strVillage;
	}

	public void setStrVillage(String strVillage) {
		this.strVillage = strVillage;
	}

	public String getStrPinCode() {
		if (null != strPinCode) {
		} else {
			strPinCode = super.initString;
		}
		return strPinCode;
	}

	public void setStrPinCode(String strPinCode) {
		this.strPinCode = strPinCode;
	}

	public Date getFreezeDate() {
		if (null != freezeDate) {
		} else {
			freezeDate = super.initDate();
		}
		return freezeDate;
	}

	public void setFreezeDate(Date freezeDate) {
		this.freezeDate = freezeDate;
	}

	public String getCustomerTypeStr() {
		if (null != customerTypeStr) {
		} else {
			customerTypeStr = super.initString;
		}
		return customerTypeStr;
	}

	public void setCustomerTypeStr(String customerTypeStr) {
		this.customerTypeStr = customerTypeStr;
	}

	public String getServiceManager() {
		if (null != serviceManager) {
		} else {
			serviceManager = super.initString;
		}
		return serviceManager;
	}

	public void setServiceManager(String serviceManager) {
		this.serviceManager = serviceManager;
	}

	public String getGroupCode() {
		if (null != groupCode) {
		} else {
			groupCode = super.initString;
		}
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getDematId() {
		if (null != dematId) {
		} else {
			dematId = super.initString;
		}
		return dematId;
	}

	public void setDematId(String dematId) {
		this.dematId = dematId;
	}

	public String getDematAccountNo() {
		if (null != dematAccountNo) {
		} else {
			dematAccountNo = super.initString;
		}
		return dematAccountNo;
	}

	public void setDematAccountNo(String dematAccountNo) {
		this.dematAccountNo = dematAccountNo;
	}

	public String getBankName() {
		if (null != bankName) {
		} else {
			bankName = super.initString;
		}
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccountNo() {
		if (null != bankAccountNo) {
		} else {
			bankAccountNo = super.initString;
		}
		return bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getBankIFSCCode() {
		if (null != bankIFSCCode) {
		} else {
			bankIFSCCode = super.initString;
		}
		return bankIFSCCode;
	}

	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getShortName() {
		if (null != shortName) {
		} else {
			shortName = super.initString;
		}
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getBusinessOperationCountry() {
		if (null != businessOperationCountry) {
		} else {
			businessOperationCountry = super.initString;
		}
		return businessOperationCountry;
	}

	public void setBusinessOperationCountry(String businessOperationCountry) {
		this.businessOperationCountry = businessOperationCountry;
	}

	public Integer getOperationYears() {
		if (null != operationYears) {
		} else {
			operationYears = super.initInteger;
		}
		return operationYears;
	}

	public void setOperationYears(Integer operationYears) {
		this.operationYears = operationYears;
	}

	public String getTaxResidenceStatus() {
		if (null != taxResidenceStatus) {
		} else {
			taxResidenceStatus = super.initString;
		}
		return taxResidenceStatus;
	}

	public void setTaxResidenceStatus(String taxResidenceStatus) {
		this.taxResidenceStatus = taxResidenceStatus;
	}

	public String getTaxIdNo() {
		if (null != taxIdNo) {
		} else {
			taxIdNo = super.initString;
		}
		return taxIdNo;
	}

	public void setTaxIdNo(String taxIdNo) {
		this.taxIdNo = taxIdNo;
	}

	public String getGstNo() {
		if (null != gstNo) {
		} else {
			gstNo = super.initString;
		}
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public Date getGstRegDate() {
		if (null != gstRegDate) {
		} else {
			gstRegDate = super.initDate();
		}
		return gstRegDate;
	}

	public void setGstRegDate(Date gstRegDate) {
		this.gstRegDate = gstRegDate;
	}

	public String getVatRegNo() {
		if (null != vatRegNo) {
		} else {
			vatRegNo = super.initString;
		}
		return vatRegNo;
	}

	public void setVatRegNo(String vatRegNo) {
		this.vatRegNo = vatRegNo;
	}

	public Date getVatRegDate() {
		if (null != vatRegDate) {
		} else {
			vatRegDate = super.initDate();
		}
		return vatRegDate;
	}

	public void setVatRegDate(Date vatRegDate) {
		this.vatRegDate = vatRegDate;
	}

	public String getSalesTaxRegNo() {
		if (null != salesTaxRegNo) {
		} else {
			salesTaxRegNo = super.initString;
		}
		return salesTaxRegNo;
	}

	public void setSalesTaxRegNo(String salesTaxRegNo) {
		this.salesTaxRegNo = salesTaxRegNo;
	}

	public Date getSalesTaxRegDate() {
		if (null != salesTaxRegDate) {
		} else {
			salesTaxRegDate = super.initDate();
		}
		return salesTaxRegDate;
	}

	public void setSalesTaxRegDate(Date salesTaxRegDate) {
		this.salesTaxRegDate = salesTaxRegDate;
	}

	public String getIeCode() {
		if (null != ieCode) {
		} else {
			ieCode = super.initString;
		}
		return ieCode;
	}

	public void setIeCode(String ieCode) {
		this.ieCode = ieCode;
	}

	public Date getIeCodeRegDate() {
		if (null != ieCodeRegDate) {
		} else {
			ieCodeRegDate = super.initDate();
		}
		return ieCodeRegDate;
	}

	public void setIeCodeRegDate(Date ieCodeRegDate) {
		this.ieCodeRegDate = ieCodeRegDate;
	}

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

	public String getOperationCountry() {
		if (null != operationCountry) {
		} else {
			operationCountry = super.initString;
		}
		return operationCountry;
	}

	public void setOperationCountry(String operationCountry) {
		this.operationCountry = operationCountry;
	}

	public String getSpecialInstruct1() {
		if (null != specialInstruct1) {
		} else {
			specialInstruct1 = super.initString;
		}
		return specialInstruct1;
	}

	public void setSpecialInstruct1(String specialInstruct1) {
		this.specialInstruct1 = specialInstruct1;
	}

	public String getSpecialInstruct2() {
		if (null != specialInstruct2) {
		} else {
			specialInstruct2 = super.initString;
		}
		return specialInstruct2;
	}

	public void setSpecialInstruct2(String specialInstruct2) {
		this.specialInstruct2 = specialInstruct2;
	}

	public String getPan() {
		if (null != pan) {
		} else {
			pan = super.initString;
		}
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getWebsite() {
		if (null != website) {
		} else {
			website = super.initString;
		}
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Integer getTransactionFreeze() {
		if (null != transactionFreeze) {
		} else {
			transactionFreeze = super.initInteger;
		}
		return transactionFreeze;
	}

	public void setTransactionFreeze(Integer transactionFreeze) {
		this.transactionFreeze = transactionFreeze;
	}

	public Integer getResidentYN() {
		if (null != residentYN) {
		} else {
			residentYN = super.initInteger;
		}
		return residentYN;
	}

	public void setResidentYN(Integer residentYN) {
		this.residentYN = residentYN;
	}

	public Integer getPepYN() {
		if (null != pepYN) {
		} else {
			pepYN = super.initInteger;
		}
		return pepYN;
	}

	public void setPepYN(Integer pepYN) {
		this.pepYN = pepYN;
	}

	public Integer getStaffYN() {
		if (null != staffYN) {
		} else {
			staffYN = super.initInteger;
		}
		return staffYN;
	}

	public void setStaffYN(Integer staffYN) {
		this.staffYN = staffYN;
	}

	public Integer getBaseTenantCode() {
		if (null != baseTenantCode) {
		} else {
			baseTenantCode = super.initInteger;
		}
		return baseTenantCode;
	}

	public void setBaseTenantCode(Integer baseTenantCode) {
		this.baseTenantCode = baseTenantCode;
	}

	public String getNameTitle() {
		if (null != nameTitle) {
		} else {
			nameTitle = super.initString;
		}
		return nameTitle;
	}

	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}

	public String getPhone() {
		if (null != phone) {
		} else {
			phone = super.initString;
		}
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		if (null != fax) {
		} else {
			fax = super.initString;
		}
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Integer getFrzReasonCd() {
		if (null != frzReasonCd) {
		} else {
			frzReasonCd = super.initInteger;
		}
		return frzReasonCd;
	}

	public void setFrzReasonCd(Integer frzReasonCd) {
		this.frzReasonCd = frzReasonCd;
	}

	public String getSplInstr1() {
		if (null != splInstr1) {
		} else {
			splInstr1 = super.initString;
		}
		return splInstr1;
	}

	public void setSplInstr1(String splInstr1) {
		this.splInstr1 = splInstr1;
	}

	public Integer getIntroducerCon() {
		if (null != introducerCon) {
		} else {
			introducerCon = super.initInteger;
		}
		return introducerCon;
	}

	public void setIntroducerCon(Integer introducerCon) {
		this.introducerCon = introducerCon;
	}

	public Integer getTdsYN() {
		if (null != tdsYN) {
		} else {
			tdsYN = super.initInteger;
		}
		return tdsYN;
	}

	public void setTdsYN(Integer tdsYN) {
		this.tdsYN = tdsYN;
	}

	public Integer getRating() {
		if (null != rating) {
		} else {
			rating = super.initInteger;
		}
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getRelOff() {
		if (null != relOff) {
		} else {
			relOff = super.initString;
		}
		return relOff;
	}

	public void setRelOff(String relOff) {
		this.relOff = relOff;
	}

	public Double getTdsProjected() {
		if (null != tdsProjected) {
		} else {
			tdsProjected = super.initDouble;
		}
		return tdsProjected;
	}

	public void setTdsProjected(Double tdsProjected) {
		this.tdsProjected = tdsProjected;
	}

	public Date getTdsFrm15SubDt() {
		if (null != tdsFrm15SubDt) {
		} else {
			tdsFrm15SubDt = super.initDate();
		}
		return tdsFrm15SubDt;
	}

	public void setTdsFrm15SubDt(Date tdsFrm15SubDt) {
		this.tdsFrm15SubDt = tdsFrm15SubDt;
	}

	public Double getIntProvision() {
		if (null != intProvision) {
		} else {
			intProvision = super.initDouble;
		}
		return intProvision;
	}

	public void setIntProvision(Double intProvision) {
		this.intProvision = intProvision;
	}

	public String getFullName() {
		return getNameTitle() + " " + getMemberFName() + " " + getMemberMName() + " " + getMemberLName();
	}

	public String getSeqType() {
		if (null != seqType) {
		} else {
			seqType = super.initString;
		}
		return seqType;
	}

	public void setSeqType(String seqType) {
		this.seqType = seqType;
	}

	public Integer getReligion() {
		if (null != religion) {
		} else {
			religion = super.initInteger;
		}
		return religion;
	}

	public void setReligion(Integer religion) {
		this.religion = religion;
	}

	public Integer getMemberCaste() {
		if (null != memberCaste) {
		} else {
			memberCaste = super.initInteger;
		}
		return memberCaste;
	}

	public void setMemberCaste(Integer memberCaste) {
		this.memberCaste = memberCaste;
	}

	public Integer getSubCaste() {
		if (null != subCaste) {
		} else {
			subCaste = super.initInteger;
		}
		return subCaste;
	}

	public void setSubCaste(Integer subCaste) {
		this.subCaste = subCaste;
	}

	public Integer getMbrMaritalStatus() {
		if (null != mbrMaritalStatus) {
		} else {
			mbrMaritalStatus = super.initInteger;
		}
		return mbrMaritalStatus;
	}

	public void setMbrMaritalStatus(Integer mbrMaritalStatus) {
		this.mbrMaritalStatus = mbrMaritalStatus;
	}

	public Integer getResAddProofID() {
		if (null != resAddProofID) {
		} else {
			resAddProofID = super.initInteger;
		}
		return resAddProofID;
	}

	public void setResAddProofID(Integer resAddProofID) {
		this.resAddProofID = resAddProofID;
	}

	public Integer getMemberTypeCode() {
		if (null != memberTypeCode) {
		} else {
			memberTypeCode = super.initInteger;
		}
		return memberTypeCode;
	}

	public void setMemberTypeCode(Integer memberTypeCode) {
		this.memberTypeCode = memberTypeCode;
	}

	public Integer getKYCType() {
		if (null != KYCType) {
		} else {
			KYCType = super.initInteger;
		}
		return KYCType;
	}

	public void setKYCType(Integer kYCType) {
		KYCType = kYCType;
	}

	public Integer getHNWCategory() {
		if (null != HNWCategory) {
		} else {
			HNWCategory = super.initInteger;
		}
		return HNWCategory;
	}

	public void setHNWCategory(Integer hNWCategory) {
		HNWCategory = hNWCategory;
	}

	public Integer getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(Integer customerStatus) {
		this.customerStatus = customerStatus;
	}

	public Integer getCloseReason() {
		if (null != closeReason) {
		} else {
			closeReason = super.initInteger;
		}
		return closeReason;
	}

	public void setCloseReason(Integer closeReason) {
		this.closeReason = closeReason;
	}

	public Integer getMemberCasteCategory() {
		if (null != memberCasteCategory) {
		} else {
			memberCasteCategory = super.initInteger;
		}
		return memberCasteCategory;
	}

	public void setMemberCasteCategory(Integer memberCasteCategory) {
		this.memberCasteCategory = memberCasteCategory;
	}

	public Integer getMemberCategory() {
		if (null != memberCategory) {
		} else {
			memberCategory = super.initInteger;
		}
		return memberCategory;
	}

	public void setMemberCategory(Integer memberCategory) {
		this.memberCategory = memberCategory;
	}

	public Integer getMemberType() {
		if (null != memberType) {
		} else {
			memberType = super.initInteger;
		}
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public Integer getResidentialStatus() {
		if (null != residentialStatus) {
		} else {
			residentialStatus = super.initInteger;
		}
		return residentialStatus;
	}

	public void setResidentialStatus(Integer residentialStatus) {
		this.residentialStatus = residentialStatus;
	}

	public Integer getVisaType() {
		if (null != visaType) {
		} else {
			visaType = super.initInteger;
		}
		return visaType;
	}

	public void setVisaType(Integer visaType) {
		this.visaType = visaType;
	}

	public Integer getMemberCreationBranch() {
		if (null != memberCreationBranch) {
		} else {
			memberCreationBranch = super.initInteger;
		}
		return memberCreationBranch;
	}

	public void setMemberCreationBranch(Integer memberCreationBranch) {
		this.memberCreationBranch = memberCreationBranch;
	}

	public Integer getCustomerType() {
		if (null != customerType) {
		} else {
			customerType = super.initInteger;
		}
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
	}

	public Integer getResidenceType() {
		if (null != residenceType) {
		} else {
			residenceType = super.initInteger;
		}
		return residenceType;
	}

	public void setResidenceType(Integer residenceType) {
		this.residenceType = residenceType;
	}

	public Integer getAMLRating() {
		if (null != AMLRating) {
		} else {
			AMLRating = super.initInteger;
		}
		return AMLRating;
	}

	public void setAMLRating(Integer aMLRating) {
		AMLRating = aMLRating;
	}

	public Double getTdsPercentage() {
		if (null != tdsPercentage) {
		} else {
			tdsPercentage = super.initDouble;
		}
		return tdsPercentage;
	}

	public void setTdsPercentage(Double tdsPercentage) {
		this.tdsPercentage = tdsPercentage;
	}

	public Integer getNationality() {
		if (null != nationality) {
		} else {
			nationality = super.initInteger;
		}
		return nationality;
	}

	public void setNationality(Integer nationality) {
		this.nationality = nationality;
	}

	public Integer getOrgType() {
		if (null != orgType) {
		} else {
			orgType = super.initInteger;
		}
		return orgType;
	}

	public void setOrgType(Integer orgType) {
		this.orgType = orgType;
	}

	public Integer getBusinessType() {
		if (null != businessType) {
		} else {
			businessType = super.initInteger;
		}
		return businessType;
	}

	public void setBusinessType(Integer businessType) {
		this.businessType = businessType;
	}

	public Integer getKYCAvailableYN() {
		if (null != KYCAvailableYN) {
		} else {
			KYCAvailableYN = super.initInteger;
		}
		return KYCAvailableYN;
	}

	public void setKYCAvailableYN(Integer kYCAvailableYN) {
		KYCAvailableYN = kYCAvailableYN;
	}

	public Integer getIntroducerConfirmedYN() {
		if (null != introducerConfirmedYN) {
		} else {
			introducerConfirmedYN = super.initInteger;
		}
		return introducerConfirmedYN;
	}

	public void setIntroducerConfirmedYN(Integer introducerConfirmedYN) {
		this.introducerConfirmedYN = introducerConfirmedYN;
	}

	public Integer getIntroducerCustNo() {
		if (null != introducerCustNo) {
		} else {
			introducerCustNo = super.initInteger;
		}
		return introducerCustNo;
	}

	public void setIntroducerCustNo(Integer introducerCustNo) {
		this.introducerCustNo = introducerCustNo;
	}

	public Integer getCustomerCategory() {
		if (null != customerCategory) {
		} else {
			customerCategory = super.initInteger;
		}
		return customerCategory;
	}

	public void setCustomerCategory(Integer customerCategory) {
		this.customerCategory = customerCategory;
	}

	public Integer getPhotoIdProofType() {
		if (null != photoIdProofType) {
		} else {
			photoIdProofType = super.initInteger;
		}
		return photoIdProofType;
	}

	public void setPhotoIdProofType(Integer photoIdProofType) {
		this.photoIdProofType = photoIdProofType;
	}

	public Integer getNpaRiskRating() {
		if (null != npaRiskRating) {
		} else {
			npaRiskRating = super.initInteger;
		}
		return npaRiskRating;
	}

	public void setNpaRiskRating(Integer npaRiskRating) {
		this.npaRiskRating = npaRiskRating;
	}

	public Integer getOccupationType() {
		if (null != occupationType) {
		} else {
			occupationType = super.initInteger;
		}
		return occupationType;
	}

	public void setOccupationType(Integer occupationType) {
		this.occupationType = occupationType;
	}

	public Integer getCustomerBranch() {
		if (null != customerBranch) {
		} else {
			customerBranch = super.initInteger;
		}
		return customerBranch;
	}

	public void setCustomerBranch(Integer customerBranch) {
		this.customerBranch = customerBranch;
	}

	public Integer getSubBusinessType() {
		if (null != subBusinessType) {
		} else {
			subBusinessType = super.initInteger;
		}
		return subBusinessType;
	}

	public void setSubBusinessType(Integer subBusinessType) {
		this.subBusinessType = subBusinessType;
	}

	public Integer getForm60YN() {
		if (null != form60YN) {
		} else {
			form60YN = super.initInteger;
		}
		return form60YN;
	}

	public void setForm60YN(Integer form60yn) {
		form60YN = form60yn;
	}

	public Integer getQualification() {
		if (null != qualification) {
		} else {
			qualification = super.initInteger;
		}
		return qualification;
	}

	public void setQualification(Integer qualification) {
		this.qualification = qualification;
	}

	public Integer getBloodGroup() {
		if (null != bloodGroup) {
		} else {
			bloodGroup = super.initInteger;
		}
		return bloodGroup;
	}

	public void setBloodGroup(Integer bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Integer getOccupation() {
		if (null != occupation) {
		} else {
			occupation = super.initInteger;
		}
		return occupation;
	}

	public void setOccupation(Integer occupation) {
		this.occupation = occupation;
	}

	public Integer getTransactionFreezeReason() {
		if (null != transactionFreezeReason) {
		} else {
			transactionFreezeReason = super.initInteger;
		}
		return transactionFreezeReason;
	}

	public void setTransactionFreezeReason(Integer transactionFreezeReason) {
		this.transactionFreezeReason = transactionFreezeReason;
	}

	public Integer getNPARating() {
		if (null != NPARating) {
		} else {
			NPARating = super.initInteger;
		}
		return NPARating;
	}

	public void setNPARating(Integer nPARating) {
		NPARating = nPARating;
	}

	public Integer getNPAReason() {
		if (null != NPAReason) {
		} else {
			NPAReason = super.initInteger;
		}
		return NPAReason;
	}

	public void setNPAReason(Integer nPAReason) {
		NPAReason = nPAReason;
	}

	public Integer getBaseBranchCode() {
		if (null != baseBranchCode) {
		} else {
			baseBranchCode = super.initInteger;
		}
		return baseBranchCode;
	}

	public void setBaseBranchCode(Integer baseBranchCode) {
		this.baseBranchCode = baseBranchCode;
	}

	public Integer getIntroducerNumber() {
		if (null != introducerNumber) {
		} else {
			introducerNumber = super.initInteger;
		}
		return introducerNumber;
	}

	public void setIntroducerNumber(Integer introducerNumber) {
		this.introducerNumber = introducerNumber;
	}

	public Integer getTdsReasonCd() {
		if (null != tdsReasonCd) {
		} else {
			tdsReasonCd = super.initInteger;
		}
		return tdsReasonCd;
	}

	public void setTdsReasonCd(Integer tdsReasonCd) {
		this.tdsReasonCd = tdsReasonCd;
	}

	public Integer getAnnualTurnover() {
		if (null != annualTurnover) {
		} else {
			annualTurnover = super.initInteger;
		}
		return annualTurnover;
	}

	public void setAnnualTurnover(Integer annualTurnover) {
		this.annualTurnover = annualTurnover;
	}

	public Integer getNoOfEmployees() {
		if (null != noOfEmployees) {
		} else {
			noOfEmployees = super.initInteger;
		}
		return noOfEmployees;
	}

	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}

	public Integer getRiskRating() {
		if (null != noOfEmployees) {
		} else {
			noOfEmployees = super.initInteger;
		}
		return riskRating;
	}

	public void setRiskRating(Integer riskRating) {
		this.riskRating = riskRating;
	}

	public Integer getAffiliatedEntityYN() {
		if (null != affiliatedEntityYN) {
		} else {
			affiliatedEntityYN = super.initInteger;
		}
		return affiliatedEntityYN;
	}

	public void setAffiliatedEntityYN(Integer affiliatedEntityYN) {
		this.affiliatedEntityYN = affiliatedEntityYN;
	}

	public Integer getAffiliationType() {
		if (null != affiliationType) {
		} else {
			affiliationType = super.initInteger;
		}
		return affiliationType;
	}

	public void setAffiliationType(Integer affiliationType) {
		this.affiliationType = affiliationType;
	}

	public Integer getCustReason() {
		if (null != custReason) {
		} else {
			custReason = super.initInteger;
		}
		return custReason;
	}

	public void setCustReason(Integer custReason) {
		this.custReason = custReason;
	}

	public String getCompanyRegistrationNo() {
		if (null != companyRegistrationNo) {
		} else {
			companyRegistrationNo = super.initString;
		}
		return companyRegistrationNo;
	}

	public void setCompanyRegistrationNo(String companyRegistrationNo) {
		this.companyRegistrationNo = companyRegistrationNo;
	}

	public String getCompanyName() {
		if (null != companyName) {
		} else {
			companyName = super.initString;
		}
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCompanyDateOfIncorporation() {
		if (null != companyDateOfIncorporation) {
		} else {
			companyDateOfIncorporation = super.initDate();
		}
		return companyDateOfIncorporation;
	}

	public void setCompanyDateOfIncorporation(Date companyDateOfIncorporation) {
		this.companyDateOfIncorporation = companyDateOfIncorporation;
	}

	public String getLegalEntity() {
		return legalEntity;
	}

	public void setLegalEntity(String legalEntity) {
		this.legalEntity = legalEntity;
	}

	public Integer getMemGrpYN() {
		return memGrpYN;
	}

	public void setMemGrpYN(Integer memGrpYN) {
		this.memGrpYN = memGrpYN;
	}

	public Integer getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(Integer grpCode) {
		this.grpCode = grpCode;
	}

	public Integer getGrptype() {
		return grptype;
	}

	public void setGrptype(Integer grptype) {
		this.grptype = grptype;
	}

	public Integer getMemRole() {
		return memRole;
	}

	public void setMemRole(Integer memRole) {
		this.memRole = memRole;
	}

	public Date getGrpDate() {
		return grpDate;
	}

	public void setGrpDate(Date grpDate) {
		this.grpDate = grpDate;
	}

	public String getGrpApprovedBy() {
		return grpApprovedBy;
	}

	public void setGrpApprovedBy(String grpApprovedBy) {
		this.grpApprovedBy = grpApprovedBy;
	}

	public String getReferBy() {
		return referBy;
	}

	public void setReferBy(String referBy) {
		this.referBy = referBy;
	}

	public Integer getLoanCycleNo() {
		return loanCycleNo;
	}

	public void setLoanCycleNo(Integer loanCycleNo) {
		this.loanCycleNo = loanCycleNo;
	}

	public String getSizeOfFirm() {
		return sizeOfFirm;
	}

	public void setSizeOfFirm(String sizeOfFirm) {
		this.sizeOfFirm = sizeOfFirm;
	}

	public String getLendingUnit() {
		return lendingUnit;
	}

	public void setLendingUnit(String lendingUnit) {
		this.lendingUnit = lendingUnit;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(Integer memberCode) {
		this.memberCode = memberCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberCode == null) ? 0 : memberCode.hashCode());
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
		CustomerMst2 other = (CustomerMst2) obj;
		if (memberCode == null) {
			if (other.memberCode != null)
				return false;
		} else if (!memberCode.equals(other.memberCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D009011Key getD009011Key() {
		D009011Key d009011Key = new D009011Key();
		d009011Key.setMemberCode(this.memberCode);
		d009011Key.setTenantId(this.tenantId);
		return d009011Key;
	}
}
