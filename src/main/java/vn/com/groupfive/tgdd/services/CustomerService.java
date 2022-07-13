package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.payload.dto.CategoryDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Product;

public interface CustomerService {
//	List<ProductDTO> getAllProduct();
//
//	ProductDTO productToProductDTO(Product product);

	List<CategoryDTO> getAllCategoryByLevel(int level);

	CategoryDTO categoryToCategoryDTO(Category category);
}
