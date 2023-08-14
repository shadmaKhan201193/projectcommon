package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import ai.kiya.base.Base;

@Table(name = "TenantGrpMst")
@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "tenantGrpCode" }))
public class TenantGrpMst extends Base {

	@Id
	@Column(length = 20, nullable = false)
	private Integer grpTenantId ;


	@Column(length=150,nullable = true)
	private String grpTenantName="";
	

	@Column(length=60,nullable = true)
	private String address1="";
	
	
	@Column(length=60,nullable = true)
	private String address2="";
	

	@Column(length=60,nullable = true)
	private String address3="";
	
	
	@Column(length=4,nullable = true)
	private String country="";

	
	@Column(length=4,nullable = true)
	private String state = "";


	@Column(length=4,nullable = true)
	private String city = "";
	

	@Column(length=20, nullable = true)
	private String pinCode = "";

	
	@Column(length=50,nullable = true)
	private String timeZone = ""; // from lookup

	
	@Column(length=20,nullable = true)
	private String localDateFormat = ""; 

	
	@Column(length=20,nullable = true)
	private String localDateTimeFormat = ""; // drop down from DB

	
	@Column(nullable = true)
	private Date tenantRegistrationDate;

	
	@Column(nullable = true)
	private Date tenantDeregistrationDate;


	@Column(length=250,nullable = true)
	private String tenantDeregistrationReason = "";
	
	
	@Column(length=4,nullable = true)
	private String tenantStatus = "";


	




	public Integer getGrpTenantId() {
		return grpTenantId;
	}


	public void setGrpTenantId(Integer grpTenantId) {
		this.grpTenantId = grpTenantId;
	}


	public String getGrpTenantName() {
		return grpTenantName;
	}


	public void setGrpTenantName(String grpTenantName) {
		this.grpTenantName = grpTenantName;
	}


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


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public String getTimeZone() {
		return timeZone;
	}


	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	public String getLocalDateFormat() {
		return localDateFormat;
	}


	public void setLocalDateFormat(String localDateFormat) {
		this.localDateFormat = localDateFormat;
	}


	public String getLocalDateTimeFormat() {
		return localDateTimeFormat;
	}


	public void setLocalDateTimeFormat(String localDateTimeFormat) {
		this.localDateTimeFormat = localDateTimeFormat;
	}


	public Date getTenantRegistrationDate() {
		return tenantRegistrationDate;
	}


	public void setTenantRegistrationDate(Date tenantRegistrationDate) {
		this.tenantRegistrationDate = tenantRegistrationDate;
	}


	public Date getTenantDeregistrationDate() {
		return tenantDeregistrationDate;
	}


	public void setTenantDeregistrationDate(Date tenantDeregistrationDate) {
		this.tenantDeregistrationDate = tenantDeregistrationDate;
	}


	public String getTenantDeregistrationReason() {
		return tenantDeregistrationReason;
	}


	public void setTenantDeregistrationReason(String tenantDeregistrationReason) {
		this.tenantDeregistrationReason = tenantDeregistrationReason;
	}


	public String getTenantStatus() {
		return tenantStatus;
	}


	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}

	
	

	

}
