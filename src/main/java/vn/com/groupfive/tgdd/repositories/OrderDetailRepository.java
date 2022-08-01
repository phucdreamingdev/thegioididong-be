package vn.com.groupfive.tgdd.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.groupfive.tgdd.payload.entities.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	List<OrderDetail> getOrderDetailsByMemberOrderId(@Param("member_order_id") Long memberOrderId);
}
