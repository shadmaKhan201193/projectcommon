package ai.kiya.key;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D009401Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Column(nullable = false, length = 6)
	private Integer branchCode = 0;

	@Column(nullable = false, length = 40)
	private String holidayCode = "";

	@Column(nullable = true)
	private Date holidayDate;

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

	public String getHolidayCode() {
		return holidayCode;
	}

	public void setHolidayCode(String holidayCode) {
		this.holidayCode = holidayCode;
	}

	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(branchCode, holidayCode, holidayDate, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009401Key other = (D009401Key) obj;
		return Objects.equals(branchCode, other.branchCode) 
				&& Objects.equals(holidayCode, other.holidayCode)
				&& Objects.equals(holidayDate, other.holidayDate) 
				&& Objects.equals(tenantId, other.tenantId);
	}
}
