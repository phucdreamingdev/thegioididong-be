package vn.com.groupfive.tgdd.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	VersionColorRepository versionColorRepository;
	
	@Autowired 
	CategoryMapper categoryMapper;


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
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return new ProductListItemDTO(
				versionColor.getId(), 
				versionColor.getName(), 
				versionColor.getAvartar(),
				versionColor.getVersion().getProduct().getCategory().getName(),
				versionColor.getVersion().getProduct().getManufacturer().getName(),
				currencyVN.format(versionColor.getPrice()));
	}

}