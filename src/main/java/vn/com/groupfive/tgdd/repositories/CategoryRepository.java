package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.com.groupfive.tgdd.payload.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query("SELECT c FROM Category c WHERE c.level = :level")
	List<Category> getByLevel(@Param("level") int level);
}	
