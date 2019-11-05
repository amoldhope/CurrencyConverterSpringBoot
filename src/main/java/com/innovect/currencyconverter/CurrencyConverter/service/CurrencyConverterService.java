package com.innovect.currencyconverter.CurrencyConverter.service;

import java.util.Date;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterDAO;
import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterRepository;
import com.innovect.currencyconverter.CurrencyConverter.model.ExchangeRates;

@Service
public class CurrencyConverterService {

	@Autowired
	private CurrencyConverterDAO currencyConverterDao;
	@Autowired
	private CurrencyConverterRepository repository;
	String base = "USD";
	Long timeLastUpdated = 5343434L;

	@PostConstruct
	public void init() throws ParseException {
		String apiDataString = currencyConverterDao.getExchangeRate();
		JSONParser parse = new JSONParser();
		JSONObject jobj = (JSONObject) parse.parse(apiDataString);
		JSONObject rate = (JSONObject) jobj.get("rates");
		Set<String> keys = rate.keySet();
		for (String key : keys) {
			ExchangeRates rateObject = new ExchangeRates(base, new Date(), timeLastUpdated, key,
					rate.get(key).toString());
			repository.save(rateObject);
		}

	}

	public Double convert(String from, String to) {

		if(repository.findByToCurrency(from) == null || repository.findByToCurrency(to) == null ) {
			return 0.0;
		}
		
		if (from.equals(base)) {
			ExchangeRates currency = repository.findByToCurrency(to);
			return (currency.getExchangeRate());

		} else if (to.equals(base)) {
			ExchangeRates currency = repository.findByToCurrency(from);
			return (1 / currency.getExchangeRate());

		} else {
			ExchangeRates fromCurrency = repository.findByToCurrency(from);
			ExchangeRates toCurrency = repository.findByToCurrency(to);
			double factor = 1 / fromCurrency.getExchangeRate();
			double exchangeFactor = factor * toCurrency.getExchangeRate();
			return (exchangeFactor);
		}

	}
}
