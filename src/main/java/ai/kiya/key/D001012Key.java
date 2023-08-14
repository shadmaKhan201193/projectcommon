package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D001012Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Column(nullable = false, length = 5)
	private String currencyIsoCode = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(currencyIsoCode, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D001012Key other = (D001012Key) obj;
		return Objects.equals(currencyIsoCode, other.currencyIsoCode) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
