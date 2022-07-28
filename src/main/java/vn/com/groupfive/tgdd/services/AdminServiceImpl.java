package vn.com.groupfive.tgdd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.CategoryDoesNotExistException;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
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
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	VersionMapper versionMapper;
	
	@Autowired
	VersionColorRepository versionColorRepository;
	
	@Autowired
	AdminAccountRepository adminAccRepo;
	
	@Autowired
	MemberOrderRepository memberOrderRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;
	
	@Autowired
	MemberMapper memberMapper;
	
	private Category setCategory(CategoryRequest categoryRequest) {
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
		if(categoryRepository.existsByName(categoryRequest.getName())) {
			throw new CategoryAlreadyExistedException();
		}
		Category category = setCategory(categoryRequest);
		return categoryRepository.save(category);
	}
	

	
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
	public Category updateCategory(Long id,CategoryRequest categoryRequest) throws CrudException {
		if(!categoryRepository.existsById(id)) {
			throw new CategoryDoesNotExistException();
		}
		Category category = categoryRepository.getById(id);
		return categoryRepository.save(updateCategory(category, categoryRequest));
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
