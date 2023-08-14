package ai.kiya.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class BaseResponseVO {
	private String successMessage;
	private String errorMessage;
	public String getSuccessMessage() {
		return successMessage;
	}
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@Override
	public String toString() {
		return "BaseResponseVO [successMessage=" + successMessage + ", errorMessage=" + errorMessage + "]";
	}
	
	
}
