package vn.com.groupfive.tgdd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.mapper.MemberMapper;
import vn.com.groupfive.tgdd.services.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberMapper memberMapper;

	@GetMapping("/get-member-order-by-id/{id}")
	List<MemberOrderDTO> getListMemberOrderDTOs(@PathVariable("id") Long id) {
		return memberService.getMemberOrderDTOsByID(id);
	}
	
}
