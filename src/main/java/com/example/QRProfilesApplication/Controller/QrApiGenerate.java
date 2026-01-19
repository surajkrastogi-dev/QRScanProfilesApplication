package com.example.QRProfilesApplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.QRProfilesApplication.Entity.UserDetails;
import com.example.QRProfilesApplication.Model.QrCodeResponse;
import com.example.QRProfilesApplication.Model.UserRequest;
import com.example.QRProfilesApplication.Service.QrCodeService;
import com.example.QRProfilesApplication.Service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/qr")
@RequiredArgsConstructor
public class QrApiGenerate {
	
	private final UserService userService;
	private final QrCodeService qrCodeService;
	
	@PostMapping("/generate")
	public ResponseEntity<QrCodeResponse> generateToken(@RequestBody UserRequest request) throws Exception {
		
		UserDetails user = userService.saveUserDetails(request);

		String profileUrl = userService.getBaseProfileUrl(user.getUserToken());
		String qrBase64 = qrCodeService.generateQrBase64(profileUrl, 300, 300);
		
		return ResponseEntity.ok(new QrCodeResponse(user.getUserToken(),profileUrl,qrBase64));
	}
	

}
