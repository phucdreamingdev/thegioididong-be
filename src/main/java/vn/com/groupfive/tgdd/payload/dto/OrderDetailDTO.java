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

public class OrderDetailDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("originalPrice")
	private float originalPrice;
	
	@JsonProperty("promotionPrice")
	private float promotionPrice;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("versionColor")
	private VersionColorSlimDTO versionColor;
}
