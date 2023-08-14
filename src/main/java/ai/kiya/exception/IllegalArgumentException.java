package ai.kiya.exception;

public class IllegalArgumentException extends RuntimeException {
	private String masterName;

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public IllegalArgumentException(String masterName) {
		super(String.format("%s"));
		this.masterName = masterName;
	}

	public IllegalArgumentException() {
		super();
	}

}
