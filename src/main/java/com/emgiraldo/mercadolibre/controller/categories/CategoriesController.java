package com.emgiraldo.mercadolibre.controller.categories;

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
public class CategoriesController {
	
	@Autowired
	private ICategoriesService categoryService;
	@Autowired
	private ICurrencyService currenctyService;
	@Autowired
	private IListingTypeService listingTypeService;
	
	private static final Logger logger = Logger.getLogger(CategoriesController.class);
	
	@RequestMapping(value = "/categories/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object getListOfCategoriesByCountryId(
			@RequestParam(value = "countryId", required = true) String countryId){
		
//		CurrencyDTO currency = currenctyService.getCurrencyByCountryId(SiteCountryCodes.COLOMBIA);
//		List<ListingTypeDTO> listingtypes = listingTypeService.getListingTypesByCountry(SiteCountryCodes.COLOMBIA);
		
		CategoryCountryCodes countryCode = null;
		
		if(countryId.equals(CategoryCountryCodes.COLOMBIA.getCountryCode())){
			countryCode = CategoryCountryCodes.COLOMBIA;
		}else if(countryId.equals(CategoryCountryCodes.ARGENTINA.getCountryCode())){
			countryCode = CategoryCountryCodes.ARGENTINA;
		}
		List<CategoryDTO> listOfCategories = new ArrayList<>();
		try{
			listOfCategories = categoryService.getListOfCategoriesByCountryCode(countryCode);
		}catch(ServiceException e){
			logger.error("Controller Exception caused by "+e.getMessage());
			return new Response(false, e.getMessage(), listOfCategories);
		}
		return new Response(false, "Successfull", listOfCategories);
	}
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object callback(@RequestParam(value = "code") String code) {
		//TG-560746b6e4b0cd0e9fb6c653-23295464
		Meli m = new Meli(8805597532943962l, "G73kXryiDVJUZZTaDa5eunmiMqNH0xrt");
		
		//System.out.println(redirectUrl);
		try {
			m.authorize(code, "http://localhost:8080/mercadolibre/callback");
		} catch (AuthorizationFailure e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Response(false, "Successfull");
	}

}
