package vn.com.groupfive.tgdd.services;

import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.entities.Category;

public interface CategoryService {
	Category initCategory(CategoryRequest categoryRequest);
		
	

}
