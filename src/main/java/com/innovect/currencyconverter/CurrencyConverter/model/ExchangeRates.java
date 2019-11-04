package com.innovect.currencyconverter.CurrencyConverter.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "forex")
public class ExchangeRates {

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	
	@Column(name="base")
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

	public ExchangeRates(String base, Date date, long timeLastUpdated, String to, Double exchangeRate) {
		super();
		this.base = base;
		this.date = date;
		this.timeLastUpdated = timeLastUpdated;
		this.toCurrency = to;
		this.exchangeRate= exchangeRate;
	}

	public String getTo() {
		return toCurrency;
	}

	public void setTo(String to) {
		this.toCurrency = to;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public void setTimeLastUpdated(long timeLastUpdated) {
		this.timeLastUpdated = timeLastUpdated;
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

}
