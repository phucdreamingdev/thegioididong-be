package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;

public interface AdminService {
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;
	
	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;
	
	VersionColorItemDTO getVersionColorById(Long id);
	
	AdminAccount login(String username, String password);
	AdminAccount getAdminAccountByUsername(String username);
	
	List<AdminAccount> getAllAccount();
	
	List<MemberOrderDTO> getAllMemberOrders();
	
	List<MemberOrderDTO> getAllMemberOrdersByBranch(Long branchId);
	
	List<OrderDetailDTO> getAllOrderDetailsByMemberOrderId(Long memberOrderId);
	
	List<MemberOrderDTO> getAllMemberOrdersByPhoneNumber(String phoneNumber);
}
