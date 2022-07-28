package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{
  List<District> getAllDistrictByProvinceId(@Param("provinceId") Long provinceId);
}
