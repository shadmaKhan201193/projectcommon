package ai.kiya.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D045947Key;

@Table(name="D045947")
@Entity
@IdClass(D045947Key.class)
public class ResetPasswordMst  extends Base{
	private static final long serialVersionUID = 1L;
	
//	@EmbeddedId
//	private D045947Key d045947Key;
	
	///
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Id
	@Column(nullable = false, length = 10)
	private String userLoginId;
	///
	
	
	
	@Column(nullable =true)
	private Date dob;
	
	@Column(nullable =true,length = 20)
	private String id = "";
		
	@Column(nullable =true,length = 15)
	private String phoneNo = "";
	
	@Column(nullable =true,length = 35)
	private String secretQn = "";
	
	@Column(nullable =true,length = 35)
	private String secretAns = "";

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getSecretQn() {
		return secretQn;
	}

	public void setSecretQn(String secretQn) {
		this.secretQn = secretQn;
	}

	public String getSecretAns() {
		return secretAns;
	}

	public void setSecretAns(String secretAns) {
		this.secretAns = secretAns;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((userLoginId == null) ? 0 : userLoginId.hashCode());
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
		ResetPasswordMst other = (ResetPasswordMst) obj;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (userLoginId == null) {
			if (other.userLoginId != null)
				return false;
		} else if (!userLoginId.equals(other.userLoginId))
			return false;
		return true;
	}
	
	
}
