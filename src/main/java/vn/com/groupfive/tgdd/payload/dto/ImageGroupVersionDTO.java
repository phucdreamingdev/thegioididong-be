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
public class ImageGroupVersionDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("detail")
	private String detail;
	
	@JsonProperty("imageGroup")
	private ImageGroupItemDTO imageGroup;
	
	@JsonProperty("version")
	private VersionItemDTO version;
	
	@JsonProperty("image")
	private List<ImageDTO> image;
	
}
