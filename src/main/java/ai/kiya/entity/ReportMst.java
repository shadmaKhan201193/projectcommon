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
import ai.kiya.key.D970096Key;
import ai.kiya.key.RoleKey;

@Table(name="D970096")
@Entity
@IdClass(D970096Key.class)
public class ReportMst extends Base{
	
private static final long serialVersionUID = 1L;
	
//	@EmbeddedId
//	private D970096Key d970096Key ;
	
	//
	
	@Id
	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;
	
	@Id
	@Column(nullable = false)
	private Integer lbrCode;
	
	
	@Id
	@Column(nullable = false, length =80)
	private String reportId  = "";
	
	//
	
	@Column(nullable = false, length =80)
	private String reportIddesc  = "";

	
	@OneToMany(mappedBy = "reportMst" ,fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<D970196> d970196 = new ArrayList<D970196>();
	
	

	/*
	 * public D970096Key getD970096Key() { return d970096Key; }
	 * 
	 * public void setD970096Key(D970096Key d970096Key) { this.d970096Key =
	 * d970096Key; }
	 */
	
	public String getReportIddesc() {
		return reportIddesc;
	}

	public void setReportIddesc(String reportIddesc) {
		this.reportIddesc = reportIddesc;
	}

	public List<D970196> getD970196() {
		return d970196;
	}

	public void setD970196(List<D970196> d970196) {
		this.d970196 = d970196;
	}
	
	
	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getLbrCode() {
		return lbrCode;
	}

	public void setLbrCode(Integer lbrCode) {
		this.lbrCode = lbrCode;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lbrCode == null) ? 0 : lbrCode.hashCode());
		result = prime * result + ((reportId == null) ? 0 : reportId.hashCode());
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
		ReportMst other = (ReportMst) obj;
		if (lbrCode == null) {
			if (other.lbrCode != null)
				return false;
		} else if (!lbrCode.equals(other.lbrCode))
			return false;
		if (reportId == null) {
			if (other.reportId != null)
				return false;
		} else if (!reportId.equals(other.reportId))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}
	
	
}
