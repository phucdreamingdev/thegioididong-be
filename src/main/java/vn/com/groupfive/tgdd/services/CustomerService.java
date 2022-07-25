package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

public interface CustomerService {
	List<ProductListItemDTO> getAllProduct();

	ProductListItemDTO versionColorToProductDTO(VersionColor versionColor);

	List<CategorySlimDTO> getAllCategoryByLevel(int level);
}
