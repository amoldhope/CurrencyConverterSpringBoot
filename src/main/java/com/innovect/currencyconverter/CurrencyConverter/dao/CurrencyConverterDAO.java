package com.innovect.currencyconverter.CurrencyConverter.dao;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.innovect.currencyconverter.CurrencyConverter.config.CurrencyConversionConfig;

@Component
public class CurrencyConverterDAO {
	private CurrencyConversionConfig config;

	@Autowired
	public CurrencyConverterDAO(CurrencyConversionConfig config) {
		this.config = config;
	}

	public String getExchangeRate() {
		RestTemplate restTemplate = new RestTemplate();
		URI rateExchangeUri = UriComponentsBuilder.fromUriString(config.getCurrencyExchangeApi()).build().toUri();
		ResponseEntity<String> entity = restTemplate.getForEntity(rateExchangeUri, String.class);
		return entity == null ? null : entity.getBody();
	}
}
