package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/get-all-category-by-level/{level}")
	List<CategorySlimDTO> getCategoryByLevel(@PathVariable("level") int level) {
		return customerService.getAllCategoryByLevel(level);
	}

	@GetMapping("/get-all-products")
	List<ProductListItemDTO> getListProduct() {
		return customerService.getAllProduct();
	}
	
	@GetMapping("/get-branchs-in-stock")
	List<BranchSlimResponeDTO> getBranchInStock(@RequestParam("versionColorid")Long versionColorid, @RequestParam("provinceId") Long provinceId){
		return customerService.getBranchInStock(versionColorid, provinceId);
	}
}
