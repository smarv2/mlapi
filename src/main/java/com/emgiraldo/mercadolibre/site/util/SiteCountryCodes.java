package com.emgiraldo.mercadolibre.site.util;

public enum SiteCountryCodes {
	
	COLOMBIA("MCO");
	
	private String countryCode;
	
	SiteCountryCodes(String countryCode){
		this.countryCode = countryCode;
	}
	
	public String getCountryCode(){
		return this.countryCode;
	}
	
}
