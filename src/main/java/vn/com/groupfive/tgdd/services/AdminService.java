package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.OrderDetail;
import vn.com.groupfive.tgdd.payload.entities.Promotion;

public interface AdminService {
	String getAllCategory(); 
	List<Member> getAllMember();
	Member findMemberById(Long id);
	List<OrderDetail> getAllOrder();
	Promotion findPromotionById(Long id);
	Promotion updatePromotion(Long id, Promotion promotion);
	void deletePromotion(Long id);
}
