package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.services.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberMapper memberMapper;

	@GetMapping("/get-member-order-by-member-id/{id}")
	List<MemberOrderDTO> getListMemberOrderDTOs(@PathVariable("id") Long id) throws CrudException {
		return memberService.getMemberOrderDTOsByMemberID(id);
	}

	@GetMapping("/get-member-address-by-member-id/{id}")
	List<MemberAddressDTO> getListMemberAddressDTOs(@PathVariable("id") Long id) throws CrudException {

		return memberService.getListMemberAddressDTOs(id);
	}

	@GetMapping("/get-order-detail-by-member-order-id/{id}")
	List<OrderDetailDTO> getListOrderDetailDTOs(@PathVariable("id") Long id) throws CrudException {
		return memberService.getListOrderDetailDTOs(id);
	}

}
