package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.payload.dto.CategoryDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

public interface CustomerService {
	 List<ProductListItemDTO> getAllProduct();
	
	 ProductListItemDTO versionColorToProductDTO(VersionColor versionColor);

	List<CategoryDTO> getAllCategoryByLevel(int level);

	CategoryDTO categoryToCategoryDTO(Category category);
}
