package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.Data;

@Data
public class VersionRequest {
	private String name;
	private String videoUrl;
	private Long productId;
	private SpecificationCreateRequest specification;
	
}
