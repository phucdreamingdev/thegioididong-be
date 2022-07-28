package vn.com.groupfive.tgdd.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.Cart;
import vn.com.groupfive.tgdd.payload.dto.CartProductDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.ItemCartDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.BranchStock;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.mapper.BranchMapper;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.payload.mapper.VersionMapper;
import vn.com.groupfive.tgdd.repositories.BranchStockRepository;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.DistrictRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;
import vn.com.groupfive.tgdd.repositories.ProvinceRepository;
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
	
	@Autowired
	BranchStockRepository branchStockRepository;
	
	@Autowired
	BranchMapper branchMapper;
	
	@Autowired
	ProvinceRepository provinceRepo;
	
	@Autowired
	DistrictRepository districtRepo;

	private Cart cart = new Cart();
	
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
	
	
	@Override
	public List<BranchSlimResponeDTO> getBranchInStock(Long versionColorid, Long provinceId) {
		return branchMapper.branchsToBranchSlimResponeDtos(branchStockRepository.getBranchInStock(versionColorid, provinceId));
	}
	
	@Override
	public String addToCart(Long versionColorId, int quantity, Long provinceId) {
		VersionColor versionColor = versionColorRepository.getVersionColorById(versionColorId);
		if (versionColor == null)
			return "Not Found VersionColor Id";
		List<Branch> listBranch = branchStockRepository.getBranchInStock(versionColorId, versionColorId);
		int totalInStock = 0;
		if (listBranch != null && listBranch.size() > 0) {
			for (Branch branch : listBranch) {
				Set<BranchStock> branchStocks = branch.getBranchStocks();
				if (branchStocks != null && branchStocks.size() > 0) {
					for (BranchStock branchStock : branchStocks) {
						if (branchStock.getVersionColor().getId().equals(versionColorId)
								&& branchStock.getStock() > 0) {
							totalInStock += branchStock.getStock();
						}
					}
				}
			}
			totalInStock -= quantity;
			if (totalInStock > 0) {
				ItemCartDTO product = new ItemCartDTO(versionColor.getId(), versionColor.getName(),
						versionColor.getAvartar(), versionColor.getVersion().getProduct().getCategory().getName(),
						versionColor.getVersion().getProduct().getManufacturer().getName(),
						versionColor.getVersion().getName(), versionColor.getColor().getName(),
						versionColor.getPrice() + "");
				if (product != null) {
					cart.addProduct(product, quantity);
					return "Add To Cart Successful.";
				} else
					return "Add To Cart Failed! Not Found Product";
			}
		}
		return "Not Enough Product In Stock";
	}

	@Override
	public boolean removeFromCart(Long versionColorId) {
		return cart.removeProduct(versionColorId);
	}

	@Override
	public boolean editQuantityProductCart(Long versionColorId, int quantity) {
		return cart.editQuantity(versionColorId, quantity);
	}

	@Override
	public boolean changeVersionColorProductCartById(Long versionColorId, Long nVersionColorId) {
		VersionColor versionColor = versionColorRepository.getVersionColorById(nVersionColorId);
		if (versionColor == null)
			return false;
		ItemCartDTO product = new ItemCartDTO(versionColor.getId(), versionColor.getName(), versionColor.getAvartar(),
				versionColor.getVersion().getProduct().getCategory().getName(),
				versionColor.getVersion().getProduct().getManufacturer().getName(), versionColor.getVersion().getName(),
				versionColor.getColor().getName(), versionColor.getPrice() + "");
		return cart.changeVersionColorOfProduct(versionColorId, product);
	}

	@Override
	public List<CartProductDTO> getAllCartProduct(Long provineId) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		List<CartProductDTO> list = cart.getCartProducts();
		if (list != null && list.size() > 0) {
			List<CartProductDTO> listViewCurrency = new ArrayList<>();
			for (CartProductDTO cartProd : list) {
				List<Branch> listBranch = branchStockRepository.getBranchInStock(cartProd.getProduct().getId(), provineId);
				int totalInStock = 0;
				if (listBranch != null && listBranch.size() > 0) {
					for (Branch branch : listBranch) {
						Set<BranchStock> branchStocks = branch.getBranchStocks();
						if (branchStocks != null && branchStocks.size() > 0) {
							for (BranchStock branchStock : branchStocks) {
								if (branchStock.getVersionColor().getId().equals(cartProd.getProduct().getId())
										&& branchStock.getStock() > 0) {
									totalInStock += branchStock.getStock();
								}
							}
						}
					}
					System.out.println(totalInStock);
					totalInStock -= cartProd.getQuantity();
					if(totalInStock > 0) {
						ItemCartDTO product = new ItemCartDTO(cartProd.getProduct().getId(), cartProd.getProduct().getName(),
								cartProd.getProduct().getImg(), cartProd.getProduct().getCategoryName(),
								cartProd.getProduct().getBrand(), cartProd.getProduct().getVersionName(),
								cartProd.getProduct().getColorName(),
								currencyVN.format(Float.parseFloat(cartProd.getProduct().getPrice())));
						CartProductDTO nProd = new CartProductDTO(cartProd.getQuantity(), product);
						nProd.setTotalPrice(currencyVN.format(Float.parseFloat(cartProd.getTotalPrice())));
						listViewCurrency.add(nProd);
					}
				}
			}
			return listViewCurrency;
		}
		return null;
	}
	
	

	public Cart getCart() {
		return cart;
	}

	@Override
	public List<ProvinceDTO> getAllProvince() {
		return branchMapper.provincesToProvinceDtos(provinceRepo.findAll());
	}

	@Override
	public List<DistrictDTO> getAllDistrictByProvinceId(Long provinceId) {
		return branchMapper.districtsToDistrictDtos(districtRepo.getAllDistrictByProvinceId(provinceId));
	}

}
