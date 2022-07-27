package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Version;

@Repository
public interface VersionRepository extends JpaRepository<Version, Long>{
	@Query("SELECT v FROM Version v WHERE v.product.id = :id")
	List<Version> findByProductId(@Param("id") Long productId);
}
