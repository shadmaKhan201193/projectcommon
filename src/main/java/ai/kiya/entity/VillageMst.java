package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import ai.kiya.base.Base;
import ai.kiya.key.D500025Key;

@Table(name = "D500025")
@Entity
@IdClass(D500025Key.class)
public class VillageMst extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D500025Key D500025Key = new D500025Key();

	@Column(nullable = true, length = 35)
	private String villageDesc;
	////

	@Id
	@Column(nullable = false, length = 6)
	private String villageCode;

	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Id
	@Column(nullable = false, length = 6, name = "language")
	@JsonProperty(value = "languageCode")
	private String language;

	@Id
	@Column(nullable = false, length = 4)
	private String country;

	@Id
	@Column(nullable = false, length = 4)
	private String state;

	@Id
	@Column(nullable = false, length = 4)
	private String city;

	@Id
	@Column(nullable = false, length = 6)
	private String area;

	@Id
	@Column(nullable = false, length = 6)
	private String municipalityBlock;

	public String getVillageDesc() {
		return villageDesc;
	}

	public void setVillageDesc(String villageDesc) {
		this.villageDesc = villageDesc;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	///

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((municipalityBlock == null) ? 0 : municipalityBlock.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((villageCode == null) ? 0 : villageCode.hashCode());
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

		VillageMst other = (VillageMst) obj;
		if (language == null) {

			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;

		if (country == null) {

			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;

		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (municipalityBlock == null) {
			if (other.municipalityBlock != null)
				return false;
		} else if (!municipalityBlock.equals(other.municipalityBlock))
			return false;

		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (villageCode == null) {
			if (other.villageCode != null)
				return false;
		} else if (!villageCode.equals(other.villageCode))
			return false;
		return true;
	}

	public D500025Key getKey() {
		D500025Key key = new D500025Key();
		key.setArea(this.getArea());
		key.setCity(this.getCity());
		key.setCountry(this.getCountry());
		key.setLanguage(this.getLanguage());
		key.setMunicipalityBlock(this.getMunicipalityBlock());
		key.setState(this.getState());
		key.setTenantId(this.getTenantId());
		key.setVillageCode(this.getVillageCode());

		return key;

	}

}
