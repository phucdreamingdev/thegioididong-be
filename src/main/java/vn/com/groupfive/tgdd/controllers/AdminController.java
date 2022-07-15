package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.OrderDetail;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
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
	
	@GetMapping("/get-all-member")
	public List<Member> getAllMember(){
		return adminService.getAllMember();
	}
	
	@GetMapping("/{id}")
	public Member findMemberById(@PathVariable Long id) {
		return adminService.findMemberById(id);	
	}
	
	@GetMapping("/get-order-list")
	public List<OrderDetail> getAllOrder(){
		return adminService.getAllOrder();
	}
	
	@GetMapping("/{id}")
	public Promotion findPromotionById(@PathVariable Long id) {
		return adminService.findPromotionById(id);
	}
	
	@PutMapping("/{id}")
	public Promotion updatePromotion(@PathVariable Long id, @RequestBody Promotion promotion) {
		return adminService.updatePromotion(id, promotion);
	}
	
	@DeleteMapping("/{id}")
	public void deletePromotion(@PathVariable Long id) {
		adminService.deletePromotion(id);
	}
}
