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
	
	
	
	
	
}
