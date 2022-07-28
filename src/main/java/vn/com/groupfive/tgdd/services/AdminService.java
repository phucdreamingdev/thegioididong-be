package vn.com.groupfive.tgdd.services;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;

public interface AdminService {
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;
	
	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;
	
	VersionColorItemDTO getVersionColorById(Long id);
}
