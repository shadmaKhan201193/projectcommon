package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@MappedSuperclass
//@Embeddable
public class D970096Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(nullable = false)
	private Integer lbrCode;

	@Column(nullable = false, length = 80)
	private String reportId = "";

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
		return Objects.hash(lbrCode, reportId, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D970096Key other = (D970096Key) obj;
		return Objects.equals(lbrCode, other.lbrCode) 
				&& Objects.equals(reportId, other.reportId)
				&& Objects.equals(tenantId, other.tenantId);
	}

}
