package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.exceptions.MemberDoesNotExistedException;
import vn.com.groupfive.tgdd.exceptions.MemberOrderDoesNotExistedException;
import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.repositories.MemberOrderRepository;
import vn.com.groupfive.tgdd.repositories.MemberRepository;
import vn.com.groupfive.tgdd.repositories.OrderDetailRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Autowired
	MemberOrderRepository memberOrderRepository;
	
	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberOrderDTO> getMemberOrderDTOsByMemberID(Long id) throws CrudException{
		if(!memberRepository.existsById(id)) {
			throw new MemberDoesNotExistedException();
		}
		return memberMapper.memberOrdersToMemberOrderDtos(new ArrayList<>(memberRepository.findById(id).get().getMemberOrders()));
	}

	@Override
	public List<MemberAddressDTO> getListMemberAddressDTOs(Long id) throws CrudException{
		if(!memberRepository.existsById(id)) {
			throw new MemberDoesNotExistedException();
		}
		return memberMapper.memberAddressesToMemberAddressDtos(new ArrayList<>(memberRepository.findById(id).get().getMemberAddresses()));
	}
	@Override
	public List<OrderDetailDTO> getListOrderDetailDTOs(Long orderId) throws CrudException{	
		if(!memberOrderRepository.existsById(orderId)) {
			throw new MemberOrderDoesNotExistedException();
		}
		return memberMapper.orderDetailsToOderDetailDtos(new ArrayList<>(memberOrderRepository.findById(orderId).get().getOrderDetails()));
	}


}
