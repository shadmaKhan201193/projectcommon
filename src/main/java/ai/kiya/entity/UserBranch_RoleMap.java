package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base;

@Table(name = "UserBranch_RoleMap")
@Entity
public class UserBranch_RoleMap extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "fkUserBranchPk")
	private UserBranchMap userBranchMap;

	@Column(length = 40, nullable = true)
	private String roleCode = "";

	@Column(length=6, nullable = false)
	private Integer tenantId = 0;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public UserBranchMap getUserBranchMap() {
		return userBranchMap;
	}

	public UserBranchMap setUserBranchMap(UserBranchMap userBranchMap) {
		return this.userBranchMap = userBranchMap;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserBranch_RoleMap() {
	
	}

	public UserBranch_RoleMap(UserBranchMap userBranchMap, String roleCode) {
		super();
		this.userBranchMap = userBranchMap;
		this.roleCode = roleCode;
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

}
