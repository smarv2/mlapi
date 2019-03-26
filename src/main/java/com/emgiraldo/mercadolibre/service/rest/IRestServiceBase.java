package com.emgiraldo.mercadolibre.service.rest;

import java.util.Map;

public interface IRestServiceBase<E> {

	public E[] doRestRequest(String url, Map<String, String> parameters, RestServiceType requestType);
	public E doRestRequestList(String url, Map<String, String> parameters, RestServiceType requestType);
}