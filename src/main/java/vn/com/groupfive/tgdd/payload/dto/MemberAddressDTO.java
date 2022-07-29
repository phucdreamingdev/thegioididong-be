package vn.com.groupfive.tgdd.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberAddressDTO {
	@JsonProperty ("id")
	private Long id;
	
	@JsonProperty ("address")	
	private String address;
	
	@JsonProperty ("isDefault")	
	private boolean isDefault;
	
	@JsonProperty ("ward")
	private WardDTO ward;
	
}
