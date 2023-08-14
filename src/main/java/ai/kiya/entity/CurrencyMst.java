package ai.kiya.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import ai.kiya.base.Base;
import ai.kiya.key.D001012Key;

@Table(name = "D001012")
@Entity
@IdClass(D001012Key.class)
public class CurrencyMst extends Base {
	private static final long serialVersionUID = 5511582096947790237L;

	@OneToMany(mappedBy = "currencyMst", fetch = FetchType.EAGER)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<D001112> d001112 = new ArrayList<D001112>();

////
	@Id
	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Id
	@Column(nullable = false, length = 5)
	private String currencyIsoCode = "";

	///

	@Column(nullable = false, length = 35)
	private String currencyName = "";

	@Column(nullable = true, length = 4)
	private Integer numCode;

	@Column(nullable = true, length = 3)
	private String swiftCd;

	@Column(nullable = true)
	private Date workHrsFrom;

	@Column(nullable = true)
	private Date workHrsTo;

	@Column(nullable = true)
	private Date gmtOffset;

	@Column(nullable = true)
	private Date localOffset;

	@Column(nullable = true, length = 1)
	private Integer weeklyOff1;

	@Column(nullable = true, length = 1)
	private Integer weeklyOff2;

	@Column(nullable = true, length = 1)
	private Integer weeklyOff3;

	@Column(nullable = true, length = 4)
	private String countryCode = "";

	@Column(nullable = true, length = 4)
	private String coinCode = "";

	@Column(nullable = true, length = 15)
	private String coinName = "";

	@Column(nullable = true, length = 4)
	private Integer coinsPerUnit;

	@Column(nullable = true, length = 1)
	private Integer amountType;

	@Column(nullable = true, length = 2)
	private Integer minorUnitDecimals;

	@Column(nullable = true, length = 5)
	private String decimalType;

	@Column(nullable = true, length = 2)
	private Integer dateType;

	@Column(nullable = true, length = 2)
	private Integer denTableSize;

	@Column(nullable = true, length = 2)
	private String directIndirect = "";

	@Column(nullable = true, length = 1)
	private Integer continent;

	@Column(nullable = true)
	private Double units = 0D;

	@Column(nullable = true, length = 1)
	private String currencyStatus = "";

	@Column(nullable = true, length = 5)
	private String currencyPrompt = "";

	@Column(nullable = true, length = 10)
	private String languageCode = "";

	@Column(nullable = true, length = 40)
	private String majorUnit = "";

	@Column(nullable = true, length = 40)
	private String minorUnit = "";

	@Column(nullable = true, precision = 9)
	private Double unitConversion = 0D;

	@Column(nullable = true, length = 1)
	private Integer NoticeDays;

	@Column(nullable = true, length = 1)
	private Integer NoticeHrs;

	@Column(nullable = true, length = 1)
	private Integer NoticeMin;

	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	public String getCurrencyIsoCode() {
		return currencyIsoCode;
	}

	public void setCurrencyIsoCode(String currencyIsoCode) {
		this.currencyIsoCode = currencyIsoCode;
	}

	public Collection<D001112> getD001112() {
		return d001112;
	}

	public void setD001112(Collection<D001112> d001112) {
		this.d001112 = d001112;
	}

	public String getCurrencyName() {
		if (null != currencyName) {
		} else {
			currencyName = super.initString;
		}
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public Integer getNumCode() {
		if (null != numCode) {
		} else {
			numCode = super.initInteger;
		}
		return numCode;
	}

	public void setNumCode(Integer numCode) {
		this.numCode = numCode;
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

	public String getCoinCode() {
		if (null != coinCode) {
		} else {
			coinCode = super.initString;
		}
		return coinCode;
	}

	public void setCoinCode(String coinCode) {
		this.coinCode = coinCode;
	}

	public String getCoinName() {
		if (null != coinName) {
		} else {
			coinName = super.initString;
		}
		return coinName;
	}

	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}

	public Integer getCoinsPerUnit() {
		if (null != coinsPerUnit) {
		} else {
			coinsPerUnit = super.initInteger;
		}
		return coinsPerUnit;
	}

	public void setCoinsPerUnit(Integer coinsPerUnit) {
		this.coinsPerUnit = coinsPerUnit;
	}

	public Integer getAmountType() {
		if (null != amountType) {
		} else {
			amountType = super.initInteger;
		}
		return amountType;
	}

	public void setAmountType(Integer amountType) {
		this.amountType = amountType;
	}

	public Integer getMinorUnitDecimals() {
		if (null != minorUnitDecimals) {
		} else {
			minorUnitDecimals = super.initInteger;
		}
		return minorUnitDecimals;
	}

	public void setMinorUnitDecimals(Integer minorUnitDecimals) {
		this.minorUnitDecimals = minorUnitDecimals;
	}

	public String getDecimalType() {
		if (null != decimalType) {
		} else {
			decimalType = super.initString;
		}
		return decimalType;
	}

	public void setDecimalType(String decimalType) {
		this.decimalType = decimalType;
	}

	public Integer getDateType() {
		if (null != dateType) {
		} else {
			dateType = super.initInteger;
		}
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public Integer getDenTableSize() {
		if (null != denTableSize) {
		} else {
			denTableSize = super.initInteger;
		}
		return denTableSize;
	}

	public void setDenTableSize(Integer denTableSize) {
		this.denTableSize = denTableSize;
	}

	public String getDirectIndirect() {
		if (null != directIndirect) {
		} else {
			directIndirect = super.initString;
		}
		return directIndirect;
	}

	public void setDirectIndirect(String directIndirect) {
		this.directIndirect = directIndirect;
	}

	public String getCurrencyStatus() {
		if (null != currencyStatus) {
		} else {
			currencyStatus = super.initString;
		}
		return currencyStatus;
	}

	public void setCurrencyStatus(String currencyStatus) {
		this.currencyStatus = currencyStatus;
	}

	public String getCurrencyPrompt() {
		if (null != currencyPrompt) {
		} else {
			currencyPrompt = super.initString;
		}
		return currencyPrompt;
	}

	public void setCurrencyPrompt(String currencyPrompt) {
		this.currencyPrompt = currencyPrompt;
	}

	public String getLanguageCode() {
		if (null != languageCode) {
		} else {
			languageCode = super.initString;
		}
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getMajorUnit() {
		if (null != majorUnit) {
		} else {
			majorUnit = super.initString;
		}
		return majorUnit;
	}

	public void setMajorUnit(String majorUnit) {
		this.majorUnit = majorUnit;
	}

	public String getMinorUnit() {
		if (null != minorUnit) {
		} else {
			minorUnit = super.initString;
		}
		return minorUnit;
	}

	public void setMinorUnit(String minorUnit) {
		this.minorUnit = minorUnit;
	}

	public Double getUnitConversion() {
		if (null != unitConversion) {
		} else {
			unitConversion = super.initDouble;
		}
		return unitConversion;
	}

	public void setUnitConversion(Double unitConversion) {
		this.unitConversion = unitConversion;
	}

	public Integer getContinent() {
		if (null != continent) {
		} else {
			continent = super.initInteger;
		}
		return continent;
	}

	public void setContinent(Integer continent) {
		this.continent = continent;
	}

	public Double getUnits() {
		if (null != units) {
		} else {
			units = super.initDouble;
		}
		return units;
	}

	public void setUnits(Double units) {
		this.units = units;
	}

	public String getSwiftCd() {
		if (null != swiftCd) {
		} else {
			swiftCd = super.initString;
		}
		return swiftCd;
	}

	public void setSwiftCd(String swiftCd) {
		this.swiftCd = swiftCd;
	}

	public Date getWorkHrsFrom() {
		if (null != workHrsFrom) {
		} else {
			workHrsFrom = super.initDate();
		}
		return workHrsFrom;
	}

	public void setWorkHrsFrom(Date workHrsFrom) {
		this.workHrsFrom = workHrsFrom;
	}

	public Date getWorkHrsTo() {
		if (null != workHrsTo) {
		} else {
			workHrsTo = super.initDate();
		}
		return workHrsTo;
	}

	public void setWorkHrsTo(Date workHrsTo) {
		this.workHrsTo = workHrsTo;
	}

	public Date getGmtOffset() {
		if (null != gmtOffset) {
		} else {
			gmtOffset = super.initDate();
		}
		return gmtOffset;
	}

	public void setGmtOffset(Date gmtOffset) {
		this.gmtOffset = gmtOffset;
	}

	public Date getLocalOffset() {
		if (null != localOffset) {
		} else {
			localOffset = super.initDate();
		}
		return localOffset;
	}

	public void setLocalOffset(Date localOffset) {
		this.localOffset = localOffset;
	}

	public Integer getWeeklyOff1() {
		if (null != weeklyOff1) {
		} else {
			weeklyOff1 = super.initInteger;
		}
		return weeklyOff1;
	}

	public void setWeeklyOff1(Integer weeklyOff1) {
		this.weeklyOff1 = weeklyOff1;
	}

	public Integer getWeeklyOff2() {
		if (null != weeklyOff2) {
		} else {
			weeklyOff2 = super.initInteger;
		}
		return weeklyOff2;
	}

	public void setWeeklyOff2(Integer weeklyOff2) {
		this.weeklyOff2 = weeklyOff2;
	}

	public Integer getWeeklyOff3() {
		if (null != weeklyOff3) {
		} else {
			weeklyOff3 = super.initInteger;
		}
		return weeklyOff3;
	}

	public void setWeeklyOff3(Integer weeklyOff3) {
		this.weeklyOff3 = weeklyOff3;
	}

	public Integer getNoticeDays() {
		if (null != NoticeHrs) {
		} else {
			NoticeHrs = super.initInteger;
		}
		return NoticeDays;
	}

	public void setNoticeDays(Integer noticeDays) {
		NoticeDays = noticeDays;
	}

	public Integer getNoticeHrs() {
		if (null != NoticeHrs) {
		} else {
			NoticeHrs = super.initInteger;
		}
		return NoticeHrs;
	}

	public void setNoticeHrs(Integer noticeHrs) {
		NoticeHrs = noticeHrs;
	}

	public Integer getNoticeMin() {
		if (null != NoticeMin) {
		} else {
			NoticeMin = super.initInteger;
		}
		return NoticeMin;
	}

	public void setNoticeMin(Integer noticeMin) {
		NoticeMin = noticeMin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currencyIsoCode == null) ? 0 : currencyIsoCode.hashCode());
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
		CurrencyMst other = (CurrencyMst) obj;
		if (currencyIsoCode == null) {
			if (other.currencyIsoCode != null)
				return false;
		} else if (!currencyIsoCode.equals(other.currencyIsoCode))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}

	public D001012Key getD001012Key() {
		D001012Key d001012Key = new D001012Key();
		d001012Key.setCurrencyIsoCode(this.currencyIsoCode);
		d001012Key.setTenantId(this.tenantId);
		return d001012Key;
	}
}
