package vn.com.groupfive.tgdd.services;

import java.util.Date;
import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CartProductDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.entities.Member;
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

	List<MemberDTO> getAllMemberDTO();

	MemberDTO getMemberDTOByPhone(String phone);
	
	Member addNewMember(String phone) throws CrudException;

	String addToCart(Long versionColorId, int quantity, Long provinceId);

	boolean removeFromCart(Long versionColorId);

	boolean editQuantityProductCart(Long versionColorId, int quantity);

	boolean changeVersionColorProductCartById(Long versionColorId, Long nVersionColorId);

	List<CartProductDTO> getAllCartProduct(Long provineId);

	List<ProvinceDTO> getAllProvince();

	List<DistrictDTO> getAllDistrictByProvinceId(Long provinceId);
	
	List<WardDTO> getAllWardByDistrictId(Long districtId);
	
	String checkOutCart(String fullName, String phoneNumber, boolean deliveryAD, Long provinceId, Long districtId, Long wardId, String addressDetail, Date receiveDate);

}
