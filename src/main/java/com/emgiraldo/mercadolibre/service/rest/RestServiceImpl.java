package com.emgiraldo.mercadolibre.service.rest;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


public class RestServiceImpl<E> implements IRestServiceBase<E>{
	
	private static final String HEADER_ACCEPT = "Accept";
	
	private Class<E[]> domainClass;
	private Class<E> singleDomainClass;
	
	public RestServiceImpl(Class<E[]> domain, Class<E> singleDomainClass){
		this.domainClass = domain;
		this.singleDomainClass = singleDomainClass;
	}
	
	
	public E doRestRequestList(String url, Map<String, String> parameters, RestServiceType requestType) {
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		
		if(parameters != null){
			MultiValueMap<String, String> innerParameters = new LinkedMultiValueMap<>();
			for(Map.Entry<String, String> entry:parameters.entrySet()){
				innerParameters.add(entry.getKey(), entry.getValue());
			}
			uriBuilder.queryParams(innerParameters);
		}
		
		HttpMethod httpMethod = null;
		if(requestType.equals(RestServiceType.GET)){
			httpMethod = HttpMethod.GET;
		}else if(requestType.equals(RestServiceType.POST)){
			httpMethod = HttpMethod.POST;
		}else if(requestType.equals(RestServiceType.DELETE)){
			httpMethod = HttpMethod.DELETE;
		}else if(requestType.equals(RestServiceType.PUT)){
			httpMethod = HttpMethod.PUT;
		}
		
		ResponseEntity<E> result = restTemplate.exchange(uriBuilder.build().encode().toUri(),
				httpMethod, new HttpEntity<E>(headers), singleDomainClass);		
		return result.getBody();
	}
	@Override
	public E[] doRestRequest(String url, Map<String, String> parameters, RestServiceType requestType) {
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		
		if(parameters != null){
			MultiValueMap<String, String> innerParameters = new LinkedMultiValueMap<>();
			for(Map.Entry<String, String> entry:parameters.entrySet()){
				innerParameters.add(entry.getKey(), entry.getValue());
			}
			uriBuilder.queryParams(innerParameters);
		}
		
		HttpMethod httpMethod = null;
		if(requestType.equals(RestServiceType.GET)){
			httpMethod = HttpMethod.GET;
		}else if(requestType.equals(RestServiceType.POST)){
			httpMethod = HttpMethod.POST;
		}else if(requestType.equals(RestServiceType.DELETE)){
			httpMethod = HttpMethod.DELETE;
		}else if(requestType.equals(RestServiceType.PUT)){
			httpMethod = HttpMethod.PUT;
		}
		
		ResponseEntity<E[]> result = restTemplate.exchange(uriBuilder.build().encode().toUri(),
				httpMethod, new HttpEntity<E>(headers), domainClass);		
		return result.getBody();
	}
	
}