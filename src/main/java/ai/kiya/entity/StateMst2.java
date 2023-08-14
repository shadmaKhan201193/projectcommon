package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D009505Key;

@Table(name = "D009505")
@Entity
@IdClass(D009505Key.class)
public class StateMst2 extends Base {

	private static final long serialVersionUID = -1L;

	@Column(length = 40, nullable = true)
	private String stateName = "";

	@Transient
	private String countryName = "";

	@Column(nullable = true, length = 10)
	private Integer numstateCode;

	//////
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
	///

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

	public Integer getNumstateCode() {
		return numstateCode;
	}

	public void setNumstateCode(Integer numstateCode) {
		this.numstateCode = numstateCode;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
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
		StateMst2 other = (StateMst2) obj;
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
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		return true;
	}

	public D009505Key getD009505Key() {
		D009505Key d009505Key = new D009505Key();
		d009505Key.setCountryCode(this.countryCode);
		d009505Key.setLanguageCode(this.languageCode);
		d009505Key.setStateCode(this.stateCode);
		d009505Key.setTenantId(this.tenantId);
		return d009505Key;
	}

}
