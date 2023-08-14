package ai.kiya.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonFormat;

import ai.kiya.base.Base;
import ai.kiya.key.EmployeeKey;

@Table(name = "EmployeeMst")
@Entity
@IdClass(EmployeeKey.class)
public class EmployeeMst extends Base {

//	@EmbeddedId
//	private EmployeeKey empKey = new EmployeeKey();

	private static final long serialVersionUID = -6686126227253619023L;

	//
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 40, nullable = false)
	private String empId = "";

	//

	// @Column(columnDefinition = "nvarchar(200)", nullable = false)
	@Column(length = 200, nullable = false)
	private String empName = "";

	@Column(length = 200, nullable = false)
	private String empFName = "";

	@Column(length = 200, nullable = false)
	private String empMName = "";

	@Column(length = 200, nullable = false)
	private String empLName = "";

	@Column(length = 200, nullable = false)
	private String repoMngr = "";

	@Column(nullable = true)
	private Integer postBr;

	@Column(nullable = true)
	private Integer dept;

	@Column(nullable = true)
	private Integer maritalStatus;

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	@Column(length = 10, nullable = false)
	private String designation = "";

	// @Column(columnDefinition = "DATETIME", nullable = false)
	@Column(nullable = false)
	private Date joinDate;

	// @Column(columnDefinition = "DATETIME", nullable = false)
	@Column(nullable = false)
	private Date birthDate;

	// @Column(columnDefinition = "nvarchar(1)", nullable = false)
	@Column(length = 10, nullable = false)
	private String gender;

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	@Column(length = 10, nullable = false)
	private String employmentType = "";

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	@Column(length = 2, nullable = true)
	private String bloodGroup = "";

	// @Column(columnDefinition = "nvarchar(3)", nullable = false)
	@Column(length = 3, nullable = true)
	private String idProof = "";

	// @Column(columnDefinition = "nvarchar(25)", nullable = false)
	@Column(length = 25, nullable = true)
	private String idNumber = "";

	// @Column(columnDefinition = "DATE", nullable = true)
	@Column(nullable = true)
	private Date issueDate;

	// @Column(columnDefinition = "nvarchar(3)", nullable = true)
	@Column(length = 3, nullable = true)
	private String docIssuedBy;

	// @Column(columnDefinition = "nvarchar(75)", nullable = false)
	@Column(length = 75, nullable = true)
	private String idProofName = "";

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	@Column(length = 10, nullable = false)
	private String education = "";

	// @Column(columnDefinition = "nvarchar(3)", nullable = false)
	// @Column(length=3, nullable = false)
	@Column(length = 3, nullable = true)
	private String religion = "";

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	// @Column(length=2, nullable = false)
	@Column(length = 2, nullable = true)
	private String caste = "";

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	// @Column(length=2, nullable = false)
	@Column(length = 2, nullable = true)
	private String subCaste = "";

	// @Column(columnDefinition = "nvarchar(4)", nullable = false)
	@Column(length = 4, nullable = false)
	private String status = "";

	// @Column(columnDefinition = "DATE", nullable = true)
	@Column(nullable = true)
	private Date retireDate;

	// @Column(columnDefinition = "nvarchar(250)", nullable = true)
	@Column(length = 250, nullable = true)
	private String remark = "";

	// @Column(columnDefinition = "nvarchar(2)", nullable = false)
	@Column(length = 2, nullable = true)
	private String addrIdType = "";

	// @Column(columnDefinition = "nvarchar(25)", nullable = false)
	@Column(length = 25, nullable = true)
	private String addrIdNo = "";

	// @Column(columnDefinition = "nvarchar(75)", nullable = false)
	@Column(length = 75, nullable = false)
	private String address1 = "";

	// @Column(columnDefinition = "nvarchar(75)", nullable = false)
	@Column(length = 75, nullable = true)
	private String address2 = "";

	// @Column(columnDefinition = "nvarchar(75)", nullable = false)
	@Column(length = 75, nullable = true)
	private String address3 = "";

	// @Column(columnDefinition = "nvarchar(4)", nullable = false)
	@Column(length = 4, nullable = false)
	private String country = "";

	// @Column(columnDefinition = "nvarchar(4)", nullable = false)
	@Column(length = 4, nullable = false)
	private String state = "";

	// @Column(columnDefinition = "nvarchar(4)", nullable = false)
	@Column(length = 4, nullable = false)
	private String city = "";

	@Column(length = 15, nullable = false)
	private Integer postalCode = 0;

	// @Column(columnDefinition = "nvarchar(50)", nullable = false)
	@Column(length = 50, nullable = false)
	private String email = "";

	// @Column(columnDefinition = "nvarchar(15)", nullable = false)
	@Column(length = 15, nullable = true)
	private String officeTelephone = "";

	// @Column(columnDefinition = "nvarchar(15)", nullable = false)
	@Column(length = 15, nullable = false)
	private String mobile = "";

	// @Column(columnDefinition = "nvarchar(20) default ' '", nullable = true)
	@Column(length = 20, nullable = true)
	private String userSalutation = ""; // self-join

	@NotAudited
	@ElementCollection
	@JoinTable(name = "EMP_ADDRESS", joinColumns = { @JoinColumn(name = "tenantId"), @JoinColumn(name = "empId") })
	@GenericGenerator(name = "sequence_gen", strategy = "sequence")
	@CollectionId(columns = { @Column(name = "Id") }, generator = "sequence_gen", type = @Type(type = "long"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Address> empAddresses = new ArrayList<Address>();

	@OneToMany(mappedBy = "employeeMst", fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Address2> addresList = new ArrayList<Address2>();

	public Collection<Address> getEmpAddresses() {
		return empAddresses;
	}

	public void setEmpAddresses(Collection<Address> empAddresses) {
		this.empAddresses = empAddresses;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getDocIssuedBy() {
		return docIssuedBy;
	}

	public void setDocIssuedBy(String docIssuedBy) {
		this.docIssuedBy = docIssuedBy;
	}

	public String getIdProofName() {
		return idProofName;
	}

	public void setIdProofName(String idProofName) {
		this.idProofName = idProofName;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getSubCaste() {
		return subCaste;
	}

	public void setSubCaste(String subCaste) {
		this.subCaste = subCaste;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRetireDate() {
		return retireDate;
	}

	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAddrIdType() {
		return addrIdType;
	}

	public void setAddrIdType(String addrIdType) {
		this.addrIdType = addrIdType;
	}

	public String getAddrIdNo() {
		return addrIdNo;
	}

	public void setAddrIdNo(String addrIdNo) {
		this.addrIdNo = addrIdNo;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeTelephone() {
		return officeTelephone;
	}

	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserSalutation() {
		return userSalutation;
	}

	public void setUserSalutation(String userSalutation) {
		this.userSalutation = userSalutation;
	}

	public List<Address2> getAddresList() {
		return addresList;
	}

	public void setAddresList(List<Address2> addresList) {
		this.addresList = addresList;
	}

	public void addAddress2(Address2 addresList) { /// added for child table 2 primary key setting
		addresList.setEmployeeMst(this);
		this.addresList.add(addresList);

	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpMName() {
		return empMName;
	}

	public void setEmpMName(String empMName) {
		this.empMName = empMName;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public Integer getPostBr() {
		return postBr;
	}

	public void setPostBr(Integer postBr) {
		this.postBr = postBr;
	}

	public Integer getDept() {
		return dept;
	}

	public void setDept(Integer dept) {
		this.dept = dept;
	}

	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getRepoMngr() {
		return repoMngr;
	}

	public void setRepoMngr(String repoMngr) {
		this.repoMngr = repoMngr;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
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
		EmployeeMst other = (EmployeeMst) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public EmployeeKey getEmployeeKey() {
		EmployeeKey employeeKey = new EmployeeKey();

		employeeKey.setEmpId(this.empId);
		employeeKey.setTenantId(this.tenantId);

		return employeeKey;
	}
}