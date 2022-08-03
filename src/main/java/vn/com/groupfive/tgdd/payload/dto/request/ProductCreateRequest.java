package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCreateRequest {
	private String name;
	private boolean isActived;
	private String categoryId;
	private String manufacturerId;
	private Set<VersionCreateRequest> versions;
}
