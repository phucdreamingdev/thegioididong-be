package vn.com.groupfive.tgdd.payload.dto;

import java.awt.Image;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.groupfive.tgdd.payload.entities.Category;
import vn.com.groupfive.tgdd.payload.entities.Manufacturer;
import vn.com.groupfive.tgdd.payload.entities.Version;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String name;
	private Category category;
	private Manufacturer manufacturer;
	private Set<Version> versions;
}
