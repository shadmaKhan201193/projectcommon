package ai.kiya.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import ai.kiya.base.Base;
import ai.kiya.key.D001001Key;

@Table(name="D001001")
@Entity
@IdClass(D001001Key.class)
public class LookupCode  extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D001001Key d001001Key = new D001001Key();
	
	
	//
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
     @Id
	@Column(length = 20, nullable = false)
	private String lookupCode = ""; // menuCode will remain same across all

	//

	@Column(nullable = true, length = 100)
	private String lookupCodeDesc = "";

	
	@Column(nullable = true, length = 100)
	private String lookupTypeCode = ""; // 'SYSTEM', 'USER' - 2 values only.

	@OneToMany(mappedBy = "lookupCodee" ,fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LookupValue> lookupValues = new ArrayList<LookupValue>();

	

	
	public String getLookupCodeDesc() {
		if(null!=lookupCodeDesc ){} else {lookupCodeDesc = super.initString;}
		return lookupCodeDesc;
	}

	public void setLookupCodeDesc(String lookupCodeDesc) {
		this.lookupCodeDesc = lookupCodeDesc;
	}

	public String getLookupTypeCode() {
		if(null!=lookupTypeCode ){} else {lookupTypeCode = super.initString;}
		return lookupTypeCode;
	}

	public void setLookupTypeCode(String lookupTypeCode) {
		this.lookupTypeCode = lookupTypeCode;
	}

	public void addLookupValue(LookupValue lookupValues) {
		this.lookupValues.add(lookupValues);
	}
	
	public List<LookupValue> getLookupValues() {
		return lookupValues;
	}

	public void setLookupValues(List<LookupValue> lookupValues) {
		this.lookupValues = lookupValues;
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

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lookupCode == null) ? 0 : lookupCode.hashCode());
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
		LookupCode other = (LookupCode) obj;
		if (lookupCode == null) {
			if (other.lookupCode != null)
				return false;
		} else if (!lookupCode.equals(other.lookupCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
	public D001001Key getD001001Key() {
		D001001Key d001001Key = new D001001Key();
		d001001Key.setLookupCode(this.lookupCode);
		d001001Key.setTenantId(this.tenantId);
		return d001001Key;
	}
	
}
