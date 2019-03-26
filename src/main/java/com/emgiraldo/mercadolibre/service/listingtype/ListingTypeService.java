package com.emgiraldo.mercadolibre.service.listingtype;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emgiraldo.mercadolibre.service.listingtype.dto.ListingTypeDTO;
import com.emgiraldo.mercadolibre.service.properties.PropertiesService;
import com.emgiraldo.mercadolibre.service.rest.IRestServiceBase;
import com.emgiraldo.mercadolibre.service.rest.RestServiceImpl;
import com.emgiraldo.mercadolibre.service.rest.RestServiceType;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;

@Service("listingTypeService")
public class ListingTypeService implements IListingTypeService{

	@Autowired
	private PropertiesService propertiesService;
	private IRestServiceBase<ListingTypeDTO> restService;
	private static String listingTypesUrl;
	
	public ListingTypeService(){
		restService = new RestServiceImpl<>(ListingTypeDTO[].class, ListingTypeDTO.class);
	}
	
	@Override
	public List<ListingTypeDTO> getListingTypesByCountry(SiteCountryCodes countryCode) {
		if(countryCode == null){
			
		}
		listingTypesUrl = String.format(propertiesService.getMercadolibreListingTypesUrl(), countryCode.getCountryCode());
		return Arrays.asList(restService.doRestRequest(listingTypesUrl, null, RestServiceType.GET));
	}

}
