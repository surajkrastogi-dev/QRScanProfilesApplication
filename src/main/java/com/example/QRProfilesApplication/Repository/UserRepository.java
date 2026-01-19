package com.example.QRProfilesApplication.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QRProfilesApplication.Entity.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{
	Optional<UserDetails> findByUserToken(String token);
	Optional<UserDetails> findByUserName(String name);
	Optional<UserDetails> findByUserEmail(String email);
}
