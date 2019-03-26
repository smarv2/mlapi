package com.emgiraldo.mercadolibre.site.util;

import com.mercadolibre.sdk.AuthorizationFailure;
import com.mercadolibre.sdk.Meli;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Meli m = new Meli(88055l, "UZZTaDa5eunmiMqNH0xrt");
		String redirectUrl = m.getAuthUrl("http://localhost:8080/mercadolibre/callback");
		System.out.println(redirectUrl);
//		try {
//			m.authorize("TG-560746b6e4b0cd0e9fb6c653-23295464", redirectUrl);
//		} catch (AuthorizationFailure e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
