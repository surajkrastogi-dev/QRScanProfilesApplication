package com.example.QRProfilesApplication.Model;

public class QrCodeResponse {
	
	private String token;
	private String profileUrl;
	private String qrBase64;
	
	public QrCodeResponse(String token, String profileUrl, String qrBase64) {
		super();
		this.token = token;
		this.profileUrl = profileUrl;
		this.qrBase64 = qrBase64;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getQrBase64() {
		return qrBase64;
	}
	public void setQrBase64(String qrBase64) {
		this.qrBase64 = qrBase64;
	}
	
}
