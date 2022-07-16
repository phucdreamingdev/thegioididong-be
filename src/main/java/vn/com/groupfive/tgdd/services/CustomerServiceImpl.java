package vn.com.groupfive.tgdd.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.CategoryDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
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
		CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getLogo(),
				category.getLevel(), category.getParentName(), category.isStatus(), category.isParent(),
				category.getChildenLevel());
		return categoryDTO;
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