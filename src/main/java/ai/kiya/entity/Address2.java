package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base2;
import ai.kiya.key.Address2Key;

@Entity
@IdClass(Address2Key.class)
public class Address2 extends Base2 {
	
//	@EmbeddedId
//	private Address2Key add2Key = new Address2Key();
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tenantId",referencedColumnName = "tenantId", insertable = false, updatable = false),
		
		@JoinColumn(name = "empId",referencedColumnName = "empId", insertable = false, updatable = false),
	})
	@LazyCollection(LazyCollectionOption.FALSE)	
	@JsonIgnore
	private EmployeeMst employeeMst;

	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 40, nullable = false)
	private String empId = "";
//
	
	//
	
	@Column(length = 350, nullable = true, updatable = true)
	private String address1 = "";

	@Column(length = 350, nullable = true, updatable = true)
	private String address2 = "";

	@Column(length = 350, nullable = true, updatable = true)
	private String address3 = "";

	@Column(length = 40, nullable = true)
	private String pinCode = "";

	@Column(length = 40, nullable = true, updatable = true)
	private String addressType = ""; // must come from lookup values
	
	@Column(length = 40, nullable = true)
	private String villageCode = "";
	
	@Column(length = 40, nullable = true)
	private String leadDistrictCode = "";
	
	@Column(length = 40, nullable = true)
	private String serviceAreaCode = "";
	
	@Column(length = 40, nullable = true)
	private String mandalCode = "";
	
	@Column(length = 40, nullable = true)
	private String blockCode = "";
	
	@Column(length = 40, nullable = true)
	private String postOffice = "";
	
	@Column(length = 40, nullable = true)
	private String districtCode = "";
	
	@Column(length = 40, nullable = true)
	private String stateCode = "";
	
	@Column(length = 40, nullable = true)
	private String countryCode = "";
	
	@Column(length = 40, nullable = true)
	private String municipalityCode = "";

	@Column(length = 40, nullable = true)
	private String hubliCode = "";

	// Following attributes are not to be used, Developers to check if they are used then it should be replaced
	@Column(nullable = true, updatable = true)
	private Long villageId = 0L;

	@Column(nullable = true, updatable = true)
	private Long municipalityId = 0L;

	@Column(nullable = true, updatable = true)
	private Long cityId = 0L;

	@Column(nullable = true, updatable = true)
	private Long stateId = 0L;

	@Column(nullable = true, updatable = true)
	private Long countryId = 0L;

	
	
	

	public EmployeeMst getEmployeeMst() {
		return employeeMst;
	}

	public void setEmployeeMst(EmployeeMst employeeMst) {
		this.employeeMst = employeeMst;
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

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getLeadDistrictCode() {
		return leadDistrictCode;
	}

	public void setLeadDistrictCode(String leadDistrictCode) {
		this.leadDistrictCode = leadDistrictCode;
	}

	public String getServiceAreaCode() {
		return serviceAreaCode;
	}

	public void setServiceAreaCode(String serviceAreaCode) {
		this.serviceAreaCode = serviceAreaCode;
	}

	public String getMandalCode() {
		return mandalCode;
	}

	public void setMandalCode(String mandalCode) {
		this.mandalCode = mandalCode;
	}

	public String getBlockCode() {
		return blockCode;
	}

	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getHubliCode() {
		return hubliCode;
	}

	public void setHubliCode(String hubliCode) {
		this.hubliCode = hubliCode;
	}

	public Long getVillageId() {
		return villageId;
	}

	public void setVillageId(Long villageId) {
		this.villageId = villageId;
	}

	public Long getMunicipalityId() {
		return municipalityId;
	}

	public void setMunicipalityId(Long municipalityId) {
		this.municipalityId = municipalityId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getPostOffice() {
		return postOffice;
	}
	
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}

	public String getMunicipalityCode() {
		return municipalityCode;
	}

	public void setMunicipalityCode(String municipalityCode) {
		this.municipalityCode = municipalityCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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
		Address2 other = (Address2) obj;
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
	
	
}

