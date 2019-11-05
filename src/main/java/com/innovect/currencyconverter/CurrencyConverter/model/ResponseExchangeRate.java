package com.innovect.currencyconverter.CurrencyConverter.model;

public class ResponseExchangeRate {

	
	private String from;
	private String to;
	private String status;
	private Double exchangedRate;
	public ResponseExchangeRate(String from, String to, Double exchangedRate,String status) {
		super();
		this.from = from;
		this.to = to;
		this.exchangedRate = exchangedRate;
		this.status=status;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getExchangedRate() {
		return exchangedRate;
	}
	public void setExchangedRate(Double exchangedRate) {
		this.exchangedRate = exchangedRate;
	}
	
	
}
