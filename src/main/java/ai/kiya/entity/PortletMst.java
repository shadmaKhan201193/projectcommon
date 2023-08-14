package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D009509Key;


@Table(name="D009509")
@Entity
@IdClass(D009509Key.class)
public class PortletMst extends Base {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//	private D009509Key d009509Key = new D009509Key();
	
	
	///
	
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId=0;

	@Id
	@Column(nullable=false, length =60)
	private String portletCode = "";
	
	///
	
	@Column(nullable=true, length =400)
	private String portletName="";
	

	@Column(nullable=true,length =1000)
	private String portletJSPPath="";
	
	@Column(nullable=true)
	private Integer portletColSpan=1;
	
	@Column(nullable=true)
	private Integer portletRowSpan=1;

	@Column(nullable=true, length =100)
	private String dataVisibilityLevel="";		// Branch, Tenant
	
	@Column(nullable = true)
	private Integer isActive = 1;

	@Column(nullable = false, length =20)
	private String authStatus = "";
	
	
	
	
	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	

	public String getPortletName() {
		return portletName;
	}

	public void setPortletName(String portletName) {
		this.portletName = portletName;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Integer getPortletColSpan() {
		return portletColSpan;
	}

	public void setPortletColSpan(Integer portletColSpan) {
		this.portletColSpan = portletColSpan;
	}

	public Integer getPortletRowSpan() {
		return portletRowSpan;
	}

	public void setPortletRowSpan(Integer portletRowSpan) {
		this.portletRowSpan = portletRowSpan;
	}

	public String getDataVisibilityLevel() {
		return dataVisibilityLevel;
	}

	public void setDataVisibilityLevel(String dataVisibilityLevel) {
		this.dataVisibilityLevel = dataVisibilityLevel;
	}

	public String getPortletJSPPath() {
		return portletJSPPath;
	}

	public void setPortletJSPPath(String portletJSPPath) {
		this.portletJSPPath = portletJSPPath;
	}

	

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getPortletCode() {
		return portletCode;
	}

	public void setPortletCode(String portletCode) {
		this.portletCode = portletCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((portletCode == null) ? 0 : portletCode.hashCode());
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
		PortletMst other = (PortletMst) obj;
		if (portletCode == null) {
			if (other.portletCode != null)
				return false;
		} else if (!portletCode.equals(other.portletCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
	
}

