package ai.kiya.key;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D009501Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length = 6, nullable = false)
	private Integer tenantId = 0;

	@Column(nullable = false /* columnDefinition = "DATETIME" */)
	private Date effFromdate;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Date getEffFromdate() {
		return effFromdate;
	}

	public void setEffFromdate(Date effFromdate) {
		this.effFromdate = effFromdate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(effFromdate, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009501Key other = (D009501Key) obj;
		return Objects.equals(effFromdate, other.effFromdate) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
