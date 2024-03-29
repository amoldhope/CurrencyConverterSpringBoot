package com.innovect.currencyconverter.CurrencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.innovect.currencyconverter.CurrencyConverter.model.ResponseExchangeRate;
import com.innovect.currencyconverter.CurrencyConverter.service.CurrencyConverterService;

@RestController
public class CurrencyConversionController {
	@Autowired
	CurrencyConverterService service;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseExchangeRate converter(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		Double exchangeRate=service.convert(from,to);
		if(exchangeRate==0.0)
		{
			return new ResponseExchangeRate(from, to, exchangeRate*quantity,"failed to convert, Currency Not found");

		}
		return new ResponseExchangeRate(from, to, exchangeRate*quantity,"Successfully converted");
	}
}
