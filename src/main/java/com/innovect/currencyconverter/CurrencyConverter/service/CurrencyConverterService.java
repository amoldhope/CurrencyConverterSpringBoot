package com.innovect.currencyconverter.CurrencyConverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterDAO;
import com.innovect.currencyconverter.CurrencyConverter.dao.CurrencyConverterRepository;
import com.innovect.currencyconverter.CurrencyConverter.model.CurrencyRateDataExntry;

@Service
public class CurrencyConverterService {

	CurrencyRateDataExntry rate = null;
	@Autowired
	private CurrencyConverterDAO currencyConverterDao;
	@Autowired
	private CurrencyConverterRepository repository;
	ObjectMapper mapper = new ObjectMapper();

	public void serilizeMap() throws JsonProcessingException {
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rate.getRates());
		System.out.println(json);
		rate.setExchangeRateJSON(json);
	}

	public void convert(String from, String to) throws JsonProcessingException {
		rate = currencyConverterDao.getExchangeRate();
		this.serilizeMap();
		System.out.println("successfully saved");

//	        if (rate == null || CollectionUtils.isEmpty(rate.getRates())) {
//	            System.out.println("no data found");
//	        }
//	        System.out.println(rate.getBase());
//	        rate.getRates().forEach((k,v) -> System.out.println("country = "
//	                + k + ", rates = " + v));
	}
}
