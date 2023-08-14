package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class D002005Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Column(length = 20, nullable = false)
	private String userRoleId = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tenantId, userRoleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D002005Key other = (D002005Key) obj;
		return Objects.equals(tenantId, other.tenantId) 
				&& Objects.equals(userRoleId, other.userRoleId);
	}

}
