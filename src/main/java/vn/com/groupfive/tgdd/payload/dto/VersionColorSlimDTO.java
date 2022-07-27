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
public class VersionColorSlimDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("avatar")
	private String avartar;
	
	@JsonProperty("isDefault")
	private boolean isDefault;
	
	@JsonProperty("color")
	private ColorDTO color;
	
}
