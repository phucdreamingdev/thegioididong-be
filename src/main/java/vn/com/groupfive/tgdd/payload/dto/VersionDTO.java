package vn.com.groupfive.tgdd.payload.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionDTO {
	private Long id;
	private String name;
	private Product product;
	private Set<VersionColor> versionColors;
}
