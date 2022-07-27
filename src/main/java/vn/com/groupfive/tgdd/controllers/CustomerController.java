package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
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
}
