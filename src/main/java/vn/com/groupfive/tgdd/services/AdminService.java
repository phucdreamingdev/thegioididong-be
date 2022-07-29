package vn.com.groupfive.tgdd.services;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Promotion;

public interface AdminService {
	Category addCategory(CategoryRequest categoryRequest) throws CrudException;
	
	Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException;
	
	Promotion addPromotions(PromotionRequest promotionRequest) throws CrudException;
	
	Promotion updatePromotions(Long id, PromotionRequest promotionRequest) throws CrudException;
	
}
