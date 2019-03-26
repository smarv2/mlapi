package com.emgiraldo.mercadolibre.service.exceptions;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1045066712553224489L;

	public ServiceException(){
		super();
	}
	
	public ServiceException(String message){
		super(message);
	}
	
	public ServiceException(String message, Throwable cause){
		super(message,cause);
	}

}
