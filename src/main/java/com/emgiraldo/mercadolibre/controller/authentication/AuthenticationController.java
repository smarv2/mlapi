package com.emgiraldo.mercadolibre.controller.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emgiraldo.mercadolibre.controller.dto.Response;
import com.emgiraldo.mercadolibre.service.properties.PropertiesService;
import com.mercadolibre.sdk.Meli;

@Controller
public class AuthenticationController {
	
	@Autowired
	private PropertiesService propertiesService;
	
	@RequestMapping(value = "/callback", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Object callback(@RequestParam(value = "code") String code) {
		//TG-560746b6e4b0cd0e9fb6c653-23295464
		Meli m = new Meli(Long.valueOf(propertiesService.getMercadolibreCustomerId()),
				propertiesService.getMercadolibreAppKey());		
		//TODO
		//Get the access token if desired and manage it.				
		return new Response(true, "Successfull");
	}

}
