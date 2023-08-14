package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SeqKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Column(length = 10, nullable = false)
	private String branchCode = "";

	@Column(length = 4, nullable = false)
	private String trailApply = "";

	@Column(length = 4, nullable = false)
	private String fromDate = "";

	@Column(length = 20, nullable = false)
	private String toDate = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getTrailApply() {
		return trailApply;
	}

	public void setTrailApply(String trailApply) {
		this.trailApply = trailApply;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchCode, fromDate, tenantId, toDate, trailApply);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SeqKey other = (SeqKey) obj;
		return Objects.equals(branchCode, other.branchCode) 
				&& Objects.equals(fromDate, other.fromDate)
				&& Objects.equals(tenantId, other.tenantId) 
				&& Objects.equals(toDate, other.toDate)
				&& Objects.equals(trailApply, other.trailApply);
	}

}
