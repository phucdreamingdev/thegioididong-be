package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.PromotionDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.PromotionMapper;
import vn.com.groupfive.tgdd.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	CategoryMapper categoryMapper;
	
	@Autowired
	PromotionMapper promotioMapper;

	@PostMapping("/create-new-category")
	public CategorySlimDTO createCategory(@RequestBody CategoryRequest category) throws CrudException {
		return categoryMapper.categoryToCategorySlimDto(adminService.addCategory(category));
	}

	@PutMapping("/update-category/{id}")
	public CategorySlimDTO updateCategory(@PathVariable Long id, @RequestBody CategoryRequest category)
			throws CrudException {
		return categoryMapper.categoryToCategorySlimDto(adminService.updateCategory(id, category));
	}
	
	@GetMapping("/get-all-category-by-level/{level}")
	List<CategorySlimDTO> getCategoryByLevel(@PathVariable("level") int level) {
		return adminService.getAllCategoryByLevel(level);
	}

	@PostMapping("/create-new-promotion")
	public PromotionDTO createPromotion(
			@RequestBody PromotionRequest promotion) throws CrudException {
		return promotioMapper.promotionToPromotionDto(adminService.addPromotions(promotion));
	}
	
	@PutMapping("/update-promotion/{id}")
	public PromotionDTO updatePromotion(@PathVariable Long id,
			@RequestBody PromotionRequest promotion) throws CrudException {
		return promotioMapper.promotionToPromotionDto(adminService.updatePromotions(id,promotion));
	}
	
	@GetMapping("/get-version-color-by-id")
	public VersionColorItemDTO getVersionColorById(Long id) {
		return adminService.getVersionColorById(id);
	}
	
	@GetMapping("/get-all-order")
	public List<MemberOrderDTO> getAllOrders() {
		return adminService.getAllMemberOrders();
	}
	
	
	@GetMapping("/get-all-order-by-branchid")
	public List<MemberOrderDTO> getAllOrdersByBranchId(Long branchId) {
		return adminService.getAllMemberOrdersByBranch(branchId);
	}
	
	@GetMapping("/get-all-orderdetail-by-memberorderid")
	public List<OrderDetailDTO> getAllOrderDetailByMemberOrderId(Long memberOrderId) {
		return adminService.getAllOrderDetailsByMemberOrderId(memberOrderId);
	}
	
	@GetMapping("/search-order-by-phone")
	public List<MemberOrderDTO> searchOrdersByPhone(String phoneNumber) {
		return adminService.getAllMemberOrdersByPhoneNumber(phoneNumber);
	}
	
	@GetMapping("/get-member-by-id")
	public MemberDTO findMemberById(@RequestParam(name = "id") Long id) {
		return adminService.findMemberById(id);
	}
	
	@GetMapping("/get-version-color-by-name")
	public List<VersionColorSlimDTO> findByName(@RequestParam String name){
		return adminService.searchVersionColorByName(name);
	}
}
