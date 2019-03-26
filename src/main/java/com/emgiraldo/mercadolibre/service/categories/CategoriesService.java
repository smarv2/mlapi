package com.emgiraldo.mercadolibre.service.categories;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emgiraldo.mercadolibre.service.categories.dto.CategoryDTO;
import com.emgiraldo.mercadolibre.service.categories.messages.MessagesEnum;
import com.emgiraldo.mercadolibre.service.categories.utils.CategoryCountryCodes;
import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;
import com.emgiraldo.mercadolibre.service.properties.PropertiesService;
import com.emgiraldo.mercadolibre.service.rest.IRestServiceBase;
import com.emgiraldo.mercadolibre.service.rest.RestServiceImpl;
import com.emgiraldo.mercadolibre.service.rest.RestServiceType;

@Service("categoriesService")
public class CategoriesService implements ICategoriesService{
	
	private IRestServiceBase<CategoryDTO> restService;
	private static String categoriesUrl;
	
	private static final Logger logger = Logger.getLogger(CategoriesService.class);
	
	@Autowired
	private PropertiesService propertiesService;
	
	public CategoriesService(){
			restService = new RestServiceImpl<>(CategoryDTO[].class, CategoryDTO.class);
	}
	
	@Override
	public List<CategoryDTO> getListOfCategoriesByCountryCode(CategoryCountryCodes countryCodes) throws ServiceException {
		if(countryCodes == null){
			logger.error("Error Code: " + MessagesEnum.ERROR_CATEGORIES_COUNTRY_ID.getCode() + ", Description: "
					+ MessagesEnum.ERROR_CATEGORIES_COUNTRY_ID.getMessage());
			throw new ServiceException(MessagesEnum.ERROR_CATEGORIES_COUNTRY_ID.getCode()+"-"+MessagesEnum.ERROR_CATEGORIES_COUNTRY_ID.getMessage());
		}		
		categoriesUrl = String.format(propertiesService.getMercadolibreCategoriesUrl(), countryCodes.getCountryCode());
		CategoryDTO[] response = restService.doRestRequest(categoriesUrl, null, RestServiceType.GET);
		return Arrays.asList(response);
	}		
}
