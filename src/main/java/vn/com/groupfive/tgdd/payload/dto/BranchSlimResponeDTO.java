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
public class BranchSlimResponeDTO {
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("ward")
	private WardDTO ward;
	
	@JsonProperty("status")
	private boolean status;
	
}
