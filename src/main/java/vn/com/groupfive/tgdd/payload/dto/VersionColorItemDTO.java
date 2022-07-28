package vn.com.groupfive.tgdd.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionColorItemDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("isDefault")
	private boolean isDefault;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("avartar")
	private String avartar;
	
	@JsonProperty("version")
	private VersionItemDTO version;
	
	@JsonProperty("color")
	private ColorItemDTO color;	
	
}	
