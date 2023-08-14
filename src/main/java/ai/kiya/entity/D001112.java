package ai.kiya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ai.kiya.base.Base2;
import ai.kiya.key.D001112Key;

@Entity
@IdClass(D001112Key.class)
public class D001112 extends Base2{
	private static final long serialVersionUID = 4943433102287754701L;

//	@EmbeddedId
//	private D001112Key d001112Key ;
	
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "tenantId",referencedColumnName = "tenantId", insertable = false, updatable = false),
		@JoinColumn(name = "currencyIsoCode",referencedColumnName = "currencyIsoCode", insertable = false, updatable = false)		
	})
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	private CurrencyMst currencyMst;
	
	
	@Column(nullable=true, length = 10)
    private String majorMinorUnit = "" ;
	/////
	@Id
	@Column(nullable = false)
    private Integer isCoinYN;
	
	@Id
	@Column(nullable = false)
    private Integer isPaperCurrencyYN;
	
	@Id
	@Column(nullable=false)
    private Double denominationValue = 0D;
	
	@Id
	@Column(nullable=false)
    private Integer noteType = 0;

	@Id
	@Column( nullable = false,length=6)
	private Integer tenantId;
	
	@Id
	@Column(nullable=false, length = 5)
	private String currencyIsoCode = "";
	/////


	public CurrencyMst getCurrencyMst() {
		return currencyMst;
	}

	public void setCurrencyMst(CurrencyMst currencyMst) {
		this.currencyMst = currencyMst;
	}

	public String getMajorMinorUnit() {
		return majorMinorUnit;
	}

	public void setMajorMinorUnit(String majorMinorUnit) {
		this.majorMinorUnit = majorMinorUnit;
	}

	public Integer getIsCoinYN() {
		return isCoinYN;
	}

	public void setIsCoinYN(Integer isCoinYN) {
		this.isCoinYN = isCoinYN;
	}

	public Integer getIsPaperCurrencyYN() {
		return isPaperCurrencyYN;
	}

	public void setIsPaperCurrencyYN(Integer isPaperCurrencyYN) {
		this.isPaperCurrencyYN = isPaperCurrencyYN;
	}

	public Double getDenominationValue() {
		return denominationValue;
	}

	public void setDenominationValue(Double denominationValue) {
		this.denominationValue = denominationValue;
	}

	public Integer getNoteType() {
		return noteType;
	}

	public void setNoteType(Integer noteType) {
		this.noteType = noteType;
	}

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
	   
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((denominationValue == null) ? 0 : denominationValue.hashCode());
			result = prime * result + ((isCoinYN == null) ? 0 : isCoinYN.hashCode());
			result = prime * result + ((isPaperCurrencyYN == null) ? 0 : isPaperCurrencyYN.hashCode());
			result = prime * result + ((noteType == null) ? 0 : noteType.hashCode());
			result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
			result = prime * result + ((currencyIsoCode == null) ? 0 : currencyIsoCode.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			D001112 other = (D001112) obj;
			if (denominationValue == null) {
				if (other.denominationValue != null)
					return false;
			} else if (!denominationValue.equals(other.denominationValue))
				return false;
			if (isCoinYN == null) {
				if (other.isCoinYN != null)
					return false;
			} else if (!isCoinYN.equals(other.isCoinYN))
				return false;
			if (isPaperCurrencyYN == null) {
				if (other.isPaperCurrencyYN != null)
					return false;
			} else if (!isPaperCurrencyYN.equals(other.isPaperCurrencyYN))
				return false;
			if (noteType == null) {
				if (other.noteType != null)
					return false;
			} else if (!noteType.equals(other.noteType))
				return false;
			if (tenantId == null) {
				if (other.tenantId != null)
					return false;
			} else if (!tenantId.equals(other.tenantId))
				return false;
			
			if (currencyIsoCode == null) {
				if (other.currencyIsoCode != null)
					return false;
			} else if (!currencyIsoCode.equals(other.currencyIsoCode))
				return false;
			
			return true;
		}
	
	
	
}
