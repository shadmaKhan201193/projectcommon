package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Version;

import ai.kiya.base.Base;

@Embeddable
public class Address {

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
}

