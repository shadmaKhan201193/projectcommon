package ai.kiya.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserBranchMapVO  implements Serializable {

	private static final long serialVersionUID = -4351125006967645572L;

	private Integer branchCode ;
	
	private List<UserBranchRoleMapVO> userBranchRoleMaps = new ArrayList<UserBranchRoleMapVO>();

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public List<UserBranchRoleMapVO> getUserBranchRoleMaps() {
		return userBranchRoleMaps;
	}

	public void setUserBranchRoleMaps(List<UserBranchRoleMapVO> userBranchRoleMaps) {
		this.userBranchRoleMaps = userBranchRoleMaps;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchCode, userBranchRoleMaps);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBranchMapVO other = (UserBranchMapVO) obj;
		return Objects.equals(branchCode, other.branchCode) 
				&& Objects.equals(userBranchRoleMaps, other.userBranchRoleMaps);
	}

	@Override
	public String toString() {
		return "UserBranchMapVO [branchCode=" + branchCode + ", userBranchRoleMaps="
				+ userBranchRoleMaps + "]";
	}
	
	
}
