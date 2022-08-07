package vn.com.groupfive.tgdd.payload.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberDTO {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("fullname")
	private String fullname;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("gender")
	private boolean gender;
	
	@JsonProperty("memberAddresses")
	private List<MemberAddressDTO> memberAddresses;
	

}
