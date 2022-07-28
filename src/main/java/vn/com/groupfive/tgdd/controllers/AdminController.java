package vn.com.groupfive.tgdd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.com.groupfive.tgdd.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/get-all-category")
    public String getAllCategory() {
        return adminService.getAllCategory();
    }
	
	@GetMapping("/get-all-promotion")
	public String getAllPromotion() {
		return adminService.gettAllPromotion();
	}
	
	@PostMapping("/create-promotion")
	public ResponseEntity
}
