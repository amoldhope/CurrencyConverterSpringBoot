package com.innovect.currencyconverter.CurrencyConverter.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.innovect.currencyconverter.CurrencyConverter.model.ExchangeRates;

@Repository
public interface CurrencyConverterRepository extends CrudRepository<ExchangeRates, String> {

	ExchangeRates findByToCurrency(String to);

}
