package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.payload.mapper.VersionMapper;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;
import vn.com.groupfive.tgdd.repositories.VersionRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	VersionColorRepository versionColorRepository;

	@Autowired
	VersionRepository versionRepository;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	ProductMapper productMapper;

	@Autowired
	VersionMapper versionMapper;

	@Override
	public List<CategorySlimDTO> getAllCategoryByLevel(int level) {
		return categoryMapper.categoriesToCategorySlimDtos(categoryRepository.getByLevel(level));
	}

	@Override
	public List<ProductListItemDTO> getAllProduct() {
		List<VersionColor> versionColors = versionColorRepository.getAllByDefault();
		List<ProductListItemDTO> productDTOs = new ArrayList<>();
		for (VersionColor versionColor : versionColors) {
			productDTOs.add(versionColorToProductDTO(versionColor));
		}
		return productDTOs;
	}

	@Override
	public ProductListItemDTO versionColorToProductDTO(VersionColor versionColor) {

		return new ProductListItemDTO(versionColor.getId(), versionColor.getName(), versionColor.getAvartar(),
				versionColor.getVersion().getProduct().getCategory().getName(),
				versionColor.getVersion().getProduct().getManufacturer().getName(), versionColor.getPrice());
	}

	@Override
	public ProductSlimDTO getProductSlimDtoById(Long id) {
		return productMapper.productToProductSlimDTO(productRepository.getById(id));
	}

	@Override
	public List<ProductListItemDTO> getAllProductByCategoryId(Long categoryId) {
		List<VersionColor> versionColors = versionColorRepository.getAllByDefaultAndCategoryId(categoryId);
		List<ProductListItemDTO> productDTOs = new ArrayList<>();
		for (VersionColor versionColor : versionColors) {
			productDTOs.add(versionColorToProductDTO(versionColor));
		}
		return productDTOs;
	}

	@Override
	public List<VersionColorItemDTO> getAllVersionColorItemDTOs() {
		return versionMapper.versionColorsToVersionColorItemDtos(versionColorRepository.getAllByDefault());
	}

	@Override
	public List<VersionColorItemDTO> getAllVersionColorItemDTOsByCategoryId(Long id) {
		return versionMapper.versionColorsToVersionColorItemDtos(versionColorRepository.getAllByDefaultAndCategoryId(id));

	}

}