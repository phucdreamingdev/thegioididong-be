package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Repository
public interface VersionColorRepository extends JpaRepository<VersionColor, Long>{
	
	@Query("SELECT vc FROM VersionColor vc WHERE vc.isDefault = true")
	List<VersionColor> getAllByDefault();
}
