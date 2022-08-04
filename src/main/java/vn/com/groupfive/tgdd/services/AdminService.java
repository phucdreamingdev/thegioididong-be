package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorSlimDTO;
import vn.com.groupfive.tgdd.payload.dto.request.BranchCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProductCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Promotion;

public interface AdminService {
	/*------------------------------CATEGORY-------------------------------------------*/
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;
	
	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;
	
	List<CategorySlimDTO> getAllCategoryByLevel(int level);
	
	List<Object[]> getCategorySelectItemByLevel(int level);
	
	/*------------------------------PRODUCT-------------------------------------------*/
	Product createProduct(ProductCreateRequest productCreateRequest) throws CrudException;
	
	VersionColorItemDTO getVersionColorById(Long id);
	
	/*------------------------------PROMOTION-------------------------------------------*/
	Promotion addPromotions(PromotionRequest promotionRequest) throws CrudException;
	
	Promotion updatePromotions(Long id, PromotionRequest promotionRequest) throws CrudException;
	
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
	
	List<VersionColorSlimDTO> searchVersionColorByName(String name);
	
	boolean updateOrderStatusByMemberOrderIdAndStatus(Long memberOrderId, String status);
	
	/*------------------------------BRANCH-------------------------------------------*/
	Branch addBranch(BranchCreateRequest branchRequest) throws CrudException;
	
	Branch updateBranch(Long id,BranchCreateRequest branchRequest) throws CrudException;
	
	List<BranchSlimResponeDTO> getAllBranches();	

	
	
	


	
}
