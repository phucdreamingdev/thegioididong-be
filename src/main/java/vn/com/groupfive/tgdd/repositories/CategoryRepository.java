package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.com.groupfive.tgdd.payload.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query("SELECT c FROM Category c WHERE c.level = :level and c.status = true")
	List<Category> getByLevel(@Param("level") int level);
	
	//JPQL Query boolean result https://stackoverflow.com/questions/12051563/jpql-statement-returning-boolean-value
	@Query("SELECT CASE WHEN (count(c) > 0) THEN true ELSE false END FROM Category c WHERE c.name = :name")
	boolean existsByName(@Param("name") String name);
	
}	
