package ai.kiya.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base;


@Table(name = "UserBranchMap")
@Entity
public class UserBranchMap extends Base {
	

	private static final long serialVersionUID = -4522245459090949880L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(nullable = false, length=6)
	private Integer branchCode ;

	@Column(length = 10, nullable = true)
	private String loginId = "";

	@Column(length=6, nullable = false)
	private Integer tenantId = 0;

	@OneToMany(mappedBy = "userBranchMap", cascade = CascadeType.ALL)
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<UserBranch_RoleMap> userBranch_RoleMaps = new ArrayList<UserBranch_RoleMap>();
	
	//private UserMst UserMst;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(Integer branchCode) {
		this.branchCode = branchCode;
	}


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/*public UserMst getUserMst() {
		return UserMst;
	}

	public void setUserMst(UserMst userMst) {
		UserMst = userMst;
	} */

	public Collection<UserBranch_RoleMap> getUserBranch_RoleMaps() {
		return userBranch_RoleMaps;
	}

	public void setUserBranch_RoleMaps(
			Collection<UserBranch_RoleMap> userBranch_RoleMaps) {
		this.userBranch_RoleMaps = userBranch_RoleMaps;
	}

	public void addUserBranch_RoleMaps(UserBranch_RoleMap userBranch_RoleMap) {
		this.userBranch_RoleMaps.add(userBranch_RoleMap);
	}

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	
}
