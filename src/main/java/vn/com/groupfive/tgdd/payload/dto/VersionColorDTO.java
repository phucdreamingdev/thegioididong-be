package vn.com.groupfive.tgdd.payload.dto;

import java.awt.Color;
import java.awt.Image;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.com.groupfive.tgdd.payload.entities.Product;
import vn.com.groupfive.tgdd.payload.entities.Version;
import vn.com.groupfive.tgdd.payload.entities.VersionColor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VersionColorDTO {
	private Long id;
	private String name;
	private float price;
	private String avartar;
	private Version version;
	private Set<Image> images;
}
