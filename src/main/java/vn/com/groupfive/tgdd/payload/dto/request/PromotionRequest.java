package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionRequest {

	@NotNull
	@Min(value = 1)
	@Max(value = 100)
	private int promotionPercent;
	
	@NotNull
	@JsonFormat(pattern ="yyyy-mm-dd")
	private Date startDate;
	
	@NotNull
	@JsonFormat(pattern ="yyyy-mm-dd")
	private Date endDate;
	
	@NotNull
	private boolean isActived;
	
	@NotNull
	private List<Long> versionColorIds;
	
	@NotNull
	private List<Long> provinceIds;
}
