package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> , CrudRepository<Product, Long>{
	
	@Query("SELECT p FROM Product p WHERE p.id = :id")
	Product getById(@Param("id") Long id);
	
	@Query("SELECT p FROM Product p WHERE p.category.id = :id")
	List<Product> findByCategoryId(@Param("id") Long categoryId);
	
	List<Product> findAllByIsActived(boolean isActived); 
	
}
