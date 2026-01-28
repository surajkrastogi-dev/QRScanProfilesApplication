package com.example.QRProfilesApplication.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.QRProfilesApplication.Config.ProfileUrlConfig;
import com.example.QRProfilesApplication.Config.TokenGeneration;
import com.example.QRProfilesApplication.Entity.UserDetails;
import com.example.QRProfilesApplication.Model.UserRequest;
import com.example.QRProfilesApplication.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final ProfileUrlConfig profileUrlConfig;
	private final UserRepository userRepo;
	private final TokenGeneration tokenGen;
	
	public UserDetails saveUserDetails(UserRequest request) {
		
		Optional<UserDetails> existingUser = userRepo.findByUserEmail(request.getEmail());

	    if (existingUser.isPresent()) {
	        throw new RuntimeException("Email already exists");
	    }
		
		return userRepo.findByUserEmail(request.getEmail())
		.orElseGet(()->{
			
			UserDetails user = new UserDetails();
			user.setUserName(request.getName());
			user.setUserEmail(request.getEmail());
			user.setMobile(request.getMobile());
			
			user.setUserToken(tokenGen.generateToken());
			user.setUsed(false);
			user.setExpiryTime(LocalDateTime.now().plusMinutes(10));
			user.setActive(true);
	        user.setScancount(0);
			userRepo.save(user);
			return user;
		});
	}
	
	public String getBaseProfileUrl(String token) {
		return profileUrlConfig.generateBaseUrl(token);
	}

}
