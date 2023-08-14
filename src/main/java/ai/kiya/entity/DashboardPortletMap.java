package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ai.kiya.base.Base;

@Table(name = "DashboardPortletMap")
@Entity
public class DashboardPortletMap extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	@Column(nullable=false, length=10)
	private String dashId="";
	
	@Column(nullable=false, length=40)
	private String dashboardCode="";			// Auto generated - SEQ
	
	@Column(columnDefinition = "nvarchar(200)", nullable = true)
	private String portletCode = "";
	
	@Column(nullable=true)
	private Integer portletDisplayRank;
	
	

	public String getDashboardCode() {
		return dashboardCode;
	}

	public void setDashboardCode(String dashboardCode) {
		this.dashboardCode = dashboardCode;
	}

	public String getPortletCode() {
		return portletCode;
	}

	public void setPortletCode(String portletCode) {
		this.portletCode = portletCode;
	}

	public Integer getPortletDisplayRank() {
		return portletDisplayRank;
	}

	public void setPortletDisplayRank(Integer portletDisplayRank) {
		this.portletDisplayRank = portletDisplayRank;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDashId() {
		return dashId;
	}

	public void setDashId(String dashId) {
		this.dashId = dashId;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	
}
