package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.BranchDoesNotExistException;
import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.CategoryDoesNotExistException;
import vn.com.groupfive.tgdd.exceptions.PromotionDoesNotExist;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.request.BranchCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.CategoryRequest;
import vn.com.groupfive.tgdd.payload.dto.request.DistrictRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProductCreateRequest;
import vn.com.groupfive.tgdd.payload.dto.request.PromotionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.ProvinceRequest;
import vn.com.groupfive.tgdd.payload.dto.request.TransactionRequest;
import vn.com.groupfive.tgdd.payload.dto.request.VietnamAddressRequest;
import vn.com.groupfive.tgdd.payload.dto.request.WardRequest;
import vn.com.groupfive.tgdd.payload.entities.AdminAccount;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.District;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Promotion;
import vn.com.groupfive.tgdd.payload.entities.Province;
import vn.com.groupfive.tgdd.payload.entities.Transaction;
import vn.com.groupfive.tgdd.payload.entities.TransactionDetail;
import vn.com.groupfive.tgdd.payload.entities.Ward;
import vn.com.groupfive.tgdd.payload.mapper.BranchMapper;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.repositories.AdminAccountRepository;
import vn.com.groupfive.tgdd.repositories.BranchRepository;
import vn.com.groupfive.tgdd.repositories.BranchStockRepository;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.DistrictRepository;
import vn.com.groupfive.tgdd.repositories.ManufacturerRepository;
import vn.com.groupfive.tgdd.repositories.MemberOrderRepository;
import vn.com.groupfive.tgdd.repositories.MemberRepository;
import vn.com.groupfive.tgdd.repositories.OrderDetailRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;
import vn.com.groupfive.tgdd.repositories.PromotionRepository;
import vn.com.groupfive.tgdd.repositories.ProvinceRepository;
import vn.com.groupfive.tgdd.repositories.TransactionDetailRepository;
import vn.com.groupfive.tgdd.repositories.TransactionRepository;
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;
import vn.com.groupfive.tgdd.repositories.WardRepository;
import vn.com.groupfive.tgdd.utils.DeliveryStatus;

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

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	BranchRepository branchRepo;
	
	@Autowired
	WardRepository warRepository;
	
	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	TransactionDetailRepository transactionDetailRepository;

	@Autowired
	BranchStockRepository branchStockRepo;

	// @Autowired
	// VersionMapper versionMapper;

	@Autowired
	AdminAccountRepository adminAccRepo;

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Autowired
	MemberOrderRepository memberOrderRepo;

	@Autowired
	OrderDetailRepository orderDetailRepo;

	@Autowired
	WardRepository wardRepository;

	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	MemberMapper memberMapper;

	@Autowired
	BranchMapper branchMapper;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	ProductMapper productMapper;
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
		promotion
				.setVersionColors(new HashSet<>(versionColorRepository.findAllById(promotionRequest.getProvinceIds())));
		promotion.setProvinces(new HashSet<>(provinceRepository.findAllById(promotionRequest.getProvinceIds())));
		return promotion;
	}

	@Override
	public Promotion addPromotions(PromotionRequest promotionRequest) throws CrudException {
		Promotion promotion = createPromotion(promotionRequest);
		return promotionRepository.save(promotion);
	}

	// Update promotion
	private Promotion updatePromotion(Promotion promotion, PromotionRequest promotionRequest) {
		promotion.setPromotionPercent(promotionRequest.getPromotionPercent());
		promotion.setStartDate(promotionRequest.getStartDate());
		promotion.setEndDate(promotionRequest.getEndDate());
		promotion.setActived(promotionRequest.isActived());
		promotion.setVersionColors(
				new HashSet<>(versionColorRepository.findAllById(promotionRequest.getVersionColorIds())));
		promotion.setProvinces(new HashSet<>(provinceRepository.findAllById(promotionRequest.getProvinceIds())));
		return promotion;
	}

	@Override
	public Promotion updatePromotions(Long id, PromotionRequest promotionRequest) throws CrudException {
		if (!promotionRepository.existsById(id)) {
			throw new PromotionDoesNotExist();
		}
		Promotion promotion = promotionRepository.getById(id);
		return promotionRepository.save(updatePromotion(promotion, promotionRequest));
	}

	// @Override
	// public VersionColorItemDTO getVersionColorById(Long id) {
	// return
	// versionMapper.versionColorToVersionColorItemDto(versionColorRepository.getVersionColorById(id));
	// }

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

	@Override
	public MemberDTO findMemberById(Long id) {
		return memberMapper.memberToMemberDto(memberRepository.findMemberById(id));
	}

	// @Override
	// public List<VersionColorSlimDTO> searchVersionColorByName(String name) {
	// return
	// versionMapper.verionColorsToVersionColorSlimDtos(versionColorRepository.findVersionCorlorByName(name));
	// }

	@Override
	public List<CategorySlimDTO> getAllCategoryByLevel(int level) {
		return categoryMapper.categoriesToCategorySlimDtos(categoryRepository.findByLevel(level));
	}

	@Override
	public Branch addBranch(BranchCreateRequest branchRequest) throws CrudException {
		Branch branch = new Branch();
		branch.setAddress(branchRequest.getAddress());
		branch.setStatus(branchRequest.isStatus());
		branch.setWard(wardRepository.findById(branchRequest.getWardId()).get());
		return branchRepository.save(branch);
	}

	public Branch updateBranch(Branch branch, BranchCreateRequest branchRequest) {
		Branch br = branch;
		br.setStatus(branchRequest.isStatus());
		;
		return br;
	}

	@Override
	public Branch updateBranch(Long id, BranchCreateRequest branchRequest) throws CrudException {
		if (!branchRepository.existsById(id)) {
			throw new BranchDoesNotExistException();
		}
		Branch branch = branchRepository.getById(id);
		// save to repository after update
		return branchRepository.save(updateBranch(branch, branchRequest));
	}

	@Override
	public List<BranchSlimResponeDTO> getAllBranches() {
		return branchMapper.branchsToBranchSlimResponeDtos(branchRepository.findAll());
	}

	@Override
	public List<MemberDTO> getAllMember() {
		return memberMapper.membersToMemberDtos(memberRepository.findAll());
	}

	public List<Object[]> getCategorySelectItemByLevel(int level) {

		return categoryRepository.getCategoryByLevelItem(level);
	}

	public boolean updateOrderStatusByMemberOrderIdAndStatus(Long memberOrderId, String status) {
		if (memberOrderId == null || status == null)
			return false;
		MemberOrder memberOrder = memberOrderRepo.getMemberOrderById(memberOrderId);
		status = status.trim().toLowerCase();
		if (memberOrder.getDeliveryStatus().equals(DeliveryStatus.PREPARING)) {
			if (status.equals("ready")) {
				memberOrder.setDeliveryStatus(DeliveryStatus.READY);
				memberOrderRepo.save(memberOrder);
				return true;
			}
			if (status.equals("cancel")) {
				memberOrder.setDeliveryStatus(DeliveryStatus.CANCEL);
				memberOrderRepo.save(memberOrder);
				return true;
			}
		}
		if (memberOrder.getDeliveryStatus().equals(DeliveryStatus.READY)) {
			if (status.equals("delivered")) {
				memberOrder.setDeliveryStatus(DeliveryStatus.DELIVERED);
				memberOrderRepo.save(memberOrder);
				return true;
			}
			if (status.equals("cancel")) {
				memberOrder.setDeliveryStatus(DeliveryStatus.CANCEL);
				memberOrderRepo.save(memberOrder);
				return true;
			}
		}
		return false;

	}

	@Override
	public Product createProduct(ProductCreateRequest productCreateRequest) throws CrudException {
		Product product = new Product();
		product.setName(productCreateRequest.getName());
		product.setActived(productCreateRequest.isActived());
		product.setCategory(categoryRepository.findById(productCreateRequest.getCategoryId()).get());
		product.setManufacturer(manufacturerRepository.findById(productCreateRequest.getManufacturerId()).get());
		return productRepository.save(product);
	}

	@Override
	public Transaction addTransaction(TransactionRequest transactionRequest) throws CrudException {
		Set<TransactionDetail> transactionDetails = new HashSet<>();
		int total = 0;
		// for (TransactionDetailRequest transactionDetail :
		// transactionRequest.getTransactionDetailRequests()) {
		// TransactionDetail transactionDetailEntity = new TransactionDetail();
		// transactionDetailEntity.setStock(branchStockRepo.findBranchStockByBranchIdAndVersionColorId(transactionRequest.getBranchId(),
		// transactionDetail.getVersionColorId()).getStock());
		// transactionDetailEntity.setNote(transactionDetail.getNote());
		// transactionDetailEntity.setTransactionQuantity(transactionDetail.getTransactionQuantity());
		// transactionDetailEntity.setVersionColor(versionColorRepository.findById(transactionDetail.getVersionColorId()).get());
		// total += transactionDetail.getTransactionQuantity();
		//
		// if(transactionDetailRepository.save(transactionDetailEntity)!= null) {
		// BranchStock branchStock=
		// branchStockRepo.findById(transactionDetail.getVersionColorId()).get();
		// branchStock.setStock(branchStock.getStock()+transactionDetail.getTransactionQuantity());
		// branchStockRepo.save(branchStock);
		// }
		// }
		//
		// Transaction transaction = new Transaction();
		// transaction.setDetail(transactionRequest.getDetail());
		// transaction.setBranch(branchRepo.findById(transactionRequest.getBranchId()).get());
		// transaction.setTransactionDetails(transactionDetails);
		// transaction.setTotal(total);
		// return transactionRepository.save(transaction);
		return null;
	}

	@Override
	public Transaction updateTransaction(TransactionRequest transactionRequest) throws CrudException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addVietNamAddress(VietnamAddressRequest vietnamAddressRequest) {
		//Luu thu 1 thang duoi dang luu 1 lan 
//		Province provice = new Province();
//		provice.setName("Province 1");
//		
//		District district = new District();
//		district.setName("District 1");
//		district.setProvince(provice);
//	
//		Ward ward = new Ward();
//		ward.setName("ward 1");
//		ward.setDistrict(district);
//		
//		Set<District> districts = new HashSet<>();
//		districts.add(district);
//		
//		Set<Ward> wards = new HashSet<>();
//		wards.add(ward);
//		
//		district.setWards(wards);
//		
//		provinceRepository.save(provice);
//		provice.setDistricts(districts);
//		provinceRepository.save(provice);
		for (ProvinceRequest vietnam : vietnamAddressRequest.getProvinces()) {
			//Create province
			Province province = new Province();
			province.setName(vietnam.getName());
			provinceRepository.save(province);
			
			Set<District> districts = new HashSet<>();
			//Pass set value to set Entity
			for (DistrictRequest vietnamdistrict : vietnam.getDistricts()) {
				Set<Ward> wards = new HashSet<>();
				//Nho set ward list trong vong lap
				District district = new District();
				district.setName(vietnamdistrict.getName());
				district.setProvince(province);
				
				for (WardRequest vietnamward : vietnamdistrict.getWards()) {
					Ward ward = new Ward();
					ward.setName(vietnamward.getName());
					ward.setDistrict(district);
					
					wards.add(ward);
				}
				district.setWards(wards);
				districts.add(district);
			}
			
			province.setDistricts(districts);
			provinceRepository.save(province);
			
		}
	
		return true;
	}

}
