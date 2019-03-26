package com.emgiraldo.mercadolibre.service.categories.dto;

import java.util.List;

public class ResponseDTO {
	
	private List<CategoryDTO> categories;

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
	}

}
