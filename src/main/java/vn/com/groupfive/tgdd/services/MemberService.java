package vn.com.groupfive.tgdd.services;

import java.util.List;

import vn.com.groupfive.tgdd.exceptions.handlers.CrudException;
import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;

public interface MemberService { 
	List<MemberOrderDTO> getMemberOrderDTOsByID(Long id) throws CrudException;
	List<MemberAddressDTO> getListMemberAddressDTOs(Long id) throws CrudException;
	List<OrderDetailDTO> getListOrderDetailDTOs(Long id) throws CrudException;
	
	
}
