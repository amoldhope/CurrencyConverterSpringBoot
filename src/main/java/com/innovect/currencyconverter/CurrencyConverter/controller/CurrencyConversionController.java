package com.innovect.currencyconverter.CurrencyConverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.innovect.currencyconverter.CurrencyConverter.service.CurrencyConverterService;

@RestController
public class CurrencyConversionController {
	@Autowired
	CurrencyConverterService service;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public Double converter(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) throws JsonProcessingException {
		Double exchangeRate=service.convert(from,to);
		return exchangeRate*quantity;
	}
}
