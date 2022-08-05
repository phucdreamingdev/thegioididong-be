package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.Data;

@Data
public class VersionRequest {
	private String name;
	private String videoUrl;
//	private boolean isDefault;
	private Long productId;
	
}
