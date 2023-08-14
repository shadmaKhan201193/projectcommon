package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D001013Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Column(nullable = false, length = 6)
	private Integer branchCode;

	/* @Column(columnDefinition = "nvarchar(20)", nullable = false) */
	@Column(nullable = false, length = 20)
	private String calType = "";

	@Column(nullable = false, length = 2)
	private Integer calYear;

	@Column(nullable = false, length = 1)
	private Integer calMonth;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}

	public String getCalType() {
		return calType;
	}

	public void setCalType(String calType) {
		this.calType = calType;
	}

	public Integer getCalYear() {
		return calYear;
	}

	public void setCalYear(Integer calYear) {
		this.calYear = calYear;
	}

	public Integer getCalMonth() {
		return calMonth;
	}

	public void setCalMonth(Integer calMonth) {
		this.calMonth = calMonth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchCode, calMonth, calType, calYear, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D001013Key other = (D001013Key) obj;
		return Objects.equals(branchCode, other.branchCode) 
				&& Objects.equals(calMonth, other.calMonth)
				&& Objects.equals(calType, other.calType) 
				&& Objects.equals(calYear, other.calYear)
				&& Objects.equals(tenantId, other.tenantId);
	}

}
