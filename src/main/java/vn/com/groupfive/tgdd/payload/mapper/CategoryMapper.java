package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.entities.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
	CategorySlimDTO categoryToCategorySlimDto(Category category);
	List<CategorySlimDTO> categoriesToCategorySlimDtos(List<Category> categories);
}
