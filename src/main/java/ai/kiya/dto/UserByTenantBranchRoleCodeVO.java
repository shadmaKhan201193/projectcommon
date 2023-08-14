package ai.kiya.dto;

import java.io.Serializable;

public class UserByTenantBranchRoleCodeVO implements Serializable{

	private static final long serialVersionUID = 7764963198052449777L;

	private String roleCode;
	
	private Integer tenantId;
	
	private String userId;
	
	private String loginId;
	
	private String userSalutation;
	
	private String userFName;
	
	private String userMName;
    
	private String userLName;
	
	private String userDisplayName;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserSalutation() {
		return userSalutation;
	}

	public void setUserSalutation(String userSalutation) {
		this.userSalutation = userSalutation;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserMName() {
		return userMName;
	}

	public void setUserMName(String userMName) {
		this.userMName = userMName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}
}
