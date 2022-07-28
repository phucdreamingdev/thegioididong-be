package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long>{
	List<Ward> getAllWardByDistrictId(@Param("districtId") Long districtId);
	Ward getWardById(@Param("id") Long wardId);
}
