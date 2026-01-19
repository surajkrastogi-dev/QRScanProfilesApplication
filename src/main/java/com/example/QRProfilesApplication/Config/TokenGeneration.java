package com.example.QRProfilesApplication.Config;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class TokenGeneration {
	
	public String generateToken() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
