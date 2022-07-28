package vn.com.groupfive.tgdd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.CategoryDoesNotExistException;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.PromotionRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PromotionRepository promotionRepository;
	
	private Category setCategory(CategoryRequest categoryRequest) {
		Category category = new Category();
		category.setName(categoryRequest.getName());
		category.setLogo(categoryRequest.getLogo());
		category.setLevel(categoryRequest.getLevel());
		category.setParentName(categoryRequest.getParentName());
		category.setStatus(categoryRequest.isStatus());
		category.setParent(categoryRequest.isParent());
		category.setChildrenLevel(categoryRequest.getChildrenLevel());
		return category;
	}
	
	
	
	@Override
	public Category addCategory(CategoryRequest categoryRequest) throws CrudException {
		if(categoryRepository.existsByName(categoryRequest.getName())) {
			throw new CategoryAlreadyExistedException();
		}
		Category category = setCategory(categoryRequest);
		return categoryRepository.save(category);
	}
	

	
	private Category updateCategory(Category category, CategoryRequest categoryRequest) {
		category.setName(categoryRequest.getName());
		category.setLogo(categoryRequest.getLogo());
		category.setLevel(categoryRequest.getLevel());
		category.setParentName(categoryRequest.getParentName());
		category.setStatus(categoryRequest.isStatus());
		category.setParent(categoryRequest.isParent());
		category.setChildrenLevel(categoryRequest.getChildrenLevel());
		return category;
	}
	@Override
	public Category updateCategory(Long id,CategoryRequest categoryRequest) throws CrudException {
		if(!categoryRepository.existsById(id)) {
			throw new CategoryDoesNotExistException();
		}
		Category category = categoryRepository.getById(id);
		return categoryRepository.save(updateCategory(category, categoryRequest));
	}
	
	@Override
	public VersionColorItemDTO getVersionColorById(Long id) {
		return versionMapper.versionColorToVersionColorItemDto(versionColorRepository.getVersionColorById(id));
	}
	

	
}
