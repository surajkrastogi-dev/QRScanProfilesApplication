package com.example.QRProfilesApplication.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="scan_audit_log",schema="QRProfileApp")
public class ScanAuditLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="audit_id")
	private long auditId;
	
	@Column(name="audit_token")
	private String auditToken;
	
	@Column(name="ip_address")
	private String ipAddress;
	
	@Column(name="user_agent")
	private String userAgent;
	
	@Column(name="scanned_at_time")
	private LocalDateTime scannedAtTime;

	public long getAuditId() {
		return auditId;
	}

	public void setAuditId(long auditId) {
		this.auditId = auditId;
	}

	public String getAuditToken() {
		return auditToken;
	}

	public void setAuditToken(String auditToken) {
		this.auditToken = auditToken;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public LocalDateTime getScannedAtTime() {
		return scannedAtTime;
	}

	public void setScannedAtTime(LocalDateTime scannedAtTime) {
		this.scannedAtTime = scannedAtTime;
	}
	
}
