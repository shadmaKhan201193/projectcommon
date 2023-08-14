package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D002005Key;

@Table(name = "D002005")
@Entity
@IdClass(D002005Key.class)
public class UserRoleMst extends Base {
	private static final long serialVersionUID = 6693289730883743054L;

	@Column(length = 60, nullable = false)
	private String userRoleName = "";

	@Column(nullable = true)
	private Integer isActive;

	@Column(length = 40, nullable = true)
	private String authStatus = "";

	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Id
	@Column(length = 20, nullable = false)
	private String userRoleId = "";

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
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
		UserRoleMst other = (UserRoleMst) obj;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}

	public D002005Key getD002005Key() {
		D002005Key d002005Key = new D002005Key();
		d002005Key.setTenantId(this.tenantId);
		d002005Key.setUserRoleId(this.userRoleId);
		return d002005Key;
	}
}
