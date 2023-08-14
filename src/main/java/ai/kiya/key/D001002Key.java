package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D001002Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 10, nullable = true)
	private String languageCode = "";

	@Column(length = 30, nullable = true)
	private String lookupValueCode = ""; // This value will be fixed across all

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(length = 20, nullable = false)
	private String lookupCode = "";

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLookupValueCode() {
		return lookupValueCode;
	}

	public void setLookupValueCode(String lookupValueCode) {
		this.lookupValueCode = lookupValueCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getLookupCode() {
		return lookupCode;
	}

	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(languageCode, lookupCode, lookupValueCode, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D001002Key other = (D001002Key) obj;
		return Objects.equals(languageCode, other.languageCode) && Objects.equals(lookupCode, other.lookupCode)
				&& Objects.equals(lookupValueCode, other.lookupValueCode) && Objects.equals(tenantId, other.tenantId);
	}

}
