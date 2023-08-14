package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class Address2Key implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(length = 40, nullable = false)
	private String empId = "";

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address2Key other = (Address2Key) obj;
		return Objects.equals(empId, other.empId) 
				&& Objects.equals(tenantId, other.tenantId);
	}

		
}
