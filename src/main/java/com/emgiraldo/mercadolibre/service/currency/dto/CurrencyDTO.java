package com.emgiraldo.mercadolibre.service.currency.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyDTO {
	
	private String id;
	@JsonProperty("country_id")
	private String countryId;
	@JsonProperty("default_currency_id")
	private String defaultCurrencyId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryId() {
		return countryId;
	}
	public void set_country_id(String countryId) {
		this.countryId = countryId;
	}
	public String getDefaultCurrencyId() {
		return defaultCurrencyId;
	}
	public void setDefaultCurrencyId(String defaultCurrencyId) {
		this.defaultCurrencyId = defaultCurrencyId;
	}
}
