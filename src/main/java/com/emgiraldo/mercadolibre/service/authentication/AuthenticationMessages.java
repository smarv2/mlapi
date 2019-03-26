package com.emgiraldo.mercadolibre.service.authentication;

public enum AuthenticationMessages {
	
	ERROR_AUTHORIZATION("100", "Authorization error with Mercadolibre.");
	
	private String code;
	private String message;
	
	AuthenticationMessages(String code, String message){
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
