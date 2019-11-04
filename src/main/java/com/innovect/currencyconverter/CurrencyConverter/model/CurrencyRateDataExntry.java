package com.innovect.currencyconverter.CurrencyConverter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

import java.util.Date;
import java.util.Map;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;



public class CurrencyRateDataExntry {

 
    @JsonProperty("base")
     private String base;


    @JsonProperty("date")
     private java.util.Date date;


    @JsonProperty("time_last_updated")
   
    private long timeLastUpdated;
    
    
    @JsonProperty("rates") 
     private Map<String, Double> rates;

    
    public String getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public long getTimeLastUpdated() {
        return timeLastUpdated;
    }

    public Map<String, Double> getRates() {
        return rates;
    }


}