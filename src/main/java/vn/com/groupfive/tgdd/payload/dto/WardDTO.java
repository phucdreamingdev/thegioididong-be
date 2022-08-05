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
public class WardDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("codeName")
	private String codeName;
	
	@JsonProperty("divisionType")
	private String divisionType;
	
	@JsonProperty("shortCodename")
	private String shortCodename;
	
	@JsonProperty("district")
	private DistrictDTO district;
}
