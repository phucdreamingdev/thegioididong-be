package vn.com.groupfive.tgdd.payload.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.groupfive.tgdd.payload.entities.ImageGroupVersion;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageGroupDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("imageGroupVersions")
	private List<ImageGroupVersion> imageGroupVersions;
	
	@JsonProperty("category")
	private CategorySlimDTO category;
}
