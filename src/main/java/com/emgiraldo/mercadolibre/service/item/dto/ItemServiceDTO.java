package com.emgiraldo.mercadolibre.service.item.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemServiceDTO {
	
	private String title;
	@JsonProperty("category_id")
	private String category;
	private String price;
	@JsonProperty("currency_id")
	private String currencyId;
	@JsonProperty("available_quantity")
	private int quantity;
	@JsonProperty("buying_mode")
	private String buyingMode = "buy_it_now";
	@JsonProperty("listing_type_id")
	private String listingTypeId;
	private String condition = "new";
	private String desciption;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBuyingMode() {
		return buyingMode;
	}
	public void setBuyingMode(String buyingMode) {
		this.buyingMode = buyingMode;
	}
	public String getListingTypeId() {
		return listingTypeId;
	}
	public void setListingTypeId(String listingTypeId) {
		this.listingTypeId = listingTypeId;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	

}
