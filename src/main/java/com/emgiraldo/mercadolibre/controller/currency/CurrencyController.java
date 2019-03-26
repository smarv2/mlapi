package com.emgiraldo.mercadolibre.controller.currency;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emgiraldo.mercadolibre.controller.dto.Response;
import com.emgiraldo.mercadolibre.service.categories.ICategoriesService;
import com.emgiraldo.mercadolibre.service.categories.dto.CategoryDTO;
import com.emgiraldo.mercadolibre.service.categories.utils.CategoryCountryCodes;
import com.emgiraldo.mercadolibre.service.currency.ICurrencyService;
import com.emgiraldo.mercadolibre.service.currency.dto.CurrencyDTO;
import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;
import com.emgiraldo.mercadolibre.service.listingtype.IListingTypeService;
import com.emgiraldo.mercadolibre.service.listingtype.dto.ListingTypeDTO;
import com.emgiraldo.mercadolibre.site.util.SiteCountryCodes;
import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;

@Controller
public class CurrencyController {

	@Autowired
	private ICategoriesService categoryService;
	@Autowired
	private ICurrencyService currenctyService;
	@Autowired
	private IListingTypeService listingTypeService;

	private static final Logger logger = Logger.getLogger(CurrencyController.class);

	@RequestMapping(value = "/currencies/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getListOfCurrenciesByCountryId(
			@RequestParam(value = "countryId", required = true) String countryId) {
		CurrencyDTO currency = currenctyService.getCurrencyByCountryId(SiteCountryCodes.COLOMBIA);

		return new Response(false, "Successfull", currency);
	}
}
