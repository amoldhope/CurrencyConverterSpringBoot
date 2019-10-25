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

@Entity
public class CurrencyRateDataExntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("base")
    @Column(name = "base")
    private String base;


    @JsonProperty("date")
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date;


    @JsonProperty("time_last_updated")
    @Column(name = "lasttimeupdated")
    private long timeLastUpdated;


    @JsonProperty("rates")
    @Transient
    private Map<String, String> rates;

    @Column(name = "exchangeRateJson")
    private String exchangeRateJSON;

    public String getBase() {
        return base;
    }

    public Date getDate() {
        return date;
    }

    public long getTimeLastUpdated() {
        return timeLastUpdated;
    }

    public Map<String, String> getRates() {
        return rates;
    }


    public String getExchangeRateJSON() {
        return exchangeRateJSON;
    }

    public void setExchangeRateJSON(String exchangeRateJSON) {
        this.exchangeRateJSON = exchangeRateJSON;
    }
}
