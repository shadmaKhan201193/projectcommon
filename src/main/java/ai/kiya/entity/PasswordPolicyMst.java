package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import ai.kiya.base.Base;
import ai.kiya.key.D009401Key;
import ai.kiya.key.D009501Key;
import ai.kiya.key.RoleKey;

@Table(name="D009501")
@Entity
@IdClass(D009501Key.class)
public class PasswordPolicyMst extends Base{
	private static final long serialVersionUID = -438557550095371672L;

//	@EmbeddedId
//	private D009501Key d009501Key = new D009501Key();
	
	
	//
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	@Id
	@Column(nullable = false /*columnDefinition = "DATETIME"*/)
	private Date effFromdate;
	
	//
	@Column(nullable = true, length = 20)
	private String id;

	@Column(nullable = false)
	private Date effToDate;

	
	@Column(nullable = true)
	private Integer minPwdLength = 0;

	

	@Column(nullable = true)
	private Integer maxPwdLength = 0;

	

	@Column(nullable = true, length = 1)
	private Integer isMixCase=0;


	@Column(nullable = true)
	private Integer minAlphaLength = 0;

	

	@Column(nullable = true)
	private Integer minDigits = 0;

	

	@Column(nullable = true)
	private Integer minSpecialChars = 0;


	@Column(nullable = true)
	private Integer pwdValidateDays = 0;


	@Column(nullable = true)
	private Integer pwdRepeatFrequency = 0;


	@Column(nullable = true)
	private Integer timeoutSession = 0;
	
	@Column(nullable = true)
	private Integer autoExpirePassword = 0;
	
	@Column(nullable = true)
	private Integer badLogins = 0;
	
	@Column(nullable = true)
	private Integer coolingPeriod = 0;
	
	@Column(nullable = true)
	private Integer userLockAttempt = 0;
	
	@Column(nullable = true, length = 1)
	private Integer ipAccessRestrict=0;
	/*NEW FIELDS - END*/
	
	@Transient
	private Boolean flag;
	
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEffToDate() {
		if (null != effToDate) {
		} else {
			effToDate = super.initDate();
		}
		return effToDate;
	}

	public void setEffToDate(Date effToDate) {
		this.effToDate = effToDate;
	}

	public Integer getMinPwdLength() {
		if (null != minPwdLength) {
		} else {
			minPwdLength = super.initInteger;
		}
		return minPwdLength;
	}

	public void setMinPwdLength(Integer minPwdLength) {
		this.minPwdLength = minPwdLength;
	}

	public Integer getMaxPwdLength() {
		if (null != maxPwdLength) {
		} else {
			maxPwdLength = super.initInteger;
		}
		return maxPwdLength;
	}

	public void setMaxPwdLength(Integer maxPwdLength) {
		this.maxPwdLength = maxPwdLength;
	}


	public Integer getIsMixCase() {
		if (null != isMixCase) {
		} else {
			isMixCase = super.initInteger;
		}
		return isMixCase;
	}

	public void setIsMixCase(Integer isMixCase) {
		this.isMixCase = isMixCase;
	}

	public Integer getMinAlphaLength() {
		if (null != minAlphaLength) {
		} else {
			minAlphaLength = super.initInteger;
		}
		return minAlphaLength;
	}

	public void setMinAlphaLength(Integer minAlphaLength) {
		this.minAlphaLength = minAlphaLength;
	}

	public Integer getMinDigits() {
		if (null != minDigits) {
		} else {
			minDigits = super.initInteger;
		}
		return minDigits;
	}

	public void setMinDigits(Integer minDigits) {
		this.minDigits = minDigits;
	}

	public Integer getMinSpecialChars() {
		if (null != minSpecialChars) {
		} else {
			minSpecialChars = super.initInteger;
		}
		return minSpecialChars;
	}

	public void setMinSpecialChars(Integer minSpecialChars) {
		this.minSpecialChars = minSpecialChars;
	}

	public Integer getPwdValidateDays() {
		if (null != pwdValidateDays) {
		} else {
			pwdValidateDays = super.initInteger;
		}
		return pwdValidateDays;
	}

	public void setPwdValidateDays(Integer pwdValidateDays) {
		this.pwdValidateDays = pwdValidateDays;
	}

	public Integer getPwdRepeatFrequency() {
		if (null != pwdRepeatFrequency) {
		} else {
			pwdRepeatFrequency = super.initInteger;
		}
		return pwdRepeatFrequency;
	}

	public void setPwdRepeatFrequency(Integer pwdRepeatFrequency) {
		this.pwdRepeatFrequency = pwdRepeatFrequency;
	}

	public Integer getAutoExpirePassword() {
		if (null != autoExpirePassword) {
		} else {
			autoExpirePassword = super.initInteger;
		}
		return autoExpirePassword;
	}

	public void setAutoExpirePassword(Integer autoExpirePassword) {
		this.autoExpirePassword = autoExpirePassword;
	}

	public Integer getBadLogins() {
		if (null != badLogins) {
		} else {
			badLogins = super.initInteger;
		}
		return badLogins;
	}

	public void setBadLogins(Integer badLogins) {
		this.badLogins = badLogins;
	}

	public Integer getUserLockAttempt() {
		if (null != userLockAttempt) {
		} else {
			userLockAttempt = super.initInteger;
		}
		return userLockAttempt;
	}

	public void setUserLockAttempt(Integer userLockAttempt) {
		this.userLockAttempt = userLockAttempt;
	}

	public Integer getTimeoutSession() {
		if (null != timeoutSession) {
		} else {
			timeoutSession = super.initInteger;
		}
		return timeoutSession;
	}

	public void setTimeoutSession(Integer timeoutSession) {
		this.timeoutSession = timeoutSession;
	}

	public Integer getCoolingPeriod() {
		if (null != coolingPeriod) {
		} else {
			coolingPeriod = super.initInteger;
		}
		return coolingPeriod;
	}

	public void setCoolingPeriod(Integer coolingPeriod) {
		this.coolingPeriod = coolingPeriod;
	}

	


	public Integer getIpAccessRestrict() {
		if (null != ipAccessRestrict) {
		} else {
			ipAccessRestrict = super.initInteger;
		}
		return ipAccessRestrict;
	}

	public void setIpAccessRestrict(Integer ipAccessRestrict) {
		this.ipAccessRestrict = ipAccessRestrict;
	}
	
	
	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	
	public Date getEffFromdate() {
		return effFromdate;
	}

	public void setEffFromdate(Date effFromdate) {
		this.effFromdate = effFromdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((effFromdate == null) ? 0 : effFromdate.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PasswordPolicyMst other = (PasswordPolicyMst) obj;
		if (effFromdate == null) {
			if (other.effFromdate != null)
				return false;
		} else if (!effFromdate.equals(other.effFromdate))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
}
