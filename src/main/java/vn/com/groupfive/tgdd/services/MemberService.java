package vn.com.groupfive.tgdd.services;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;

public interface MemberService {
	List<MemberOrderDTO> getMemberOrderDTOsByID(Long id);
	
	
}
