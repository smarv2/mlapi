package com.emgiraldo.mercadolibre.service.currency;

import com.emgiraldo.mercadolibre.service.currency.dto.CurrencyDTO;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;

public interface ICurrencyService {
	
	public CurrencyDTO getCurrencyByCountryId(SiteCountryCodes currencyCode);

}
