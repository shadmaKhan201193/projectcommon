package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

//@Embeddable
public class D045947Key implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	@Column(nullable = false, length = 10)
	private String userLoginId;

	@Override
	public int hashCode() {
		return Objects.hash(tenantId, userLoginId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D045947Key other = (D045947Key) obj;
		return Objects.equals(tenantId, other.tenantId) 
				&& Objects.equals(userLoginId, other.userLoginId);
	}

}
