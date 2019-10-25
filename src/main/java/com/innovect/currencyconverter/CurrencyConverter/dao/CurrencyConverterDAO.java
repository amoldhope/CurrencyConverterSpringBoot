package com.innovect.currencyconverter.CurrencyConverter.dao;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovect.currencyconverter.CurrencyConverter.config.CurrencyConversionConfig;
import com.innovect.currencyconverter.CurrencyConverter.model.CurrencyRateDataExntry;
@Component
public class CurrencyConverterDAO {
	 private CurrencyConversionConfig config;

	    @Autowired
	    public CurrencyConverterDAO( CurrencyConversionConfig config) {
	        this.config = config;
	    }

	    public CurrencyRateDataExntry getExchangeRate() {
	        RestTemplate restTemplate=new RestTemplate();
	        URI forecastUri = UriComponentsBuilder.fromUriString(config.getCurrencyExchangeApi()).build().toUri();
	        ResponseEntity<CurrencyRateDataExntry> entity = restTemplate.getForEntity(forecastUri, CurrencyRateDataExntry.class);
	        return entity == null ? null : entity.getBody();
	    }
}
