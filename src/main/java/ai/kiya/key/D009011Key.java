package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class D009011Key implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Column(nullable = false, length = 10)
	private Integer memberCode = 0;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(Integer memberCode) {
		this.memberCode = memberCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberCode, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D009011Key other = (D009011Key) obj;
		return Objects.equals(memberCode, other.memberCode) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
