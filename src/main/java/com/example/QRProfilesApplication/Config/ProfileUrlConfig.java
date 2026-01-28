package com.example.QRProfilesApplication.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProfileUrlConfig {

	@Value("${app.base-url:http://localhost:8090}")
	private String baseUrl;
	
	public String generateBaseUrl(String token) {
		return baseUrl+"/user/view?token="+token;
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
}
