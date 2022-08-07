package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.dto.PromotionDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.TransactionDTO;
import vn.com.groupfive.tgdd.payload.dto.WardSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.request.BranchCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ColorRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProductCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.TransactionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VersionColorRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VersionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VietnamAddressRequest;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Color;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
import vn.com.groupfive.tgdd.payload.entities.Transaction;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

public interface AdminService {
	/*------------------------------CATEGORY-------------------------------------------*/
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;

	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;

	List<CategorySlimDTO> getAllCategoryByLevel(int level);

	List<Object[]> getCategorySelectItemByLevel(int level);

	/*------------------------------TRANSACTION-------------------------------------------*/
	Transaction addTransaction(TransactionRequest transactionRequest) throws CrudException;

	Transaction updateTransaction(Long id ) throws CrudException;
	
	List<TransactionDTO> getAllTransaction();
	/*------------------------------PRODUCT-------------------------------------------*/
	Product createProduct(ProductCreateRequest productCreateRequest) throws CrudException;

	Version createVersion(VersionRequest versionRequest) throws CrudException;

	VersionColor createVersionColor(VersionColorRequest versionColorRequest) throws CrudException;

	Color createColor(ColorRequest color) throws CrudException;
	
	List<ProductDTO> getAllProduct();

//	VersionColorItemDTO getVersionColorById(Long id);

	/*------------------------------PROMOTION-------------------------------------------*/
	Promotion addPromotions(PromotionRequest promotionRequest) throws CrudException;

	Promotion updatePromotions(Long id, PromotionRequest promotionRequest) throws CrudException;

	List<PromotionDTO> getAllPromotion();

	AdminAccount login(String username, String password);

	AdminAccount getAdminAccountByUsername(String username);

	List<AdminAccount> getAllAccount();

	/*------------------------------MEMBER-------------------------------------------*/

	List<MemberOrderDTO> getAllMemberOrders();

	List<MemberOrderDTO> getAllMemberOrdersByBranch(Long branchId);

	List<OrderDetailDTO> getAllOrderDetailsByMemberOrderId(Long memberOrderId);

	List<MemberOrderDTO> getAllMemberOrdersByPhoneNumber(String phoneNumber);

	MemberDTO findMemberById(Long id);

	List<MemberDTO> getAllMember();

//	List<VersionColorSlimDTO> searchVersionColorByName(String name);

	boolean updateOrderStatusByMemberOrderIdAndStatus(Long memberOrderId, String status);

	/*------------------------------BRANCH-------------------------------------------*/
	Branch addBranch(BranchCreateRequest branchRequest) throws CrudException;

	Branch updateBranch(Long id, BranchCreateRequest branchRequest) throws CrudException;

	List<BranchSlimResponeDTO> getAllBranches();

	
	boolean addVietNamAddress (VietnamAddressRequest vietnamAddressRequest);
	
	/*------------------------------LONG-------------------------------------------*/
	
	List<ProvinceDTO> getAllProvince();
	
	List<DistrictSlimDTO> getDistrictByProvinceId(Long id);
	
	List<WardSlimDTO> getWardByDistrictId(Long id);



}
