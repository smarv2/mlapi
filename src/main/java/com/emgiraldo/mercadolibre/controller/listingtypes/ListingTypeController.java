package com.emgiraldo.mercadolibre.controller.listingtypes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emgiraldo.mercadolibre.controller.dto.Response;
import com.emgiraldo.mercadolibre.service.listingtype.IListingTypeService;
import com.emgiraldo.mercadolibre.service.listingtype.dto.ListingTypeDTO;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;


@Controller
public class ListingTypeController {

	@Autowired
	private IListingTypeService listingTypeService;

	@RequestMapping(value = "/listingtypes/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getListOfCurrenciesByCountryId(
			@RequestParam(value = "countryId", required = true) String countryId) {
		
		SiteCountryCodes siteCountry = null;
		if(countryId.equals(SiteCountryCodes.COLOMBIA.getCountryCode())){
			siteCountry = SiteCountryCodes.COLOMBIA;
		}else{
			return new Response(false, "Failed retrive.");
		}
		
		List<ListingTypeDTO> listingtypes = listingTypeService.getListingTypesByCountry(siteCountry);

		return new Response(true, "Successfull", listingtypes);
	}
}
