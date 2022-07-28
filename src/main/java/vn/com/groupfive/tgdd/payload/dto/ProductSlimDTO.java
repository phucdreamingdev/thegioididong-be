package vn.com.groupfive.tgdd.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSlimDTO {
		@JsonProperty("id")
		private Long id;
		
		@JsonProperty("name")
		private String name;
}
