package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.MemberAddressDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberOrderDTO;
import vn.com.groupfive.tgdd.payload.dto.MemberUpdateDTO;
import vn.com.groupfive.tgdd.payload.dto.OrderDetailDTO;
import vn.com.groupfive.tgdd.payload.entities.Member;
import vn.com.groupfive.tgdd.payload.entities.MemberAddress;
import vn.com.groupfive.tgdd.payload.entities.MemberOrder;
import vn.com.groupfive.tgdd.payload.entities.OrderDetail;

@Mapper(componentModel = "spring")
public interface MemberMapper {
	MemberDTO memberToMemberDto(Member member);
	
	MemberUpdateDTO memberToMemberUpdateDTO(Member member);

	List<MemberDTO> membersToMemberDtos(List<Member> members);

	MemberAddressDTO memberAddressToMemberAddressDto(MemberAddress memberAddress);

	List<MemberAddressDTO> memberAddressesToMemberAddressDtos(List<MemberAddress> memberAddresses);

	OrderDetailDTO orderDetailToOderDetailDto(OrderDetail orderDetail);

	List<OrderDetailDTO> orderDetailsToOderDetailDtos(List<OrderDetail> orderDetails);

	MemberOrderDTO memberOrderToMemberOrderDto(MemberOrder memberOrder);

	List<MemberOrderDTO> memberOrdersToMemberOrderDtos(List<MemberOrder> memberOrders);

}
