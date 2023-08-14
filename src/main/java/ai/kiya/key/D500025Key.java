package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

//@Embeddable
public class D500025Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Column(nullable = false, length = 6, name = "language")
	@JsonProperty(value = "languageCode")
	private String language;

	@Column(nullable = false, length = 4)
	private String country;

	@Column(nullable = false, length = 4)
	private String state;

	@Column(nullable = false, length = 4)
	private String city;

	@Column(nullable = false, length = 6)
	private String area;

	@Column(nullable = false, length = 6)
	private String municipalityBlock;

	@Column(nullable = false, length = 6)
	private String villageCode;

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

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, city, country, language, municipalityBlock, state, tenantId, villageCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D500025Key other = (D500025Key) obj;
		return Objects.equals(area, other.area) && Objects.equals(city, other.city)
				&& Objects.equals(country, other.country) && Objects.equals(language, other.language)
				&& Objects.equals(municipalityBlock, other.municipalityBlock) && Objects.equals(state, other.state)
				&& Objects.equals(tenantId, other.tenantId) && Objects.equals(villageCode, other.villageCode);
	}
}