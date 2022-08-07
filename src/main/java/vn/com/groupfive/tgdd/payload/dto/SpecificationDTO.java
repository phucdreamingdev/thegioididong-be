package vn.com.groupfive.tgdd.payload.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDTO {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("specificationDetails")
	private List<SpecificationDetailDTO> specificationDetails;
	
	@JsonProperty("image")
	private ImageDTO image;

}
