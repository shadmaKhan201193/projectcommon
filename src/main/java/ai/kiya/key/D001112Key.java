package ai.kiya.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

public class D001112Key implements Serializable {
	private static final long serialVersionUID = 3905587165790155925L;

	@Column(nullable = false)
	private Integer isCoinYN;

	@Column(nullable = false)
	private Integer isPaperCurrencyYN;

	@Column(nullable = false)
	private Double denominationValue = 0D;

	@Column(nullable = false)
	private Integer noteType = 0;

	@Column(nullable = false, length = 6)
	private Integer tenantId;

	@Column(nullable = false, length = 5)
	private String currencyIsoCode = "";

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
		return Objects.hash(currencyIsoCode, denominationValue, isCoinYN, isPaperCurrencyYN, noteType, tenantId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		D001112Key other = (D001112Key) obj;
		return Objects.equals(currencyIsoCode, other.currencyIsoCode)
				&& Objects.equals(denominationValue, other.denominationValue)
				&& Objects.equals(isCoinYN, other.isCoinYN)
				&& Objects.equals(isPaperCurrencyYN, other.isPaperCurrencyYN)
				&& Objects.equals(noteType, other.noteType) 
				&& Objects.equals(tenantId, other.tenantId);
	}

}
