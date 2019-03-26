package com.emgiraldo.mercadolibre.controller.dto;

public class Response {
	
	private boolean success = false;
	private String msg = "";
	private Object data = null;
	
	public Response() {
	}

	public Response(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public Response(boolean success, String msg, Object data) {
		this.success = success;
		this.msg = msg;
		this.data = data;		
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	public Object getData() {
		return data;
	}
	
}
