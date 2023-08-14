package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D009508Key;

@Table(name = "D009508")
@Entity
@IdClass(D009508Key.class)
public class DashboardMst extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D009508Key d009508Key = new D009508Key();

	///
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Id
	@Column(nullable = true, length = 20)
	private String loginId = "";

	@Id
	@Column(nullable = true, length = 20)
	private String dashboardCode = "";
	//

	@Column(nullable = true, length = 100)
	private String dashboardName = "";

	@Column(nullable = true, length = 20)
	private String roleOrLogin = "";

	@Column(length = 1, nullable = true)
	private Integer isDefault;

	public String getRoleOrLogin() {
		if (null != roleOrLogin) {
		} else {
			roleOrLogin = super.initString;
		}
		return roleOrLogin;
	}

	public void setRoleOrLogin(String roleOrLogin) {
		this.roleOrLogin = roleOrLogin;
	}

	public String getDashboardName() {
		if (null != dashboardName) {
		} else {
			dashboardName = super.initString;
		}
		return dashboardName;
	}

	public void setDashboardName(String dashboardName) {
		this.dashboardName = dashboardName;
	}

	public Integer getIsDefault() {
		if (null != isDefault) {
		} else {
			isDefault = super.initInteger;
		}
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dashboardCode == null) ? 0 : dashboardCode.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
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
		DashboardMst other = (DashboardMst) obj;
		if (dashboardCode == null) {
			if (other.dashboardCode != null)
				return false;
		} else if (!dashboardCode.equals(other.dashboardCode))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D009508Key getD009508Key() {
		D009508Key d009508Key = new D009508Key();
		d009508Key.setDashboardCode(this.dashboardCode);
		d009508Key.setLoginId(this.loginId);
		d009508Key.setTenantId(this.tenantId);
		return d009508Key;
	}

}
