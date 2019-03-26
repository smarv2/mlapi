package com.emgiraldo.mercadolibre.service.categories.utils;

public enum CategoryCountryCodes {
	
	COLOMBIA("MLC"), ARGENTINA("MLA");
	
	private String countryCode;
	
	CategoryCountryCodes(String countryCode){
		this.countryCode = countryCode;
	}
	
	public String getCountryCode(){
		return this.countryCode;
	}
}
