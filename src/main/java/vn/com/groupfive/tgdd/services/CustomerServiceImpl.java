package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.CategoryDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<ProductDTO> getAllProduct() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : products) {
			productDTOs.add(productToProductDTO(product));
		}
		return productDTOs;
	}

	@Override
	public ProductDTO productToProductDTO(Product product) {
		ProductDTO productDTO = new ProductDTO(product.getId(), product.getName(), product.getCategory().getName());
		return productDTO;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for (Category category : categories) {
			categoryDTOs.add(categoryToCategoryDTO(category));
		}
		return categoryDTOs;
	}

	@Override
	public CategoryDTO categoryToCategoryDTO(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getLogo());
		return categoryDTO;
	}

}