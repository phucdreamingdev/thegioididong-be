package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDetailCreateRequest {
	private String name;
	private String content;
	private Long specificationGroupId;
	
}
