package vn.com.groupfive.tgdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.PromotionRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PromotionRepository promotionRepository;

	public String getAllCategory() {
		List<Category> list = categoryRepository.findAll();
		String out="";
		for (Category category : list) {
			out+= category.getName() + "\n";
		}
	
		return out;
	}
	
}
