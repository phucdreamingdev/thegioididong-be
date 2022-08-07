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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.dto.PromotionDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.TransactionDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.dto.WardSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.request.BranchCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProductCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.TransactionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VietnamAddressRequest;
import vn.com.groupfive.tgdd.payload.mapper.BranchMapper;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.payload.mapper.PromotionMapper;
import vn.com.groupfive.tgdd.payload.mapper.TransactionMapper;
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
	
	@Autowired
	BranchMapper branchMapper;
	
	@Autowired
	ProductMapper productMapper;
	
	@Autowired
	TransactionMapper transactionMapper;

	//CATEGORY FUNCTION
	@PostMapping("/create-new-category")
	public CategorySlimDTO createCategory(@RequestBody CategoryRequest category) throws CrudException {
		return categoryMapper.categoryToCategorySlimDto(adminService.addCategory(category));
	}

	@PutMapping("/update-category/{id}")
	public CategorySlimDTO updateCategory(@PathVariable Long id, @RequestBody CategoryRequest category)
			throws CrudException {
		return categoryMapper.categoryToCategorySlimDto(adminService.updateCategory(id, category));
	}
	
	@GetMapping("/get-category-select-item-by-level")
	public @ResponseBody String getCategoryByLevelItem(@RequestParam int level) {
		String json = null;
		List<Object[]> list = adminService.getCategorySelectItemByLevel(level);
		try {
			json = new ObjectMapper().writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	@GetMapping("/get-all-category-by-level/{level}")
	List<CategorySlimDTO> getCategoryByLevel(@PathVariable("level") int level) {
		return adminService.getAllCategoryByLevel(level);
	}

	
	//PROMOTION FUNCTION
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
	
	@GetMapping("/get-all-promotion")
	public List<PromotionDTO> getAllPromotion(){
		return adminService.getAllPromotion();
	}
	//TRANSACTION FUNCTION

	@PostMapping("/create-new-transaction")
	public TransactionDTO addTransaction(@RequestBody TransactionRequest transaction) throws CrudException {
		return transactionMapper.transactionToTransactionDto(adminService.addTransaction(transaction));
	}
	
	@PutMapping("/update-transaction/{id}")
	public TransactionDTO updateTransaction(@RequestBody TransactionRequest transaction) throws CrudException{
		return transactionMapper.transactionToTransactionDto(adminService.updateTransaction(transaction));
	}
	
	//PRODUCT FUNCTION
	@PostMapping("/create-new-product")
	public ProductDTO createProduct(
			@RequestBody ProductCreateRequest productCreateRequest) throws CrudException {
		return productMapper.productToProductDto(adminService.createProduct(productCreateRequest));
	}
	
//	@PostMapping("/create-new-version")
//	public ProductDTO createVersion(
//			@RequestBody VersionRequest versionRequest) throws CrudException {
//		return productMapper.productToProductDto(adminService.createProduct(productCreateRequest));
//	}
	
//	@GetMapping("/get-version-color-by-id")
//	public VersionColorItemDTO getVersionColorById(Long id) {
//		return adminService.getVersionColorById(id);
//	}
	
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
	
	@GetMapping("/get-all-member")
	public List<MemberDTO> getAllMember() {
		return adminService.getAllMember();
	}
	
//	@GetMapping("/get-version-color-by-name")
//	public List<VersionColorSlimDTO> findByName(@RequestParam String name){
//		return adminService.searchVersionColorByName(name);
//	}
	

	@PostMapping("/create-branch")
	public BranchSlimResponeDTO createBranch(@RequestBody BranchCreateRequest branch)throws CrudException{		
		return branchMapper.branchToBranchSlimResponeDto(adminService.addBranch(branch));
	}
	@PutMapping("/update-branch/{id}")
	public BranchSlimResponeDTO updateBranch(@PathVariable Long id, @RequestBody BranchCreateRequest branch)throws CrudException{		
		return branchMapper.branchToBranchSlimResponeDto(adminService.updateBranch(id,branch));
	}
	@GetMapping("/get-all-branch")
	public List<BranchSlimResponeDTO> getAllBranch() {
		return adminService.getAllBranches();
	}
//	@GetMapping("/search-branch")
//	public List<BranchSlimResponeDTO> searchBranch(String ward, String district, String province ) {
//		return adminService.getAllBranches();
//	}

	@GetMapping("/update-order")
	public boolean updateMemberOrderStatusByIdAndStatus(Long memberOrderId, String status) {
		return adminService.updateOrderStatusByMemberOrderIdAndStatus(memberOrderId, status);
	}
	
	@PostMapping("/viet-nam")
	public boolean vietNam(@RequestBody VietnamAddressRequest vietnamAddressRequest) {
		return adminService.addVietNamAddress(vietnamAddressRequest);
	}
	
	
	/*LONG*/
	@GetMapping("/get-all-province")
	public List<ProvinceDTO> getAllProvince() {
		return adminService.getAllProvince();
	}
	
	@GetMapping("/get-all-district-by-province-id/{id}")
	public List<DistrictSlimDTO> getAllDistrictByProvinceId(@PathVariable Long id) {
		return adminService.getDistrictByProvinceId(id);
	}
	
	@GetMapping("/get-all-ward-by-district-id/{id}")
	public List<WardSlimDTO> getAllWardByDistrictId(@PathVariable Long id) {
		return adminService.getWardByDistrictId(id);
	}

}
