package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D009509Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Column(nullable = false, length = 60)
	private String portletCode = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getPortletCode() {
		return portletCode;
	}

	public void setPortletCode(String portletCode) {
		this.portletCode = portletCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(portletCode, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009509Key other = (D009509Key) obj;
		return Objects.equals(portletCode, other.portletCode) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
