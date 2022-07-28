package vn.com.groupfive.tgdd.controllers;

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

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.entities.VerificationResult;
import vn.com.groupfive.tgdd.services.CustomerService;
import vn.com.groupfive.tgdd.services.PhoneverificationService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	PhoneverificationService phonesmsservice;

	@GetMapping("/get-all-category-by-level/{level}")
	List<CategorySlimDTO> getCategoryByLevel(@PathVariable("level") int level) {
		return customerService.getAllCategoryByLevel(level);
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
	ProductSlimDTO getProductSlimById(@PathVariable("id") Long productId) {
		return customerService.getProductSlimDtoById(productId);
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
	public ResponseEntity<Object> verifyotp(@RequestParam("phone") String phone, @RequestParam("otp") String otp, HttpSession session) {
		VerificationResult result = phonesmsservice.checkverification(phone, otp);
		if (result.isValid()) {
			
			MemberDTO member = customerService.getMemberDTOByPhone(phone);
			if(member == null) {
				//
			}
			session.setAttribute("member",member);
			System.out.println("Your number is verified");		
			return new ResponseEntity<>(member,HttpStatus.OK);
		}
		String msg = "Something wrong / Incorrect OTP";
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get-branchs-in-stock")
	List<BranchSlimResponeDTO> getBranchInStock(@RequestParam("versionColorid") Long versionColorid,
			@RequestParam("provinceId") Long provinceId) {
		return customerService.getBranchInStock(versionColorid, provinceId);
	}
}
