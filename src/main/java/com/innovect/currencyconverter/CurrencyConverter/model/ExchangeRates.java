package com.innovect.currencyconverter.CurrencyConverter.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;

@Entity
@Table(name = "forex")
public class ExchangeRates {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "base")
	private String base;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@Column(name = "timeLastUpdated")
	private long timeLastUpdated;

	@Column(name = "toCureency")
	private String toCurrency;
	@Column(name = "exchangeRate")
	private Double exchangeRate;

	public ExchangeRates() {
	}

	public ExchangeRates(String base, Date date, long timeLastUpdated, String to, String rate) {
		super();
		this.base = base;
		this.date = date;
		this.timeLastUpdated = timeLastUpdated;
		this.toCurrency = to;
		this.exchangeRate = Double.valueOf(rate);
	}
	
	public String getTo() {
		return toCurrency;
	}

	public String getBase() {
		return base;
	}

	public Date getDate() {
		return date;
	}

	public long getTimeLastUpdated() {
		return timeLastUpdated;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

}
