package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.BranchStock;

@Repository
public interface BranchStockRepository extends JpaRepository<BranchStock, Long>{
	@Query("SELECT bs.branch FROM BranchStock bs WHERE bs.versionColor.id = :versionColorid AND bs.branch.ward.district.province.id = :provinceId AND bs.stock > 0")
	List<Branch> getBranchInStock(@Param("versionColorid") Long versionColorid, @Param("provinceId") Long provinceId);
}
