package vn.com.groupfive.tgdd.services;

import java.util.HashSet;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.CategoryDoesNotExistException;
import vn.com.groupfive.tgdd.exceptions.PromotionDoesNotExist;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;

import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.payload.mapper.VersionMapper;
import vn.com.groupfive.tgdd.repositories.AdminAccountRepository;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.MemberOrderRepository;
import vn.com.groupfive.tgdd.repositories.OrderDetailRepository;
import vn.com.groupfive.tgdd.repositories.PromotionRepository;
import vn.com.groupfive.tgdd.repositories.ProvinceRepository;
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	VersionColorRepository versionColorRepository;
	
	@Autowired
	ProvinceRepository provinceRepository;

	
	VersionMapper versionMapper;
	
	@Autowired
	AdminAccountRepository adminAccRepo;
	
	@Autowired
	MemberOrderRepository memberOrderRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;
	
	@Autowired
	MemberMapper memberMapper;
	// create Category
		
	private Category createCategory(CategoryRequest categoryRequest) {

		Category category = new Category();
		category.setName(categoryRequest.getName());
		category.setLogo(categoryRequest.getLogo());
		category.setLevel(categoryRequest.getLevel());
		category.setParentName(categoryRequest.getParentName());
		category.setStatus(categoryRequest.isStatus());
		category.setParent(categoryRequest.isParent());
		category.setChildrenLevel(categoryRequest.getChildrenLevel());
		return category;
	}

	@Override
	public Category addCategory(CategoryRequest categoryRequest) throws CrudException {
		if (categoryRepository.existsByName(categoryRequest.getName())) {
			throw new CategoryAlreadyExistedException();
		}
		Category category = createCategory(categoryRequest);
		return categoryRepository.save(category);
	}

	// Input category from repository and edit
	private Category updateCategory(Category category, CategoryRequest categoryRequest) {
		category.setName(categoryRequest.getName());
		category.setLogo(categoryRequest.getLogo());
		category.setLevel(categoryRequest.getLevel());
		category.setParentName(categoryRequest.getParentName());
		category.setStatus(categoryRequest.isStatus());
		category.setParent(categoryRequest.isParent());
		category.setChildrenLevel(categoryRequest.getChildrenLevel());
		return category;
	}

	@Override
	public Category updateCategory(Long id, CategoryRequest categoryRequest) throws CrudException {
		if (!categoryRepository.existsById(id)) {
			throw new CategoryDoesNotExistException();
		}
		Category category = categoryRepository.getById(id);
		// save to repository after update
		return categoryRepository.save(updateCategory(category, categoryRequest));
	}

	// Create promotion
	private Promotion createPromotion(PromotionRequest promotionRequest) {
		Promotion promotion = new Promotion();
		promotion.setPromotionPercent(promotionRequest.getPromotionPercent());
		promotion.setStartDate(promotionRequest.getStartDate());
		promotion.setEndDate(promotionRequest.getEndDate());
		promotion.setActived(promotionRequest.isActived());
		promotion.setVersionColors(new HashSet<>(versionColorRepository.findAllById(promotionRequest.getProvinceIds())));
		promotion.setProvinces(new HashSet<>(provinceRepository.findAllById(promotionRequest.getProvinceIds())));
		return promotion;
	}

	@Override
	public Promotion addPromotions(PromotionRequest promotionRequest) throws CrudException {
		Promotion promotion = createPromotion(promotionRequest);
		return promotionRepository.save(promotion);
	}
	
	//Update promotion
	private Promotion updatePromotion(Promotion promotion, PromotionRequest promotionRequest) {
		promotion.setPromotionPercent(promotionRequest.getPromotionPercent());
		promotion.setStartDate(promotionRequest.getStartDate());
		promotion.setEndDate(promotionRequest.getEndDate());
		promotion.setActived(promotionRequest.isActived());
		promotion.setVersionColors(new HashSet<>(versionColorRepository.findAllById(promotionRequest.getProvinceIds())));
		promotion.setProvinces(new HashSet<>(provinceRepository.findAllById(promotionRequest.getProvinceIds())));
		return promotion;
	}
	
	@Override
	public Promotion updatePromotions(Long id, PromotionRequest promotionRequest) throws CrudException{
		if(!promotionRepository.existsById(id)) {
			throw new PromotionDoesNotExist();
		}
		Promotion promotion = promotionRepository.getById(id);
		return promotionRepository.save(updatePromotion(promotion, promotionRequest));
	}

	@Override
	public VersionColorItemDTO getVersionColorById(Long id) {
		return versionMapper.versionColorToVersionColorItemDto(versionColorRepository.getVersionColorById(id));
	}
	
	@Override
	public AdminAccount login(String username, String password) {
		return adminAccRepo.getAdminAccountByUserNameAndPassword(username, password);
	}



	@Override
	public AdminAccount getAdminAccountByUsername(String username) {
		return adminAccRepo.getAdminAccountByUserName(username);
	}

	@Override
	public List<AdminAccount> getAllAccount() {
		return adminAccRepo.findAll();
	}

	@Override
	public List<MemberOrderDTO> getAllMemberOrders() {
		return memberMapper.memberOrdersToMemberOrderDtos(memberOrderRepo.findAll());
	}
	
	@Override
	public List<MemberOrderDTO> getAllMemberOrdersByBranch(Long branchId) {
		return memberMapper.memberOrdersToMemberOrderDtos(memberOrderRepo.getMemberOrdersByBranchId(branchId));
	}
	
	@Override
	public List<OrderDetailDTO> getAllOrderDetailsByMemberOrderId(Long memberOrderId) {
		return memberMapper.orderDetailsToOderDetailDtos(orderDetailRepo.getOrderDetailsByMemberOrderId(memberOrderId));
	}
	
	@Override
	public List<MemberOrderDTO> getAllMemberOrdersByPhoneNumber(String phoneNumber) {
		return memberMapper.memberOrdersToMemberOrderDtos(memberOrderRepo.getAllMemberOrderByPhoneNumber(phoneNumber));
	}

}
