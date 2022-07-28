package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Category;

public interface AdminService {
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;
	
	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;
	
	VersionColorItemDTO getVersionColorById(Long id);
	
	AdminAccount login(String username, String password);
	AdminAccount getAdminAccountByUsername(String username);
	
	List<AdminAccount> getAllAccount();
}
