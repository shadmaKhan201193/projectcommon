package ai.kiya.entity;

import java.util.Date;

public class AuthRequestVO {
	
	public String authChecker1;
	public String authChecker2;
	public String authChecker3;
	public Date authCheckerDate1;
	public Date authCheckerDate2;
	public Date authCheckerDate3;
	public String master;
	public Integer tenantId;
	
	

	public String authStatus = "";



	public String getAuthChecker1() {
		return authChecker1;
	}



	public void setAuthChecker1(String authChecker1) {
		this.authChecker1 = authChecker1;
	}



	public String getAuthChecker2() {
		return authChecker2;
	}



	public void setAuthChecker2(String authChecker2) {
		this.authChecker2 = authChecker2;
	}



	public String getAuthChecker3() {
		return authChecker3;
	}



	public void setAuthChecker3(String authChecker3) {
		this.authChecker3 = authChecker3;
	}



	public Date getAuthCheckerDate1() {
		return authCheckerDate1;
	}



	public void setAuthCheckerDate1(Date authCheckerDate1) {
		this.authCheckerDate1 = authCheckerDate1;
	}



	public Date getAuthCheckerDate2() {
		return authCheckerDate2;
	}



	public void setAuthCheckerDate2(Date authCheckerDate2) {
		this.authCheckerDate2 = authCheckerDate2;
	}



	public Date getAuthCheckerDate3() {
		return authCheckerDate3;
	}



	public void setAuthCheckerDate3(Date authCheckerDate3) {
		this.authCheckerDate3 = authCheckerDate3;
	}



	public String getMaster() {
		return master;
	}



	public void setMaster(String master) {
		this.master = master;
	}



	public Integer getTenantId() {
		return tenantId;
	}



	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}



	public String getAuthStatus() {
		return authStatus;
	}



	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	
	
	
	

}
