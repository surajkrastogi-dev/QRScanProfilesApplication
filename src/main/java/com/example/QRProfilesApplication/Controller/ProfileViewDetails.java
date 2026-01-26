package com.example.QRProfilesApplication.Controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.QRProfilesApplication.Entity.UserDetails;
import com.example.QRProfilesApplication.Repository.UserRepository;
import com.example.QRProfilesApplication.Service.QrCodeService;
import com.example.QRProfilesApplication.Service.UserService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ProfileViewDetails {

	private final UserRepository userRepo;
	private final UserService userService;
	private final QrCodeService qrCodeService;
	
	@GetMapping("/view")
	public String getProfileview(@RequestParam("token") String token,Model model) throws Exception {
		//check token and expiry and isUed
		UserDetails user = userRepo.findByUserToken(token)
				.orElseThrow(()-> new RuntimeException("Token Invalid"));
		
		if(user.getExpiryTime()!=null && user.getExpiryTime().isBefore(LocalDateTime.now())) {
			model.addAttribute("error","Token Expired");
			return "error-page";
		}
		
		if(user.isUsed()) {
			model.addAttribute("error","Token Already Used");
		}
		
		user.setUsed(true);
		userRepo.save(user);
		
		String url = userService.getBaseProfileUrl(user.getUserToken());
		String qrBase64 = qrCodeService.generateQrBase64(url, 250, 250);
		
		//model 
		model.addAttribute("user",user);
		model.addAttribute("url",url);
		model.addAttribute("expiryTime",user.getExpiryTime().toString());
		model.addAttribute("qrBase64",qrBase64);
		
		return "user-profile";
	}
	
}
