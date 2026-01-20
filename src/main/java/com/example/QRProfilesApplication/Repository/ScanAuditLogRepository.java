package com.example.QRProfilesApplication.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.QRProfilesApplication.Entity.ScanAuditLog;

@Repository
public interface ScanAuditLogRepository extends JpaRepository<ScanAuditLog, Long>{

//	@Query("Select u from ScanAuditLog u where ")
	List<ScanAuditLog> findTop20ByAuditTokenOrderByScannedAtTimeDesc(String token);
	
}
