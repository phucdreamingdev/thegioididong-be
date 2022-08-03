package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.groupfive.tgdd.payload.entities.ImageGroupVersion;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VersionCreateRequest {
	private String name;
	private String videoUrl;
	private SpecificationCreateRequest specificationCreateRequest;
	private Set<VersionColorCreateRequest> versionColors;
	private Set<ImageGroupVersionCreateRequest> imageGroupVersions;
}
