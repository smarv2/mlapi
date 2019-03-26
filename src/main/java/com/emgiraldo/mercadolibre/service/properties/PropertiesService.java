package com.emgiraldo.mercadolibre.service.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:mercadolibre.properties")
public class PropertiesService {
	
	@Autowired
	private Environment env;		
	
	public String getMercadolibreCategoriesUrl(){
		return env.getProperty(CATEGORIES_URL);
	}
	
	public String getMercadolibreCurrenciesUrl(){
		return env.getProperty(CURRENCY_URL);
	}
	
	public String getMercadolibreListingTypesUrl(){
		return env.getProperty(LISTING_TYPES_URL);
	}
	
	public String getMercadolibreCustomerId(){
		return env.getProperty(CUTOMER_ID);
	}
	
	public String getMercadolibreAppKey(){
		return env.getProperty(APP_KEY);
	}
	
	public String getMercadolibreAppCallback(){
		return env.getProperty(APP_CALL_BACK_URL);
	}
	
	private static final String CATEGORIES_URL = "mercadolibre.url.categories";
	private static final String CURRENCY_URL = "mercadolibre.url.currencies";
	private static final String LISTING_TYPES_URL = "mercadolibre.url.listingtypes"; 
	
	
	private static final String CUTOMER_ID = "mercadolibre.customer.id";
	private static final String APP_KEY = "mercadolibre.app.key";
	private static final String APP_CALL_BACK_URL = "mercadolibre.app.callbackurl";
}

