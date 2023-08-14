package ai.kiya.dto;

import java.io.Serializable;
import java.util.Objects;

public class AddressVO  implements Serializable{

	private static final long serialVersionUID = -3232719538162126735L;
	
	private String address1 = "";
	
	private String address2 = "";
	
	private String address3 = "";
	
	private String pinCode = "";
	
	private String addressType = "";

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public AddressVO(String address1, String address2, String address3, String pinCode, String addressType) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.pinCode = pinCode;
		this.addressType = addressType;
	}

	public AddressVO() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(address1, address2, address3, addressType, pinCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressVO other = (AddressVO) obj;
		return Objects.equals(address1, other.address1) && Objects.equals(address2, other.address2)
				&& Objects.equals(address3, other.address3) && Objects.equals(addressType, other.addressType)
				&& Objects.equals(pinCode, other.pinCode);
	}

	@Override
	public String toString() {
		return "AddressVO [address1=" + address1 + ", address2=" + address2 + ", address3=" + address3 + ", pinCode="
				+ pinCode + ", addressType=" + addressType + "]";
	}

	
}
