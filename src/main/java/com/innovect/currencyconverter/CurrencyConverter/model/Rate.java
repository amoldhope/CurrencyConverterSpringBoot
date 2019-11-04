package com.innovect.currencyconverter.CurrencyConverter.model;

import javax.persistence.*;


public class Rate {

	@Column(name="id")
	private int id;
	
	@Id
	
	
	@Column(name="Currency")
	private String Currency;
	
	@Column (name="factor")
	private Double factor;
	
}
