package com.emgiraldo.mercadolibre.service.categories.messages;

public enum MessagesEnum {
	
	//Error Messages
	ERROR_CATEGORIES_COUNTRY_ID("01","Country identifies is needed for retrieving categories.");

	private String code;
	private String message;
	
	MessagesEnum(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getMessage(){
		return this.message;
	}
}
