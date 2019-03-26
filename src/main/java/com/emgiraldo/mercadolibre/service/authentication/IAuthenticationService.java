package com.emgiraldo.mercadolibre.service.authentication;

import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;

public interface IAuthenticationService {
	
	public String getAccessToken(String code) throws ServiceException;
	
}
