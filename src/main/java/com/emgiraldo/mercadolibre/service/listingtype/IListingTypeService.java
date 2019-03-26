package com.emgiraldo.mercadolibre.service.listingtype;

import java.util.List;

import com.emgiraldo.mercadolibre.service.listingtype.dto.ListingTypeDTO;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;

public interface IListingTypeService {
	
	public List<ListingTypeDTO> getListingTypesByCountry(SiteCountryCodes countryCode);

}
