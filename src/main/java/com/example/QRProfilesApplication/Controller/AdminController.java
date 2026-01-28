package com.example.QRProfilesApplication.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.QRProfilesApplication.Config.ProfileUrlConfig;
import com.example.QRProfilesApplication.Config.TokenGeneration;
import com.example.QRProfilesApplication.Entity.UserDetails;
import com.example.QRProfilesApplication.Repository.ScanAuditLogRepository;
import com.example.QRProfilesApplication.Repository.UserRepository;
import com.example.QRProfilesApplication.Service.QrCodeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

	private final UserRepository repo;
	private final ScanAuditLogRepository auditRepo;
	private final ProfileUrlConfig baseUrlConfig;
	private final QrCodeService qrCodeService;
	private final TokenGeneration tokenService;

	    @GetMapping("/dashboard")
	    public String dashboard(@RequestParam(required = false,name="q") String q, Model model) {

	        List<UserDetails> list = repo.findAll();

	        // simple search (in-memory)
	        if (q != null && !q.isBlank()) {
	            String query = q.toLowerCase();
	            list = list.stream()
	                    .filter(x ->
	                            (x.getUserToken() != null && x.getUserToken().toLowerCase().contains(query)) ||
	                            (x.getUserName() != null && x.getUserName().toLowerCase().contains(query)) ||
	                            (x.getUserEmail() != null && x.getUserEmail().toLowerCase().contains(query)) ||
	                            (x.getMobile() != null && x.getMobile().toLowerCase().contains(query))
	                    )
	                    .toList();
	        }

	        model.addAttribute("records", list);
	        model.addAttribute("baseUrl", baseUrlConfig.getBaseUrl());
	        model.addAttribute("q", q);

	        return "admin-dashboard";
	    }

	    @GetMapping("/details/{id}")
	    public String details(@PathVariable("id") Long id, Model model) throws Exception {

	        UserDetails user = repo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Not found"));

	        String url = baseUrlConfig.generateBaseUrl(user.getUserToken());
	        String qrBase64 = qrCodeService.generateQrBase64(url, 250, 250);

	        model.addAttribute("user", user);
	        model.addAttribute("profileUrl", url);
	        model.addAttribute("qrBase64", qrBase64);
	        model.addAttribute("logs", auditRepo.findTop20ByAuditTokenOrderByScannedAtTimeDesc(user.getUserToken()));

	        return "admin-details";
	    }

	    @PostMapping("/toggle/{id}")
	    public String toggle(@PathVariable("id") Long id) {
	        UserDetails user = repo.findById(id).orElseThrow();
	        user.setActive(!user.isActive());
	        repo.save(user);
	        return "redirect:/admin/dashboard";
	    }

	    @PostMapping("/delete/{id}")
	    public String delete(@PathVariable("id") Long id) {
	        repo.deleteById(id);
	        return "redirect:/admin/dashboard";
	    }

	    @PostMapping("/regenerate/{id}")
	    public String regenerate(@PathVariable("id") Long id) {
	        UserDetails user = repo.findById(id).orElseThrow();

	        String newToken = tokenService.generateToken();
	        user.setUserToken(newToken);
	        user.setUsed(false);
	        user.setScancount(0);
	        user.setLastScannedAt(null);

	        repo.save(user);
	        return "redirect:/admin/details/" + id;
	    }

	
}
