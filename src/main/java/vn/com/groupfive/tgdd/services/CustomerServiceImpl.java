package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.CategoryDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

//	@Autowired
//	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

//	@Override
//	public List<ProductDTO> getAllProduct() {
//		List<Product> products = productRepository.findAll();
//		List<ProductDTO> productDTOs = new ArrayList<>();
//		for (Product product : products) {
//			productDTOs.add(productToProductDTO(product));
//		}
//		return productDTOs;
//	}
//
//	@Override
//	public ProductDTO productToProductDTO(Product product) {
//		ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getCategory().getName());
//		return productDTO;
//	}

	@Override
	public List<CategoryDTO> getAllCategoryByLevel(int level) {
		List<Category> categories = categoryRepository.getByLevel(level);
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for (Category category : categories) {
			categoryDTOs.add(categoryToCategoryDTO(category));
		}
		return categoryDTOs;
	}

	@Override 
	public CategoryDTO categoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName() , 
				category.getLogo(), category.getLevel(), category.getParentName(), 
				category.isStatus(), category.isParent(), category.getChildenLevel());
		return categoryDTO;
	}

}