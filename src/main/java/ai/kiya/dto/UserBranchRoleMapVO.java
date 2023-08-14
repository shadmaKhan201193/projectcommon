package ai.kiya.dto;

import java.io.Serializable;

public class UserBranchRoleMapVO  implements Serializable {

	private static final long serialVersionUID = -9169121356386337815L;

	private String roleCode = "";

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public UserBranchRoleMapVO() {
		super();
	}

	public UserBranchRoleMapVO(String roleCode) {
		super();
		this.roleCode = roleCode;
	}
}
