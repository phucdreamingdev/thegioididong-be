package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Set;

import lombok.Data;

@Data
public class ImageGroupVersionRequest {
	private String detail;
	private Long imageGroupId;
	private Set<ImageRequest> images;
}
