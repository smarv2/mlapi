package com.emgiraldo.mercadolibre.service.categories;

import java.util.List;

import com.emgiraldo.mercadolibre.service.categories.dto.CategoryDTO;
import com.emgiraldo.mercadolibre.service.categories.utils.CategoryCountryCodes;
import com.emgiraldo.mercadolibre.service.exceptions.ServiceException;

public interface ICategoriesService {
	
	public List<CategoryDTO> getListOfCategoriesByCountryCode(CategoryCountryCodes countryCodes) throws ServiceException;

}
