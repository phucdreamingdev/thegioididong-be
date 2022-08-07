package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Repository
@Transactional
public interface VersionColorRepository extends JpaRepository<VersionColor, Long>{
	
	@Query("SELECT vc FROM VersionColor vc WHERE vc.isDefault = true")
	List<VersionColor> getAllByDefault();
	
	@Query("SELECT vc FROM VersionColor vc WHERE vc.isDefault = true AND vc.version.product.category.id = :id")
	List<VersionColor> getAllByDefaultAndCategoryId(@Param("id") Long id);
	
	/*GET ALL PRODUCT BY MANUFACTURER ID*/
	@Query("SELECT vc FROM VersionColor vc WHERE vc.isDefault = true AND vc.version.product.manufacturer.id = :id")
	List<VersionColor> getAllProductByManufacturerId(@Param ("id") Long id);
	
	VersionColor getVersionColorById(@Param("id") Long id);
	
	@Query("SELECT vc FROM VersionColor vc WHERE vc.version.product.id = :productId AND vc.isDefault = true")
	List<VersionColor> getDefaultByProductId(@Param("productId") Long productId);
	
	@Query("SELECT vc FROM VersionColor vc WHERE vc.name LIKE %:name%")
	List<VersionColor> findVersionCorlorByName(@Param("name") String name);
}
