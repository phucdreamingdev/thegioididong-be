package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberUpdateDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.dto.request.MemberAddressRequest;
import vn.com.groupfive.tgdd.payload.dto.request.MemberRequest;
import vn.com.groupfive.tgdd.payload.entities.Member;

public interface MemberService { 
	List<MemberOrderDTO> getMemberOrderDTOsByMemberID(Long id) throws CrudException;
	List<MemberAddressDTO> getListMemberAddressDTOs(Long id) throws CrudException;
	List<OrderDetailDTO> getListOrderDetailDTOs(Long id) throws CrudException;
	Member updateMemberUpdateDTO(Long id, MemberRequest memberRequest)throws CrudException;
	
	
}
