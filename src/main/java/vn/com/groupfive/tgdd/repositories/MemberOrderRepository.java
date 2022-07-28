package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.MemberAddress;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;

@Repository
public interface MemberOrderRepository extends JpaRepository<MemberOrder, Long>{
	List<MemberOrder> getMemberOrdersByBranchId(@Param("branch_id") Long branchId);
	
	MemberOrder findTopByOrderByIdDesc();
}
