package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class D009505Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(length = 10, nullable = false)
	private String languageCode = "";

	@Column(length = 4, nullable = false)
	private String countryCode = "";

	@Column(length = 4, nullable = false)
	private String stateCode = "";

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
		return Objects.hash(countryCode, languageCode, stateCode, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009505Key other = (D009505Key) obj;
		return Objects.equals(countryCode, other.countryCode) 
				&& Objects.equals(languageCode, other.languageCode)
				&& Objects.equals(stateCode, other.stateCode) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
