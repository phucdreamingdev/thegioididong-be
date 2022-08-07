package vn.com.groupfive.tgdd.controllers;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CartProductDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.ImageGroupVersionDTO;
import vn.com.groupfive.tgdd.payload.dto.ManufacturerDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.entities.VerificationResult;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.services.CustomerService;
import vn.com.groupfive.tgdd.services.PhoneverificationService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	PhoneverificationService phonesmsservice;
	
	@Autowired
	MemberMapper memberMapper;
	
	//MANUFACTURER FUNTION
	
	@GetMapping("/get-manufacturers-by-category")
	List<ManufacturerDTO> getManufacturersByCategory(@RequestParam Long categoryId){
		return customerService.getManufacturerByCategoryId(categoryId);
	}
	//GET ALL PRODUCT BY MANUFACTURER-ID
	@GetMapping("/get-all-product-by-manufacturer-id/{id}")
	public List<VersionColorItemDTO> getAllProductByManufacturerId(@PathVariable("id") Long id) {
		return customerService.getAllProductByManufacturerId(id);
	}
	

	@GetMapping("/get-all-category-by-level/{level}")
	List<CategorySlimDTO> getCategoryByLevel(@PathVariable("level") int level) {
		return customerService.getAllCategoryByLevelAndStatus(level, true);
	}

	@GetMapping("/get-all-products")
	List<ProductListItemDTO> getListProduct() {
		return customerService.getAllProduct();
	}
	
	@GetMapping("/get-all-products-new")
	List<VersionColorItemDTO> getListProductNew() {
		return customerService.getAllVersionColorItemDTOs();
	}
	
	
	@GetMapping("/get-all-products-by-category-id/{id}")
	List<ProductListItemDTO> getListProductByCategoryId(@PathVariable("id") Long id) {
		return customerService.getAllProductByCategoryId(id);
	}
	
	@GetMapping("/get-all-products-by-category-id-new/{id}")
	List<VersionColorItemDTO> getListProductByCategoryIdNew(@PathVariable("id") Long id) {
		return customerService.getAllVersionColorItemDTOsByCategoryId(id);
	}

	
	@GetMapping("/get-product-slim-by-id/{id}") 
	VersionColorItemDTO getProductSlimById(@PathVariable("id") Long productId) {
		return customerService.getVersionColorDefault(productId);
	}

	@PostMapping("/sendotp")
	public ResponseEntity<String> sendotp(@RequestParam("phone") String phone) {
		VerificationResult result = phonesmsservice.startVerification(phone);
		if (result.isValid()) {
			return new ResponseEntity<>("Otp Sent..", HttpStatus.OK);
		}
		return new ResponseEntity<>("Otp failed to sent..", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/verifyotp")
	public ResponseEntity<Object> verifyotp(@RequestParam("phone") String phone, @RequestParam("otp") String otp, HttpSession session) throws CrudException {
		VerificationResult result = phonesmsservice.checkverification(phone, otp);
		if (result.isValid()) {			
			MemberDTO member = customerService.getMemberDTOByPhone(phone);
			
			if(member == null) {
				member = memberMapper.memberToMemberDto(customerService.addNewMember(phone));
			}			
			String id = String.valueOf(member.getId());			
			System.out.println("Your number is verified");		
			return new ResponseEntity<>(id,HttpStatus.OK);
		}
		String msg = "Something wrong / Incorrect OTP";
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get-branchs-in-stock")
	List<BranchSlimResponeDTO> getBranchInStock(@RequestParam("versionColorid") Long versionColorid,
			@RequestParam("provinceId") Long provinceId) {
		return customerService.getBranchInStock(versionColorid, provinceId);
	}
	
	@GetMapping("/addToCart")
	public String addToCart(@RequestParam Long id, int quantity, Long provinceId) {
		return customerService.addToCart(id, quantity, provinceId);
	}

	@GetMapping("/viewCart")
	public List<CartProductDTO> viewCart(Long provinceId) {
		return customerService.getAllCartProduct(provinceId);
	}
	
	@GetMapping("/editQuantityCart")
	public boolean editCart(@RequestParam Long id, int quantity) {
		return customerService.editQuantityProductCart(id, quantity);
	}
	
	@GetMapping("/changeVersionColorCartProduct")
	public boolean editCart(@RequestParam Long versionColorId, Long nVersionColorId) {
		return customerService.changeVersionColorProductCartById(versionColorId, nVersionColorId);
	}

	@GetMapping("/removeCart")
	public boolean removeCart(@RequestParam Long id) {
		return customerService.removeFromCart(id);
	}
	
	@GetMapping("/get-all-provinces")
	public List<ProvinceDTO> getAllProvinces() {
		return customerService.getAllProvince();
	}
	
	@GetMapping("/get-all-district-by-provinceid")
	public List<DistrictDTO> getAllDistrict(@RequestParam Long provinceId) {
		return customerService.getAllDistrictByProvinceId(provinceId);
	}
	
	@GetMapping("/get-all-ward-by-districtId")
	public List<WardDTO> getAllWard(@RequestParam Long districtId) {
		return customerService.getAllWardByDistrictId(districtId);
	}
	
	@GetMapping("/checkoutCart")
	public String checkoutCart(@RequestParam String fullName, String phoneNumber, boolean gender, boolean deliveryAD, Long provinceId, Long districtId, Long wardId, String memberAddress, Date receiveDate) {
		return customerService.checkOutCart(fullName, phoneNumber, gender, deliveryAD, provinceId, districtId, wardId, memberAddress, receiveDate);
	}
	
	@GetMapping("/get-all-image-group-version")
	public ImageGroupVersionDTO getAllImageGroupVersion(@RequestParam Long groupId, Long versionId) {
		return customerService.getAllImageGroupVersion(groupId, versionId);
	}
}
