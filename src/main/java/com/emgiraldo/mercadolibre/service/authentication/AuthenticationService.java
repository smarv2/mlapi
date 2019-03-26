package com.emgiraldo.mercadolibre.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;
import com.emgiraldo.mercadolibre.service.properties.PropertiesService;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;

@Service("authenticationService")
@Scope("singleton")
public class AuthenticationService implements IAuthenticationService{

	@Autowired
	private PropertiesService propertiesService;
	private Meli meli;

	public AuthenticationService() {
		super();
		meli = new Meli(Long.valueOf(propertiesService.getMercadolibreCustomerId()),
				propertiesService.getMercadolibreAppKey());
	}

	public String getAccessToken(String code) throws ServiceException {		
		try {
			meli.authorize(code, propertiesService.getMercadolibreAppCallback());
		} catch (AuthorizationFailure e) {
			// TODO Auto-generated catch block
			throw new ServiceException(AuthenticationMessages.ERROR_AUTHORIZATION.getMessage(), e);
		}
		return meli.getAccessToken();
	}
}
