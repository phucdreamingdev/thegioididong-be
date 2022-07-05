package vn.com.groupfive.tgdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	CategoryRepository categoryRepository;

	public String getAllCategory() {
		List<Category> list = categoryRepository.findAll();
		String out="";
		for (Category category : list) {
			out+= category.getName() + "\n";
		}
	
		return out;
	}
	
}
