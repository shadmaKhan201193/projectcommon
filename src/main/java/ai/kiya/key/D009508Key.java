package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D009508Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(nullable = true, length = 20)
	private String loginId = "";

	@Column(nullable = true, length = 20)
	private String dashboardCode = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getDashboardCode() {
		return dashboardCode;
	}

	public void setDashboardCode(String dashboardCode) {
		this.dashboardCode = dashboardCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dashboardCode, loginId, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009508Key other = (D009508Key) obj;
		return Objects.equals(dashboardCode, other.dashboardCode) 
				&& Objects.equals(loginId, other.loginId)
				&& Objects.equals(tenantId, other.tenantId);
	}
}
