package vn.com.groupfive.tgdd.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.repositories.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberOrderDTO> getMemberOrderDTOsByID(Long id) {
		return memberMapper.memberOrdersToMemberOrderDtos(new ArrayList<>(memberRepository.getById(id).getMemberOrders()));
	}

	@Override
	public List<MemberAddressDTO> getListMemberAddressDTOs(Long id) {
		return memberMapper.memberAddressesToMemberAddressDtos(new ArrayList<>(memberRepository.findById(id).get().getMemberAddresses()));
	}


}
