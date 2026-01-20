package com.example.QRProfilesApplication.Config;

import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class RequestIpAdress {
	
	public static String getIpAddress(HttpServletRequest request) {
		try {
			String xf = request.getHeader("X-Forwarded-For");
			return xf !=null ? xf.split(",")[0] : request.getRemoteAddr() ;
			
		} catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
	public static String getUserAgent(HttpServletRequest request) {
		try {
			return request.getHeader("User-Agent");
		} catch (Exception e) {
			return e.getMessage();
			// TODO: handle exception
		}
	}
	

}
