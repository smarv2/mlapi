package com.emgiraldo.mercadolibre.service.item;

import java.util.Map;

import com.emgiraldo.mercadolibre.service.item.dto.ItemServiceDTO;
import com.emgiraldo.mercadolibre.service.rest.IRestServiceBase;
import com.emgiraldo.mercadolibre.service.rest.RestServiceImpl;
import com.emgiraldo.mercadolibre.service.rest.RestServiceType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemService {

	private IRestServiceBase<ItemServiceDTO> restService;

	public ItemService() {
		restService = new RestServiceImpl<>(ItemServiceDTO[].class, ItemServiceDTO.class);
	}

	public void listItem(ItemServiceDTO itemDto) {
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		Map<String, String> map = mapper.convertValue(itemDto, Map.class);
		restService.doRestRequest("url", map, RestServiceType.POST);
	}

}
