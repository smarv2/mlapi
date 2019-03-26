package com.emgiraldo.mercadolibre.service.listingtype.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListingTypeDTO {
	
	@JsonProperty("site_id")
	private String siteId;
	private String id;
	private String name;
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
