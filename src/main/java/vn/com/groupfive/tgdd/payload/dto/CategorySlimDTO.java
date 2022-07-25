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
public class CategorySlimDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("logo")
	private String logo;
	
	@JsonProperty("level")
	private int level;
	
	@JsonProperty("parentName")
	private String parentName;
	
	@JsonProperty("status")
	private boolean status;
	
	@JsonProperty("isParent")
	private boolean isParent;
	
	@JsonProperty("childrenLevel")
	private int childrenLevel;
}
