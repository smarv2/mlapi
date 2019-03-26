package com.emgiraldo.mercadolibre.service.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emgiraldo.mercadolibre.service.currency.dto.CurrencyDTO;
import com.emgiraldo.mercadolibre.service.properties.PropertiesService;
import com.emgiraldo.mercadolibre.service.rest.IRestServiceBase;
import com.emgiraldo.mercadolibre.service.rest.RestServiceImpl;
import com.emgiraldo.mercadolibre.service.rest.RestServiceType;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;

@Service("currencyService")
public class CurrencyService implements ICurrencyService{
	
	@Autowired
	private PropertiesService propertiesService;
	private IRestServiceBase<CurrencyDTO> restService;
	
	private static String currencyUrl;
	
	public CurrencyService(){
		restService = new RestServiceImpl<>(CurrencyDTO[].class, CurrencyDTO.class);
	}
	
	@Override
	public CurrencyDTO getCurrencyByCountryId(SiteCountryCodes currencyCode) {
		if(currencyCode == null){
			
		}
		
		currencyUrl = String.format(propertiesService.getMercadolibreCurrenciesUrl(), currencyCode.getCountryCode());
		return restService.doRestRequestList(currencyUrl, null, RestServiceType.GET);
	}

}
