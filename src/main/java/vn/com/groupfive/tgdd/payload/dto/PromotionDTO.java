package vn.com.groupfive.tgdd.payload.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("promotionPercent")
	private int promotionPercent;
	
	@JsonProperty("startDate")
	private Date startDate;
	
	@JsonProperty("endDate")
	private Date endDate;
	
	@JsonProperty("versionColors")
	private List<VersionColorSlimDTO> versionColors;
	
	@JsonProperty("provinces")
	private List<ProvinceDTO> provinces;
}
