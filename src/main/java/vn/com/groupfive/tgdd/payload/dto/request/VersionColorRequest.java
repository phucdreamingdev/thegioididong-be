package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Set;

import lombok.Data;

@Data
public class VersionColorRequest {
	private boolean isDefault;
	private String name;
	private double price;
	private String avartar;
	private Long versionId;
	private String colorName;
	private Set<ImageRequest> images;
}

