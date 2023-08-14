package ai.kiya.key;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D002046Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Column(length = 10, nullable = false)
	private String loginId = "";

	@Column(nullable = false)
	private Date suspendFromDate;

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

	public Date getSuspendFromDate() {
		return suspendFromDate;
	}

	public void setSuspendFromDate(Date suspendFromDate) {
		this.suspendFromDate = suspendFromDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginId, suspendFromDate, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D002046Key other = (D002046Key) obj;
		return Objects.equals(loginId, other.loginId) 
				&& Objects.equals(suspendFromDate, other.suspendFromDate)
				&& Objects.equals(tenantId, other.tenantId);
	}

}
