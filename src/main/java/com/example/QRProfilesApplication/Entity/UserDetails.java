package com.example.QRProfilesApplication.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_details",schema="QRProfileApp")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="user_email")
	private String userEmail;
	
	@Column(name="user_token")
	private String userToken;
	
	private String mobile;
	
	@Column(name="expiry_time")
	private LocalDateTime expiryTime;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	private boolean active;
	
	@Column(name="scan_count")
	private int scancount = 0;
	
	@Column(name="last_scanned_at")
	private LocalDateTime lastScannedAt;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public LocalDateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(LocalDateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getScancount() {
		return scancount;
	}

	public void setScancount(int scancount) {
		this.scancount = scancount;
	}

	public LocalDateTime getLastScannedAt() {
		return lastScannedAt;
	}

	public void setLastScannedAt(LocalDateTime lastScannedAt) {
		this.lastScannedAt = lastScannedAt;
	}
	
}
