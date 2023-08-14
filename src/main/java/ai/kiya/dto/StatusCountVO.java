package ai.kiya.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class StatusCountVO {
	@JsonProperty(value = "AuthCount")
	private String authCount;
	
	@JsonProperty(value = "PendingCount")
	private String pendingCount;
	
	@JsonProperty(value = "RejectedCount")
	private String rejectedCount;
	
	@JsonProperty(value = "ClosedCount")
	private String closedCount;

	public String getAuthCount() {
		return authCount;
	}

	public void setAuthCount(String authCount) {
		this.authCount = authCount;
	}

	public String getPendingCount() {
		return pendingCount;
	}

	public void setPendingCount(String pendingCount) {
		this.pendingCount = pendingCount;
	}

	public String getRejectedCount() {
		return rejectedCount;
	}

	public void setRejectedCount(String rejectedCount) {
		this.rejectedCount = rejectedCount;
	}

	public String getClosedCount() {
		return closedCount;
	}

	public void setClosedCount(String closedCount) {
		this.closedCount = closedCount;
	}
	
	
	
}
