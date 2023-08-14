package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.activemq.filter.function.regexMatchFunction;

import ai.kiya.base.Base2;
import ai.kiya.key.D001008Key;
import ai.kiya.omni.OmniConstants;

@Entity
@Table(name = "D001008")
@IdClass(D001008Key.class)
public class TenantMst extends Base2 {

	private static final long serialVersionUID = 1701454124187153606L;

//	@EmbeddedId
//	private D001008Key d001008Key = new D001008Key();

	@Id
	@Column(nullable = false, length = 6)
	protected Integer tenantId = 0;

	@Column(nullable = false, length = 150)
	private String institutionName = "";

	@Column(nullable = false, length = 60)
	private String address1 = "";

	@Column(nullable = true, length = 60)
	private String address2 = "";

	@Column(nullable = true, length = 60)
	private String address3 = "";

	@Column(nullable = false, length = 4)
	private String country = "";

	@Column(nullable = false, length = 4)
	private String state = "";

	@Column(nullable = false, length = 4)
	private String city = "";

	@Column(nullable = false, length = 100)
	private String timeZone = ""; // from lookup

	@Column(nullable = false, length = 60)
	private String localDateFormat = ""; // from Lookup - Internal / External

	@Column(nullable = false, length = 20)
	private String localDateTimeFormat = ""; // drop down from DB

	@Column(nullable = true)
	private Date tenantRegistrationDate;

	@Column(nullable = true)
	private Date tenantDeregistrationDate;

	@Column(nullable = true, length = 250)
	private String tenantDeregistrationReason = "";

	@Column(nullable = false, length = 4)
	private String tenantStatus = "";

	@Lob
	@Column(nullable = true)
	private byte[] tenantLogo;

	@Lob
	@Column(nullable = true)
	private byte[] tenantIcon;

	@Column(nullable = true, length = 50)
	private String tenantGroupId = "";

	@Column(nullable = true, length = 50)
	private String tenantTheme = "";

	@Column(name = "passwordLoginEnable")
	private Boolean isPasswordLoginEnable;

	@Column(name = "twoFALoginEnable")
	private Boolean isTwoFALoginEnable;

	@Column(name = "captchaLoginEnable")
	private Boolean isCaptchaLoginEnable;

	/*
	 * @OneToMany(mappedBy="d001008",cascade= CascadeType.ALL)
	 * 
	 * @LazyCollection(LazyCollectionOption.FALSE) private Collection<ModuleMst>
	 * moduleMst = new ArrayList<ModuleMst>();
	 */
	@Column(nullable = true, length = 250)
	private String modules = "";

	@Column(nullable = true, length = 1)
	private Integer isActive = OmniConstants.ACTIVE;

	@Column(length = 4, nullable = true)
	private Integer isSSO;

	@Column(length = 4, nullable = true)
	private Integer isOTP;

	@Column(length = 4, nullable = true)
	private Integer isTOTP;

	@Column(length = 4, nullable = true)
	private Integer isBioMetric;

	@Column(nullable = true, length = 1)
	private String authStatus;

	@Column(nullable = true, length = 50)
	private String parent = "";

	@Column(nullable = true, length = 50)
	private String subsidiary = "";

	@Column(length = 20, nullable = true)
	private String otpType = "";

	@Column(length = 20, nullable = true)
	private String authType = "";

	@Column(length = 20, nullable = true)
	private String pinCode = "";

	public String getPinCode() {
		if (null != pinCode) {
		} else {
			pinCode = super.initString;
		}
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAuthType() {
		if (null != authType && !authType.equalsIgnoreCase("")) {
		} else {
			authType = super.initString;
		}
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getOtpType() {
		if (null != otpType) {
		} else {
			otpType = super.initString;
		}
		return otpType;
	}

	public void setOtpType(String otpType) {
		this.otpType = otpType;
	}

	/*
	 * public String getModules() { if (null != modules) { } else { modules =
	 * super.initString; } return modules; }
	 * 
	 * public void setModules(String modules) { this.modules = modules; }
	 */

	public byte[] getTenantLogo() {
		return tenantLogo;
	}

	public void setTenantLogo(byte[] tenantLogo) {
		this.tenantLogo = tenantLogo;
	}

	public byte[] getTenantIcon() {
		return tenantIcon;
	}

	public void setTenantIcon(byte[] tenantIcon) {
		this.tenantIcon = tenantIcon;
	}

	public String getInstitutionName() {
		if (null != institutionName) {
		} else {
			institutionName = super.initString;
		}
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getAddress1() {
		if (null != address1) {
		} else {
			address1 = super.initString;
		}
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		if (null != address2) {
		} else {
			address2 = super.initString;
		}
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		if (null != address3) {
		} else {
			address3 = super.initString;
		}
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCountry() {
		if (null != country) {
		} else {
			country = super.initString;
		}
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		if (null != state) {
		} else {
			state = super.initString;
		}
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		if (null != city) {
		} else {
			city = super.initString;
		}
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTimeZone() {
		if (null != timeZone) {
		} else {
			timeZone = super.initString;
		}
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getLocalDateFormat() {
		if (null != localDateFormat) {
		} else {
			localDateFormat = super.initString;
		}
		return localDateFormat;
	}

	public void setLocalDateFormat(String localDateFormat) {
		this.localDateFormat = localDateFormat;
	}

	public String getLocalDateTimeFormat() {
		if (null != localDateTimeFormat) {
		} else {
			localDateTimeFormat = super.initString;
		}
		return localDateTimeFormat;
	}

	public void setLocalDateTimeFormat(String localDateTimeFormat) {
		this.localDateTimeFormat = localDateTimeFormat;
	}

	public Date getTenantRegistrationDate() {
		if (null != tenantRegistrationDate) {
		} else {
			tenantRegistrationDate = super.initDate();
		}
		return tenantRegistrationDate;
	}

	public void setTenantRegistrationDate(Date tenantRegistrationDate) {
		this.tenantRegistrationDate = tenantRegistrationDate;
	}

	public Date getTenantDeregistrationDate() {
		if (null != tenantDeregistrationDate) {
		} else {
			tenantDeregistrationDate = super.initDate();
		}
		return tenantDeregistrationDate;
	}

	public void setTenantDeregistrationDate(Date tenantDeregistrationDate) {
		this.tenantDeregistrationDate = tenantDeregistrationDate;
	}

	public String getTenantDeregistrationReason() {
		if (null != tenantDeregistrationReason) {
		} else {
			tenantDeregistrationReason = super.initString;
		}
		return tenantDeregistrationReason;
	}

	public void setTenantDeregistrationReason(String tenantDeregistrationReason) {
		this.tenantDeregistrationReason = tenantDeregistrationReason;
	}

	public String getTenantGroupId() {
		if (null != tenantGroupId) {
		} else {
			tenantGroupId = super.initString;
		}
		return tenantGroupId;
	}

	public void setTenantGroupId(String tenantGroupId) {
		this.tenantGroupId = tenantGroupId;
	}

	public String getTenantTheme() {
		if (null != tenantTheme) {
		} else {
			tenantTheme = super.initString;
		}
		return tenantTheme;
	}

	public void setTenantTheme(String tenantTheme) {
		this.tenantTheme = tenantTheme;
	}

	public String getTenantStatus() {
		if (null != tenantStatus) {
		} else {
			tenantStatus = super.initString;
		}
		return tenantStatus;
	}

	public void setTenantStatus(String tenantStatus) {
		this.tenantStatus = tenantStatus;
	}
	/*
	 * public Collection<ModuleMst> getModuleMst() { return moduleMst; }
	 * 
	 * public void setModuleMst(Collection<ModuleMst> moduleMst) { this.moduleMst =
	 * moduleMst; }
	 */

	public String getParent() {
		if (null != parent) {
		} else {
			parent = super.initString;
		}
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getSubsidiary() {
		if (null != subsidiary) {
		} else {
			subsidiary = super.initString;
		}
		return subsidiary;
	}

	public void setSubsidiary(String subsidiary) {
		this.subsidiary = subsidiary;
	}

//	public D001008Key getD001008Key() {
//		return d001008Key;
//	}
//
//	public void setD001008Key(D001008Key d001008Key) {
//		this.d001008Key = d001008Key;
//	}

	public Integer getIsActive() {
		if (null != isActive) {
		} else {
			isActive = super.initInteger;
		}
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getIsSSO() {
		if (null != isSSO) {
		} else {
			isSSO = super.initInteger;
		}
		return isSSO;
	}

	public void setIsSSO(Integer isSSO) {
		this.isSSO = isSSO;
	}

	public String getAuthStatus() {
		if (null != authStatus) {
		} else {
			authStatus = super.initString;
		}
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public String getModules() {
		if (null != modules) {
		} else {
			modules = super.initString;
		}
		return modules;
	}

	public void setModules(String modules) {
		this.modules = modules;
	}

	public Integer getIsOTP() {
		if (null != isOTP) {
		} else {
			isOTP = super.initInteger;
		}
		return isOTP;
	}

	public void setIsOTP(Integer isOTP) {
		this.isOTP = isOTP;
	}

	public Integer getIsTOTP() {
		if (null != isTOTP) {
		} else {
			isTOTP = super.initInteger;
		}
		return isTOTP;
	}

	public void setIsTOTP(Integer isTOTP) {
		this.isTOTP = isTOTP;
	}

	public Integer getIsBioMetric() {
		if (null != isBioMetric) {
		} else {
			isBioMetric = super.initInteger;
		}
		return isBioMetric;
	}

	public void setIsBioMetric(Integer isBioMetric) {
		this.isBioMetric = isBioMetric;
	}

	public Boolean getIsPasswordLoginEnable() {
		return isPasswordLoginEnable;
	}

	public void setIsPasswordLoginEnable(Boolean isPasswordLoginEnable) {
		this.isPasswordLoginEnable = isPasswordLoginEnable;
	}

	public Boolean getIsTwoFALoginEnable() {
		return isTwoFALoginEnable;
	}

	public void setIsTwoFALoginEnable(Boolean isTwoFALoginEnable) {
		this.isTwoFALoginEnable = isTwoFALoginEnable;
	}

	public Boolean getIsCaptchaLoginEnable() {
		return isCaptchaLoginEnable;
	}

	public void setIsCaptchaLoginEnable(Boolean isCaptchaLoginEnable) {
		this.isCaptchaLoginEnable = isCaptchaLoginEnable;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public D001008Key getD001008Key() {
		D001008Key d001008Key = new D001008Key();
		d001008Key.setTenantId(this.tenantId);
		return d001008Key;
	}
}
