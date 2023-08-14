package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D009504Key;

@Table(name = "D009504")
@Entity
@IdClass(D009504Key.class)
public class CountryMst2 extends Base {

	private static final long serialVersionUID = -1L;
/////
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 10, nullable = false)
	private String languageCode = "";

	@Id
	@Column(length = 4, nullable = false)
	private String countryCode = "";
	////

	@Column(length = 20, nullable = true)
	private String countryAbbrevation = "";

	@Column(length = 60, nullable = true)
	private String countryName = "";

	@Column(length = 15, nullable = true)
	private String isdCode = "";

	@Column(length = 30, nullable = true)
	private String zone = "";

	@Column(length = 30, nullable = true)
	private String region = "";

	@Column(nullable = true, length = 1)
	private Integer gracePrdYN;

	@Column(length = 40, nullable = true)
	private Integer gracePrd = 0;

	@Column(nullable = true, length = 10)
	private Integer numCountyCd;

	@Column(length = 20, nullable = true)
	private String countryType = "";

	@Column(nullable = true, length = 1)
	private Integer ecgcCoverYN;

	@Column(nullable = true, length = 1)
	private Integer restrictedYN;

	@Column(nullable = true, length = 1)
	private Integer isAplhanumericYN;

	@Column(nullable = true, length = 2)
	private Integer pinLength;

	public String getCountryName() {
		if (null != countryName) {
		} else {
			countryName = super.initString;
		}
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsdCode() {
		if (null != isdCode) {
		} else {
			isdCode = super.initString;
		}
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public String getZone() {
		if (null != zone) {
		} else {
			zone = super.initString;
		}
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getRegion() {
		if (null != region) {
		} else {
			region = super.initString;
		}
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getGracePrd() {
		if (null != gracePrd) {
		} else {
			gracePrd = super.initInteger;
		}
		return gracePrd;
	}

	public void setGracePrd(Integer gracePrd) {
		this.gracePrd = gracePrd;
	}

	public String getCountryType() {
		if (null != countryType) {
		} else {
			countryType = super.initString;
		}
		return countryType;
	}

	public void setCountryType(String countryType) {
		this.countryType = countryType;
	}

	public String getCountryAbbrevation() {
		if (null != countryAbbrevation) {
		} else {
			countryAbbrevation = super.initString;
		}
		return countryAbbrevation;
	}

	public void setCountryAbbrevation(String countryAbbrevation) {
		this.countryAbbrevation = countryAbbrevation;
	}

	public Integer getNumCountyCd() {
		if (null != numCountyCd) {
		} else {
			numCountyCd = super.initInteger;
		}
		return numCountyCd;
	}

	public void setNumCountyCd(Integer numCountyCd) {
		this.numCountyCd = numCountyCd;
	}

	public Integer getGracePrdYN() {
		if (null != gracePrdYN) {
		} else {
			gracePrdYN = super.initInteger;
		}
		return gracePrdYN;
	}

	public void setGracePrdYN(Integer gracePrdYN) {
		this.gracePrdYN = gracePrdYN;
	}

	public Integer getEcgcCoverYN() {
		if (null != ecgcCoverYN) {
		} else {
			ecgcCoverYN = super.initInteger;
		}
		return ecgcCoverYN;
	}

	public void setEcgcCoverYN(Integer ecgcCoverYN) {
		this.ecgcCoverYN = ecgcCoverYN;
	}

	public Integer getRestrictedYN() {
		if (null != restrictedYN) {
		} else {
			restrictedYN = super.initInteger;
		}
		return restrictedYN;
	}

	public void setRestrictedYN(Integer restrictedYN) {
		this.restrictedYN = restrictedYN;
	}

	public Integer getIsAplhanumericYN() {
		if (null != isAplhanumericYN) {
		} else {
			isAplhanumericYN = super.initInteger;
		}
		return isAplhanumericYN;
	}

	public void setIsAplhanumericYN(Integer isAplhanumericYN) {
		this.isAplhanumericYN = isAplhanumericYN;
	}

	public Integer getPinLength() {
		if (null != pinLength) {
		} else {
			pinLength = super.initInteger;
		}
		return pinLength;
	}

	public void setPinLength(Integer pinLength) {
		this.pinLength = pinLength;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
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
		CountryMst2 other = (CountryMst2) obj;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		return true;
	}

	public D009504Key getD009504Key() {
		D009504Key d009504Key = new D009504Key();
		d009504Key.setCountryCode(this.countryCode);
		d009504Key.setLanguageCode(this.languageCode);
		d009504Key.setTenantId(this.tenantId);
		return d009504Key;
	}

}
