package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import ai.kiya.base.Base;
import ai.kiya.key.D001013Key;

@Table(name = "D001013")
@Entity
@IdClass(D001013Key.class)
public class CalenderMst extends Base {

	private static final long serialVersionUID = 2378968444463270063L;

//	@EmbeddedId
//	private D001013Key d001013Key ;

	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Id
	@Column(nullable = false, length = 6)
	private Integer branchCode;

	@Id
	@Column(nullable = false, length = 20)
	private String calType = "";

	@Id
	@Column(nullable = false, length = 2)
	private Integer calYear;

	@Id
	@Column(nullable = false, length = 1)
	private Integer calMonth;//

	//
	@Column(nullable = true, length = 1)
	private Integer dayType1;

	@Column(nullable = true, length = 1)
	private Integer dayType2;

	@Column(nullable = true, length = 1)
	private Integer dayType3;

	@Column(nullable = true, length = 1)
	private Integer dayType4;

	@Column(nullable = true, length = 1)
	private Integer dayType5;

	@Column(nullable = true, length = 1)
	private Integer dayType6;

	@Column(nullable = true, length = 1)
	private Integer dayType7;

	@Column(nullable = true, length = 1)
	private Integer dayType8;

	@Column(nullable = true, length = 1)
	private Integer dayType9;

	@Column(nullable = true, length = 1)
	private Integer dayType10;

	@Column(nullable = true, length = 1)
	private Integer dayType11;

	@Column(nullable = true, length = 1)
	private Integer dayType12;

	@Column(nullable = true, length = 1)
	private Integer dayType13;

	@Column(nullable = true, length = 1)
	private Integer dayType14;

	@Column(nullable = true, length = 1)
	private Integer dayType15;

	@Column(nullable = true, length = 1)
	private Integer dayType16;

	@Column(nullable = true, length = 1)
	private Integer dayType17;

	@Column(nullable = true, length = 1)
	private Integer dayType18;

	@Column(nullable = true, length = 1)
	private Integer dayType19;

	@Column(nullable = true, length = 1)
	private Integer dayType20;

	@Column(nullable = true, length = 1)
	private Integer dayType21;

	@Column(nullable = true, length = 1)
	private Integer dayType22;

	@Column(nullable = true, length = 1)
	private Integer dayType23;

	@Column(nullable = true, length = 1)
	private Integer dayType24;

	@Column(nullable = true, length = 1)
	private Integer dayType25;

	@Column(nullable = true, length = 1)
	private Integer dayType26;

	@Column(nullable = true, length = 1)
	private Integer dayType27;

	@Column(nullable = true, length = 1)
	private Integer dayType28;

	@Column(nullable = true, length = 1)
	private Integer dayType29;

	@Column(nullable = true, length = 1)
	private Integer dayType30;

	@Column(nullable = true, length = 1)
	private Integer dayType31;

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

	public Integer getDayType1() {
		if (null != dayType1) {
		} else {
			dayType1 = super.initInteger;
		}
		return dayType1;
	}

	public void setDayType1(Integer dayType1) {

		this.dayType1 = dayType1;
	}

	public Integer getDayType2() {
		if (null != dayType2) {
		} else {
			dayType2 = super.initInteger;
		}
		return dayType2;
	}

	public void setDayType2(Integer dayType2) {
		this.dayType2 = dayType2;
	}

	public Integer getDayType3() {
		if (null != dayType3) {
		} else {
			dayType3 = super.initInteger;
		}
		return dayType3;
	}

	public void setDayType3(Integer dayType3) {
		this.dayType3 = dayType3;
	}

	public Integer getDayType4() {
		if (null != dayType4) {
		} else {
			dayType4 = super.initInteger;
		}
		return dayType4;
	}

	public void setDayType4(Integer dayType4) {
		this.dayType4 = dayType4;
	}

	public Integer getDayType5() {
		if (null != dayType5) {
		} else {
			dayType5 = super.initInteger;
		}
		return dayType5;
	}

	public void setDayType5(Integer dayType5) {
		this.dayType5 = dayType5;
	}

	public Integer getDayType6() {
		if (null != dayType6) {
		} else {
			dayType6 = super.initInteger;
		}
		return dayType6;
	}

	public void setDayType6(Integer dayType6) {
		this.dayType6 = dayType6;
	}

	public Integer getDayType7() {
		if (null != dayType7) {
		} else {
			dayType7 = super.initInteger;
		}
		return dayType7;
	}

	public void setDayType7(Integer dayType7) {
		this.dayType7 = dayType7;
	}

	public Integer getDayType8() {
		if (null != dayType8) {
		} else {
			dayType8 = super.initInteger;
		}
		return dayType8;
	}

	public void setDayType8(Integer dayType8) {
		this.dayType8 = dayType8;
	}

	public Integer getDayType9() {
		if (null != dayType9) {
		} else {
			dayType9 = super.initInteger;
		}
		return dayType9;
	}

	public void setDayType9(Integer dayType9) {
		this.dayType9 = dayType9;
	}

	public Integer getDayType10() {
		if (null != dayType10) {
		} else {
			dayType10 = super.initInteger;
		}
		return dayType10;
	}

	public void setDayType10(Integer dayType10) {
		this.dayType10 = dayType10;
	}

	public Integer getDayType11() {
		if (null != dayType11) {
		} else {
			dayType11 = super.initInteger;
		}
		return dayType11;
	}

	public void setDayType11(Integer dayType11) {
		this.dayType11 = dayType11;
	}

	public Integer getDayType12() {
		if (null != dayType12) {
		} else {
			dayType12 = super.initInteger;
		}
		return dayType12;
	}

	public void setDayType12(Integer dayType12) {
		this.dayType12 = dayType12;
	}

	public Integer getDayType13() {
		if (null != dayType13) {
		} else {
			dayType13 = super.initInteger;
		}
		return dayType13;
	}

	public void setDayType13(Integer dayType13) {
		this.dayType13 = dayType13;
	}

	public Integer getDayType14() {
		if (null != dayType14) {
		} else {
			dayType14 = super.initInteger;
		}
		return dayType14;
	}

	public void setDayType14(Integer dayType14) {
		this.dayType14 = dayType14;
	}

	public Integer getDayType15() {
		if (null != dayType15) {
		} else {
			dayType15 = super.initInteger;
		}
		return dayType15;
	}

	public void setDayType15(Integer dayType15) {
		this.dayType15 = dayType15;
	}

	public Integer getDayType16() {
		if (null != dayType16) {
		} else {
			dayType16 = super.initInteger;
		}
		return dayType16;
	}

	public void setDayType16(Integer dayType16) {
		this.dayType16 = dayType16;
	}

	public Integer getDayType17() {
		if (null != dayType17) {
		} else {
			dayType17 = super.initInteger;
		}
		return dayType17;
	}

	public void setDayType17(Integer dayType17) {
		this.dayType17 = dayType17;
	}

	public Integer getDayType18() {
		if (null != dayType18) {
		} else {
			dayType18 = super.initInteger;
		}
		return dayType18;
	}

	public void setDayType18(Integer dayType18) {
		this.dayType18 = dayType18;
	}

	public Integer getDayType19() {
		if (null != dayType19) {
		} else {
			dayType19 = super.initInteger;
		}
		return dayType19;
	}

	public void setDayType19(Integer dayType19) {
		this.dayType19 = dayType19;
	}

	public Integer getDayType20() {
		if (null != dayType20) {
		} else {
			dayType20 = super.initInteger;
		}
		return dayType20;
	}

	public void setDayType20(Integer dayType20) {
		this.dayType20 = dayType20;
	}

	public Integer getDayType21() {
		if (null != dayType21) {
		} else {
			dayType21 = super.initInteger;
		}
		return dayType21;
	}

	public void setDayType21(Integer dayType21) {
		this.dayType21 = dayType21;
	}

	public Integer getDayType22() {
		if (null != dayType22) {
		} else {
			dayType22 = super.initInteger;
		}
		return dayType22;
	}

	public void setDayType22(Integer dayType22) {
		this.dayType22 = dayType22;
	}

	public Integer getDayType23() {
		if (null != dayType23) {
		} else {
			dayType23 = super.initInteger;
		}
		return dayType23;
	}

	public void setDayType23(Integer dayType23) {
		this.dayType23 = dayType23;
	}

	public Integer getDayType24() {
		if (null != dayType24) {
		} else {
			dayType24 = super.initInteger;
		}
		return dayType24;
	}

	public void setDayType24(Integer dayType24) {
		this.dayType24 = dayType24;
	}

	public Integer getDayType25() {
		if (null != dayType25) {
		} else {
			dayType25 = super.initInteger;
		}
		return dayType25;
	}

	public void setDayType25(Integer dayType25) {
		this.dayType25 = dayType25;
	}

	public Integer getDayType26() {
		if (null != dayType26) {
		} else {
			dayType26 = super.initInteger;
		}
		return dayType26;
	}

	public void setDayType26(Integer dayType26) {
		this.dayType26 = dayType26;
	}

	public Integer getDayType27() {
		if (null != dayType27) {
		} else {
			dayType27 = super.initInteger;
		}
		return dayType27;
	}

	public void setDayType27(Integer dayType27) {
		this.dayType27 = dayType27;
	}

	public Integer getDayType28() {
		if (null != dayType28) {
		} else {
			dayType28 = super.initInteger;
		}
		return dayType28;
	}

	public void setDayType28(Integer dayType28) {
		this.dayType28 = dayType28;
	}

	public Integer getDayType29() {
		if (null != dayType29) {
		} else {
			dayType29 = super.initInteger;
		}
		return dayType29;
	}

	public void setDayType29(Integer dayType29) {
		this.dayType29 = dayType29;
	}

	public Integer getDayType30() {
		if (null != dayType30) {
		} else {
			dayType30 = super.initInteger;
		}
		return dayType30;
	}

	public void setDayType30(Integer dayType30) {
		this.dayType30 = dayType30;
	}

	public Integer getDayType31() {
		if (null != dayType31) {
		} else {
			dayType31 = super.initInteger;
		}
		return dayType31;
	}

	public void setDayType31(Integer dayType31) {
		this.dayType31 = dayType31;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchCode == null) ? 0 : branchCode.hashCode());
		result = prime * result + ((calMonth == null) ? 0 : calMonth.hashCode());
		result = prime * result + ((calType == null) ? 0 : calType.hashCode());
		result = prime * result + ((calYear == null) ? 0 : calYear.hashCode());
		result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalenderMst other = (CalenderMst) obj;
		if (branchCode == null) {
			if (other.branchCode != null)
				return false;
		} else if (!branchCode.equals(other.branchCode))
			return false;
		if (calMonth == null) {
			if (other.calMonth != null)
				return false;
		} else if (!calMonth.equals(other.calMonth))
			return false;
		if (calType == null) {
			if (other.calType != null)
				return false;
		} else if (!calType.equals(other.calType))
			return false;
		if (calYear == null) {
			if (other.calYear != null)
				return false;
		} else if (!calYear.equals(other.calYear))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D001013Key getD001013Key() {
		D001013Key d001013Key = new D001013Key();
		d001013Key.setBranchCode(this.branchCode);
		d001013Key.setCalMonth(this.calMonth);
		d001013Key.setCalType(this.calType);
		d001013Key.setCalYear(this.calYear);
		d001013Key.setTenantId(this.tenantId);
		return d001013Key;
	}

}
