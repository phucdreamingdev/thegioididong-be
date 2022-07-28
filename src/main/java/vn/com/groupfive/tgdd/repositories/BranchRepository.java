package vn.com.groupfive.tgdd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
	Branch getBranchByWardId(@Param("ward_id") Long wardId);
}
