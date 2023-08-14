package ai.kiya.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserVO  implements Serializable {

	private static final long serialVersionUID = 6768265897891105424L;
	
	private String roleCode = "";
	
	private String userId = "";
	
	private Integer tenantId = 0;
	
	private String loginId = "";
	
	private List<AddressVO> userAddresses = new ArrayList<AddressVO>();
	
	private List<UserBranchMapVO> userBranchMaps = new ArrayList<UserBranchMapVO>();
	
	private String userCode = "VO";
	
	private String userSalutation = "";
	
	private String userFName = ""; // This can also be a System Name (ATM, etc.)
	
	private String userMName = "";
	
	private String userLName = "";
	
	private String userDisplayName = "";
	
	private String userBaseBranchCode = "";
	
	private String emailId = "";

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public List<AddressVO> getUserAddresses() {
		return userAddresses;
	}

	public void setUserAddresses(List<AddressVO> userAddresses) {
		this.userAddresses = userAddresses;
	}

	public List<UserBranchMapVO> getUserBranchMaps() {
		return userBranchMaps;
	}

	public void setUserBranchMaps(List<UserBranchMapVO> userBranchMaps) {
		this.userBranchMaps = userBranchMaps;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getUserBaseBranchCode() {
		return userBaseBranchCode;
	}

	public void setUserBaseBranchCode(String userBaseBranchCode) {
		this.userBaseBranchCode = userBaseBranchCode;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	
}
