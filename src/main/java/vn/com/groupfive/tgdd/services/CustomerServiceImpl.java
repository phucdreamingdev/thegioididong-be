package vn.com.groupfive.tgdd.services;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.CategoryAlreadyExistedException;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.BranchSlimResponeDTO;
import vn.com.groupfive.tgdd.payload.dto.Cart;
import vn.com.groupfive.tgdd.payload.dto.CartProductDTO;
import vn.com.groupfive.tgdd.payload.dto.CategorySlimDTO;
import vn.com.groupfive.tgdd.payload.dto.DistrictDTO;
import vn.com.groupfive.tgdd.payload.dto.ItemCartDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductListItemDTO;
import vn.com.groupfive.tgdd.payload.dto.ProductDTO;
import vn.com.groupfive.tgdd.payload.dto.ProvinceDTO;
import vn.com.groupfive.tgdd.payload.dto.VersionColorItemDTO;
import vn.com.groupfive.tgdd.payload.dto.WardDTO;
import vn.com.groupfive.tgdd.payload.entities.Branch;
import vn.com.groupfive.tgdd.payload.entities.BranchStock;
import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.MemberAddress;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;
import vn.com.groupfive.tgdd.payload.entities.OrderDetail;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;
import vn.com.groupfive.tgdd.payload.entities.Ward;
import vn.com.groupfive.tgdd.payload.mapper.AddressMapper;
import vn.com.groupfive.tgdd.payload.mapper.BranchMapper;
import vn.com.groupfive.tgdd.payload.mapper.CategoryMapper;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.payload.mapper.ProductMapper;
import vn.com.groupfive.tgdd.payload.mapper.VersionMapper;
import vn.com.groupfive.tgdd.repositories.BranchRepository;
import vn.com.groupfive.tgdd.repositories.BranchStockRepository;
import vn.com.groupfive.tgdd.repositories.CategoryRepository;
import vn.com.groupfive.tgdd.repositories.DistrictRepository;
import vn.com.groupfive.tgdd.repositories.MemberAddressRepository;
import vn.com.groupfive.tgdd.repositories.MemberOrderRepository;
import vn.com.groupfive.tgdd.repositories.MemberRepository;
import vn.com.groupfive.tgdd.repositories.OrderDetailRepository;
import vn.com.groupfive.tgdd.repositories.ProductRepository;
import vn.com.groupfive.tgdd.repositories.ProvinceRepository;
import vn.com.groupfive.tgdd.repositories.VersionColorRepository;
import vn.com.groupfive.tgdd.repositories.WardRepository;
import vn.com.groupfive.tgdd.utils.DeliveryStatus;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	VersionColorRepository versionColorRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	BranchStockRepository branchStockRepository;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
	ProductMapper productMapper;

	@Autowired
	VersionMapper versionMapper;

	@Autowired
	BranchMapper branchMapper;

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	AddressMapper addressMapper;

	@Autowired
	ProvinceRepository provinceRepo;

	@Autowired
	DistrictRepository districtRepo;
	
	@Autowired
	WardRepository wardRepo;

	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	MemberAddressRepository memberAddressRepo;
	
	@Autowired
	MemberOrderRepository memberOrderRepo;
	
	@Autowired
	BranchRepository branchRepo;
	
	@Autowired
	OrderDetailRepository orderDetailRepo;
	

	private Cart cart = new Cart();

	@Override
	public List<CategorySlimDTO> getAllCategoryByLevel(int level) {
		return categoryMapper.categoriesToCategorySlimDtos(categoryRepository.findByLevel(level));
	}

	@Override
	public List<ProductListItemDTO> getAllProduct() {
		List<VersionColor> versionColors = versionColorRepository.getAllByDefault();
		List<ProductListItemDTO> productDTOs = new ArrayList<>();
		for (VersionColor versionColor : versionColors) {
			productDTOs.add(versionColorToProductDTO(versionColor));
		}
		return productDTOs;
	}

	@Override
	public ProductListItemDTO versionColorToProductDTO(VersionColor versionColor) {

		return new ProductListItemDTO(versionColor.getId(), versionColor.getName(), versionColor.getAvartar(),
				versionColor.getVersion().getProduct().getCategory().getName(),
				versionColor.getVersion().getProduct().getManufacturer().getName(), versionColor.getPrice());
	}

	@Override
	public List<ProductListItemDTO> getAllProductByCategoryId(Long categoryId) {
		List<VersionColor> versionColors = versionColorRepository.getAllByDefaultAndCategoryId(categoryId);
		List<ProductListItemDTO> productDTOs = new ArrayList<>();
		for (VersionColor versionColor : versionColors) {
			productDTOs.add(versionColorToProductDTO(versionColor));
		}
		return productDTOs;
	}

	@Override
	public List<VersionColorItemDTO> getAllVersionColorItemDTOs() {
		return versionMapper.versionColorsToVersionColorItemDtos(versionColorRepository.getAllByDefault());
	}

	@Override
	public List<VersionColorItemDTO> getAllVersionColorItemDTOsByCategoryId(Long id) {
		return versionMapper
				.versionColorsToVersionColorItemDtos(versionColorRepository.getAllByDefaultAndCategoryId(id));

	}

	@Override
	public List<BranchSlimResponeDTO> getBranchInStock(Long versionColorid, Long provinceId) {
		return branchMapper
				.branchsToBranchSlimResponeDtos(branchStockRepository.getBranchInStock(versionColorid, provinceId));
	}

	@Override
	public String addToCart(Long versionColorId, int quantity, Long provinceId) {
		VersionColor versionColor = versionColorRepository.getVersionColorById(versionColorId);
		if (versionColor == null)
			return "Not Found VersionColor Id";
		List<Branch> listBranch = branchStockRepository.getBranchInStock(versionColorId, provinceId);
		int totalInStock = 0;
		if (listBranch != null && listBranch.size() > 0) {
			for (Branch branch : listBranch) {
				Set<BranchStock> branchStocks = branch.getBranchStocks();
				if (branchStocks != null && branchStocks.size() > 0) {
					for (BranchStock branchStock : branchStocks) {
						if (branchStock.getVersionColor().getId().equals(versionColorId)
								&& branchStock.getStock() > 0) {
							totalInStock += branchStock.getStock();
						}
					}
				}
			}
			totalInStock -= quantity;
			if (totalInStock > 0) {
				ItemCartDTO product = new ItemCartDTO(versionColor.getId(), versionColor.getName(),
						versionColor.getAvartar(), versionColor.getVersion().getProduct().getCategory().getName(),
						versionColor.getVersion().getProduct().getManufacturer().getName(),
						versionColor.getVersion().getName(), versionColor.getColor().getName(),
						versionColor.getPrice() + "");
				if (product != null) {
					cart.addProduct(product, quantity);
					return "Add To Cart Successful.";
				} else
					return "Add To Cart Failed! Not Found Product";
			}
		}
		return "Not Enough Product In Stock";
	}

	@Override
	public boolean removeFromCart(Long versionColorId) {
		return cart.removeProduct(versionColorId);
	}

	@Override
	public boolean editQuantityProductCart(Long versionColorId, int quantity) {
		return cart.editQuantity(versionColorId, quantity);
	}

	@Override
	public boolean changeVersionColorProductCartById(Long versionColorId, Long nVersionColorId) {
		VersionColor versionColor = versionColorRepository.getVersionColorById(nVersionColorId);
		if (versionColor == null)
			return false;
		ItemCartDTO product = new ItemCartDTO(versionColor.getId(), versionColor.getName(), versionColor.getAvartar(),
				versionColor.getVersion().getProduct().getCategory().getName(),
				versionColor.getVersion().getProduct().getManufacturer().getName(), versionColor.getVersion().getName(),
				versionColor.getColor().getName(), versionColor.getPrice() + "");
		return cart.changeVersionColorOfProduct(versionColorId, product);
	}

	@Override
	public List<CartProductDTO> getAllCartProduct(Long provineId) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		List<CartProductDTO> list = cart.getCartProducts();
		if (list != null && list.size() > 0) {
			List<CartProductDTO> listViewCurrency = new ArrayList<>();
			for (CartProductDTO cartProd : list) {
				List<Branch> listBranch = branchStockRepository.getBranchInStock(cartProd.getProduct().getId(),
						provineId);
				int totalInStock = 0;
				if (listBranch != null && listBranch.size() > 0) {
					for (Branch branch : listBranch) {
						Set<BranchStock> branchStocks = branch.getBranchStocks();
						if (branchStocks != null && branchStocks.size() > 0) {
							for (BranchStock branchStock : branchStocks) {
								if (branchStock.getVersionColor().getId().equals(cartProd.getProduct().getId())
										&& branchStock.getStock() > 0) {
									totalInStock += branchStock.getStock();
								}
							}
						}
					}
					System.out.println(totalInStock);
					totalInStock -= cartProd.getQuantity();
					if (totalInStock > 0) {
						ItemCartDTO product = new ItemCartDTO(cartProd.getProduct().getId(),
								cartProd.getProduct().getName(), cartProd.getProduct().getImg(),
								cartProd.getProduct().getCategoryName(), cartProd.getProduct().getBrand(),
								cartProd.getProduct().getVersionName(), cartProd.getProduct().getColorName(),
								currencyVN.format(Float.parseFloat(cartProd.getProduct().getPrice())));
						CartProductDTO nProd = new CartProductDTO(cartProd.getQuantity(), product);
						nProd.setTotalPrice(currencyVN.format(Float.parseFloat(cartProd.getTotalPrice())));
						listViewCurrency.add(nProd);
					}
				}
			}
			return listViewCurrency;
		}
		return null;
	}

	public Cart getCart() {
		return cart;
	}

	@Override
	public List<ProvinceDTO> getAllProvince() {
		return addressMapper.provincesToProvinceDtos(provinceRepo.findAll());
	}

	@Override
	public List<DistrictDTO> getAllDistrictByProvinceId(Long provinceId) {
		return addressMapper.districtsToDistrictDtos(districtRepo.getAllDistrictByProvinceId(provinceId));
	}

	@Override
	public List<MemberDTO> getAllMemberDTO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberDTO getMemberDTOByPhone(String phone) {

		return memberMapper.memberToMemberDto(memberRepository.getByPhone(phone));
	}
	
	private Member setMember(String phone) {
		Member member = new Member();	
		member.setPhone(phone);	
		return member;
	}

	@Override
	public Member addNewMember(String phone) throws CrudException {
		if(memberRepository.existsByPhone(phone)) {
			throw new CategoryAlreadyExistedException();
		}
		Member member= setMember(phone);
		return memberRepository.save(member);
	}
	
	
	@Override
	public List<WardDTO> getAllWardByDistrictId(Long districtId) {
		return addressMapper.wardsToWardDtos(wardRepo.getAllWardByDistrictId(districtId));
	}
	
	@Override
	public String checkOutCart(String fullName, String phoneNumber, boolean gender, boolean deliveryAD, Long provinceId,
			Long districtId, Long wardId, String addressDetail, Date receiveDate) {
		if(cart.getCartProducts().size() == 0) return "Nothing in cart to checkout";
		if(deliveryAD) {
			if(fullName == null) {
				return "Not Found Fullname parameter";
			} else if(fullName.length() == 0) {
				return "Fullname must not empty";
			}
			if(phoneNumber == null) {
				return "Not Found phoneNumber parameter";
			} else if(phoneNumber.length() != 10 || phoneNumber.contains("[a-zA-Z]+")) {
				return "Phone number must be 10 number";
			}
			if(addressDetail == null) {
				return "Not Found memberAddress parameter";
			} else if(addressDetail.length() == 0) {
				return "Address must not empty";
			}
			if(provinceId == null) {
				return "Not Found provinceId parameter";
			}
			if(districtId == null) {
				return "Not Found districtId parameter";
			}
			
			if(wardId == null) {
				return "Not Found wardId parameter";
			}
			
			List<CartProductDTO> listCart = cart.getCartProducts();
			double totalPayment = 0;
			if(listCart != null && listCart.size() > 0) {
				List<BranchStock> leftInStocks = new ArrayList<>();
				for (CartProductDTO cartProd : listCart) {
					List<Branch> listBranch = branchStockRepository.getBranchInStock(cartProd.getProduct().getId(), provinceId);
					if (listBranch != null && listBranch.size() > 0) {
						for (Branch branch : listBranch) {
							Set<BranchStock> branchStocks = branch.getBranchStocks();
							if (branchStocks != null && branchStocks.size() > 0) {
								for (BranchStock branchStock : branchStocks) {
									if (branchStock.getVersionColor().getId().equals(cartProd.getProduct().getId())
											&& branchStock.getStock() > 0) {
										int inStock = branchStock.getStock() - cartProd.getQuantity();
										if(inStock > 0) {
											branchStock.setStock(inStock);
											leftInStocks.add(branchStock);
										} else return cartProd.getProduct().getId() + "/" + provinceId +" Not Enough in stock";
									}
								}
							}
						}
					}
					totalPayment += Double.parseDouble(cartProd.getTotalPrice());
				}
				if(leftInStocks.size() > 0) {
					for(BranchStock stock : leftInStocks) {
						branchStockRepository.save(stock);
					}
				} else return "Not Found Any Stock";
				Member member = memberRepo.getByPhone(phoneNumber);
				if(member != null) {
					MemberAddress memberAddress = memberAddressRepo.getMemberAddressByMemberId(member.getId());
					MemberOrder memberOrder = new MemberOrder();
					memberOrder.setOrderDate(new Date());
					memberOrder.setDeliveryDate(new Date());
					memberOrder.setRecieveDate(receiveDate);
					Branch branch = branchRepo.getBranchByWardId(wardId);
					if(branch == null) return "Not Found branch to checkout";
					memberOrder.setBranch(branch);
					memberOrder.setDeliveryStatus(DeliveryStatus.PREPARING);
					memberOrder.setMember(member);
					memberOrder.setTotalPayment(totalPayment);
					memberOrderRepo.save(memberOrder);
				}else {
					member = new Member();
					member.setFullname(fullName);
					member.setPhone(phoneNumber);
					member.setGender(gender);
					memberRepo.save(member);
					MemberAddress memberAddress = new MemberAddress();
					memberAddress.setAddress(addressDetail);
					memberAddress.setDefault(true);
					Member curMem = memberRepo.getByPhone(phoneNumber);
					Ward ward = wardRepo.getWardById(wardId);
					if(ward == null) return "Need Ward Information to using";
					memberAddress.setMember(curMem);
					memberAddress.setWard(ward);
					memberAddressRepo.save(memberAddress);
					MemberOrder memberOrder = new MemberOrder();
					memberOrder.setOrderDate(new Date());
					memberOrder.setDeliveryDate(new Date());
					memberOrder.setRecieveDate(receiveDate);
					Branch branch = branchRepo.getBranchByWardId(wardId);
					if(branch == null) return "Not Found branch to checkout";
					memberOrder.setBranch(branch);
					memberOrder.setDeliveryStatus(DeliveryStatus.PREPARING);
					memberOrder.setMember(member);
					memberOrder.setTotalPayment(totalPayment);
					memberOrderRepo.save(memberOrder);
				}
				MemberOrder memberOrder = memberOrderRepo.findTopByOrderByIdDesc();
				if(memberOrder != null) {
					if(listCart != null && listCart.size() > 0) {
						for(CartProductDTO cartProd : listCart) {
							OrderDetail orderDetail = new OrderDetail();
							orderDetail.setMemberOrder(memberOrder);
							orderDetail.setOriginalPrice(Float.parseFloat(cartProd.getProduct().getPrice()));
							orderDetail.setPromotionPrice(0);
							orderDetail.setQuantity(cartProd.getQuantity());
							VersionColor versionColor = versionColorRepository.getVersionColorById(cartProd.getProduct().getId());
							orderDetail.setVersionColor(versionColor);
							orderDetailRepo.save(orderDetail);
						}
					}
				}
				cart.getCartProducts().clear();
				return "Check out successful";
			}
		}
		return "Need To Delivery At destination to checkout";
	}

	@Override
	public VersionColorItemDTO getVersionColorDefault(Long productId) {
		List<VersionColor> versionColors = versionColorRepository.getDefaultByProductId(productId);
		return versionMapper.versionColorToVersionColorItemDto(versionColors.get(0));
	}

}
