package vn.com.groupfive.tgdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.OrderDetail;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.MemberRepository;
import vn.com.groupfive.tgdd.repositories.OrderDetailRepository;
import vn.com.groupfive.tgdd.repositories.PromotionRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CategoryRepository categoryRepository;

	public String getAllCategory() {
		List<Category> list = categoryRepository.findAll();
		String out = "";
		for (Category category : list) {
			out += category.getName() + "\n";
		}
		return out;
	}

	@Autowired
	MemberRepository memberRepository;

	@Override
	public List<Member> getAllMember() {
		return (List<Member>) memberRepository.findAll();
	}

	@Override
	public Member findMemberById(Long id) {
		return memberRepository.findById(id).get();
	}

	@Autowired
	OrderDetailRepository orderRepository;

	@Override
	public List<OrderDetail> getAllOrder() {
		return (List<OrderDetail>) orderRepository.findAll();
	}

	@Autowired
	PromotionRepository promotionRepository;

	@Override
	public Promotion findPromotionById(Long id) {
		return promotionRepository.findById(id).get();
	}

	@Override
	public Promotion updatePromotion(Long id, Promotion promotion) {
		Promotion fromDB = promotionRepository.findById(id).orElse(null);
		if (fromDB == null) {
			return null;
		} else {
			fromDB.setPromotionPercent(promotion.getPromotionPercent());
			fromDB.setStartDate(promotion.getStartDate());
			fromDB.setEndDate(promotion.getEndDate());
			fromDB.setBranchs(promotion.getBranchs());
			fromDB.setVersionColor(promotion.getVersionColor());
		}
		return promotionRepository.save(fromDB);
	}

	@Override
	public void deletePromotion(Long id) {
		promotionRepository.deleteById(id);
	}

}
