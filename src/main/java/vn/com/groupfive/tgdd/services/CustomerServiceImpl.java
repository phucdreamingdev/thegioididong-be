package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.mapper.BranchMapper;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.payload.mapper.VersionMapper;
import vn.com.groupfive.tgdd.repositories.BranchStockRepository;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.MemberRepository;
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
	MemberRepository memberRepository;
	
	@Autowired
	BranchStockRepository branchStockRepository;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	ProductMapper productMapper;

	@Autowired
	VersionMapper versionMapper;
	
	@Autowired
	BranchMapper branchMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	
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
	public List<MemberDTO> getAllMemberDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO getMemberDTOByPhone(String phone) {
		
		return memberMapper.memberToMemberDto(memberRepository.getByPhone(phone));
	}



}