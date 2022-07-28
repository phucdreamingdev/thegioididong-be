package vn.com.groupfive.tgdd.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	CategoryMapper categoryMapper;

	@PostMapping("/create-new-category")
	public CategorySlimDTO createCategory(@RequestBody CategoryRequest category) throws CrudException  {
		return categoryMapper.categoryToCategorySlimDto(adminService.addCategory(category));
	}
	
	@PutMapping("/update-category/{id}")
	public CategorySlimDTO updateCategory(@PathVariable Long id, 
											@RequestBody CategoryRequest category) throws CrudException {
		return categoryMapper.categoryToCategorySlimDto(adminService.updateCategory(id, category));
	}
	
	@GetMapping("/get-version-color-by-id")
    	public VersionColorItemDTO getVersionColorById(Long id) {
        	return adminService.getVersionColorById(id);
    	}

}
