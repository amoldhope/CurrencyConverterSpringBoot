package com.innovect.currencyconverter.CurrencyConverter.service;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterDAO;
import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterRepository;
import com.innovect.currencyconverter.CurrencyConverter.model.CurrencyRateDataExntry;
import com.innovect.currencyconverter.CurrencyConverter.model.ExchangeRates;

@Service
public class CurrencyConverterService {

	CurrencyRateDataExntry rate = null;
	@Autowired
	private CurrencyConverterDAO currencyConverterDao;
	@Autowired
	private CurrencyConverterRepository repository;
	ObjectMapper mapper = new ObjectMapper();
	String json;

	
	@PostConstruct
    public void init() {
		System.out.println("amol");
		rate = currencyConverterDao.getExchangeRate();

		for (Map.Entry<String, Double> currency : rate.getRates().entrySet()) {
			
//			System.out.println(currency.getKey()+" "+currency.getValue());
			ExchangeRates rateObject=new ExchangeRates(rate.getBase(),rate.getDate(),rate.getTimeLastUpdated(),currency.getKey(),currency.getValue());
			repository.save(rateObject);
		}

	}
	
	
	public Double convert(String from, String to) throws JsonProcessingException {
		
		

		
		if(from.equals("USD")) {
			ExchangeRates currency=repository.findByToCurrency(to);
			return currency.getExchangeRate();
			
		}
		else if(to.equals("USD")) {
			ExchangeRates currency=repository.findByToCurrency(from);
			return 1/currency.getExchangeRate();
			
		}
		else
		{
			ExchangeRates fromCurrency=repository.findByToCurrency(from);
			ExchangeRates toCurrency=repository.findByToCurrency(to);
			double factor=1/fromCurrency.getExchangeRate();
			double exchangeFactor=factor*toCurrency.getExchangeRate();
			return exchangeFactor;	
		}
		
	}
}
