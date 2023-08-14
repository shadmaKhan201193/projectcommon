package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.RoleKey;

@Table(name = "D002062")
@Entity
@IdClass(RoleKey.class)
public class RoleMst extends Base {

//	@EmbeddedId
//	private RoleKey d002062Key = new RoleKey();

	@Column(length = 100, nullable = true)
	private String userRoleName = "";

	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(length = 40, nullable = true)
	private String userRoleId = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
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
		RoleMst other = (RoleMst) obj;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public RoleKey getRoleKey() {
		RoleKey roleKey = new RoleKey();
		roleKey.setTenantId(this.tenantId);
		roleKey.setUserRoleId(this.userRoleId);
		return roleKey;
	}
}
