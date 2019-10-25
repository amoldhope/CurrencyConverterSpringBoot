package com.innovect.currencyconverter.CurrencyConverter.config;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionConfig {
	private String rateExchangeApi = "https://api.exchangerate-api.com/v4/latest/USD";

	public String getCurrencyExchangeApi() {
		return rateExchangeApi;
	}
}
