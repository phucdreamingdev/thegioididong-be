package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;


public interface CustomerService {
	
	List<ProductListItemDTO> getAllProduct();

	List<ProductListItemDTO> getAllProductByCategoryId(Long categoryId);

	ProductListItemDTO versionColorToProductDTO(VersionColor versionColor);

	List<CategorySlimDTO> getAllCategoryByLevel(int level);

	ProductSlimDTO getProductSlimDtoById(Long id);

	List<VersionColorItemDTO> getAllVersionColorItemDTOs();

	List<VersionColorItemDTO> getAllVersionColorItemDTOsByCategoryId(Long id);

	List<BranchSlimResponeDTO> getBranchInStock(Long versionColorid, Long provinceId);

}
