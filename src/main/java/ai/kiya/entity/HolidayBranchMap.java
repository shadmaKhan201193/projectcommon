package ai.kiya.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D009401Key;
import ai.kiya.omni.OmniConstants;

@Table(name = "D009401")
@Entity
@IdClass(D009401Key.class)
public class HolidayBranchMap extends Base {
	private static final long serialVersionUID = 1701926931204630606L;

//	@EmbeddedId
//	private D009401Key d009401Key = new D009401Key();

//
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId = 0;

	@Id
	@Column(nullable = false, length = 6)
	private Integer branchCode = 0;

	@Id
	@Column(nullable = false, length = 40)
	private String holidayCode = "";

	@Id
	@Column(nullable = true)
	private Date holidayDate;

	//
	@Column(nullable = true, length = 8)
	private Integer setNo = 0;

	@Column(nullable = true, updatable = true, length = 4)
	private String holidayId = "";

	@Column(nullable = true, length = 4)
	private Integer year = 0;

	/*
	 * @Column(nullable = true, updatable = true, columnDefinition = "nvarchar(4)")
	 */
	@Column(nullable = true, updatable = true, length = 4)
	private String countryCode = "";

	@Column(nullable = true, updatable = true, length = 4)
	private String stateCode = "";

	public String getHolidayId() {
		return holidayId;
	}

	public void setHolidayId(String holidayId) {
		this.holidayId = holidayId;
	}

	@Column(nullable = true, length = 1)
	private Integer eachYearReoccur = OmniConstants.ACTIVE;

	public Integer getSetNo() {
		if (null != setNo) {
		} else {
			setNo = super.initInteger;
		}
		return setNo;
	}

	public void setSetNo(Integer setNo) {
		this.setNo = setNo;
	}

	public Integer getYear() {
		if (null != year) {
		} else {
			year = super.initInteger;
		}
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCountryCode() {
		if (null != countryCode) {
		} else {
			countryCode = super.initString;
		}
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		if (null != stateCode) {
		} else {
			stateCode = super.initString;
		}
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getEachYearReoccur() {
		if (null != eachYearReoccur) {
		} else {
			eachYearReoccur = super.initInteger;
		}
		return eachYearReoccur;
	}

	public void setEachYearReoccur(Integer eachYearReoccur) {
		this.eachYearReoccur = eachYearReoccur;
	}

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

	public D009401Key getD009401Key() {
		D009401Key d009401Key = new D009401Key();
		d009401Key.setBranchCode(this.branchCode);
		d009401Key.setHolidayCode(this.holidayCode);
		d009401Key.setHolidayDate(this.holidayDate);
		d009401Key.setTenantId(this.tenantId);
		return d009401Key;
	}

}
