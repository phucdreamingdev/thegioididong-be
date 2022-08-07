package vn.com.groupfive.tgdd.payload.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date startDate;
	
	@JsonProperty("endDate")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date endDate;
	
	@JsonProperty("versionColors")
	private List<VersionColorSlimDTO> versionColors;
	
	@JsonProperty("provinces")
	private List<ProvinceDTO> provinces;
}
