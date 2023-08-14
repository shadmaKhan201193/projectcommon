package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base2;
import ai.kiya.key.D001002Key;

@Table(name="D001002")
@Entity
@IdClass(D001002Key.class)
public class LookupValue  extends Base2{
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D001002Key d001002Key = new D001002Key();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "tenantId",referencedColumnName = "tenantId", insertable = false, updatable = false),
		@JoinColumn(name = "lookupCode",referencedColumnName = "lookupCode", insertable = false, updatable = false),
	})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private LookupCode lookupCodee;

	//@Column(nullable = true, columnDefinition="nvarchar(200)", unique = false)
	@Column(nullable = true,length = 200)
	private String lookupDisplayValue = ""; // Can be different for different
											// tenants
	
	
	@Column(nullable = true,length = 1)
	private Integer isActive=1;

	@Column(nullable = true,length = 1)
	private String authStatus = "";

///
	@Id
	@Column(length = 10, nullable = true)
	private String languageCode = "";

	@Id
	@Column(length = 30, nullable = true)
	private String lookupValueCode = ""; // This value will be fixed across all

	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	@Id
	@Column(length = 20, nullable = false)
	private String lookupCode = ""; // menuCode will remain same across all
	
	///
	
	
	public String getLookupDisplayValue() {
		return lookupDisplayValue;
	}

	public void setLookupDisplayValue(String lookupDisplayValue) {
		this.lookupDisplayValue = lookupDisplayValue;
	}

	

	

	public LookupCode getLookupCodee() {
		return lookupCodee;
	}

	public void setLookupCodee(LookupCode lookupCodee) {
		this.lookupCodee = lookupCodee;
	}

	

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLookupValueCode() {
		return lookupValueCode;
	}

	public void setLookupValueCode(String lookupValueCode) {
		this.lookupValueCode = lookupValueCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}
	public String getLookupCode() {
		return lookupCode;
	}
	
	public void setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
	}
	
	

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((languageCode == null) ? 0 : languageCode.hashCode());
		result = prime * result + ((lookupValueCode == null) ? 0 : lookupValueCode.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		result = prime * result + ((lookupCode == null) ? 0 : lookupCode.hashCode());
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
		LookupValue other = (LookupValue) obj;
		if (languageCode == null) {
			if (other.languageCode != null)
				return false;
		} else if (!languageCode.equals(other.languageCode))
			return false;
		if (lookupCode == null) {
			if (other.lookupCode != null)
				return false;
		} else if (!lookupCode.equals(other.lookupCode))
			return false;
		if (lookupValueCode == null) {
			if (other.lookupValueCode != null)
				return false;
		} else if (!lookupValueCode.equals(other.lookupValueCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
}
