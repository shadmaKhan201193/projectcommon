package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D009500Key;

@Table(name = "D009500")
@Entity
@IdClass(D009500Key.class)
public class CityMst2 extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 10, nullable = false)
	private String languageCode = "";

	@Id
	@Column(length = 4, nullable = false)
	private String countryCode = "";

	@Id
	@Column(length = 4, nullable = false)
	private String stateCode = "";

	@Id
	@Column(length = 4, nullable = false)
	private String districtCode = "";

	@Column(length = 100, nullable = true)
	private String districtName = "";

	@Column(length = 40, nullable = true)
	private String branchCode = "";

	@Transient
	private String countryName = "";

	@Transient
	private String stateName = "";

	@Column(nullable = true)
	private Date updatedOn;

	@Column(length = 3, nullable = true)
	private String numCityCode = "";

	public String getDistrictName() {
		if (null != districtName) {
		} else {
			districtName = super.initString;
		}
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getBranchCode() {
		if (null != branchCode) {
		} else {
			branchCode = super.initString;
		}
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getUpdatedOn() {
		if (null != updatedOn) {
		} else {
			updatedOn = super.initDate();
		}
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

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

	public String getStateName() {
		if (null != stateName) {
		} else {
			stateName = super.initString;
		}
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getNumCityCode() {
		if (null != numCityCode) {
		} else {
			numCityCode = super.initString;
		}
		return numCityCode;
	}

	public void setNumCityCode(String numCityCode) {
		this.numCityCode = numCityCode;
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

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((districtCode == null) ? 0 : districtCode.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
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
		CityMst2 other = (CityMst2) obj;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (districtCode == null) {
			if (other.districtCode != null)
				return false;
		} else if (!districtCode.equals(other.districtCode))
			return false;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D009500Key getD009500Key() {
		D009500Key d009500Key = new D009500Key();
		d009500Key.setCountryCode(this.countryCode);
		d009500Key.setDistrictCode(this.districtCode);
		d009500Key.setLanguageCode(this.languageCode);
		d009500Key.setStateCode(this.stateCode);
		d009500Key.setTenantId(this.tenantId);
		return d009500Key;
	}
}
