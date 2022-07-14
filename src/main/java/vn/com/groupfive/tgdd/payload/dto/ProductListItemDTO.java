package vn.com.groupfive.tgdd.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListItemDTO {
	private Long id;
	private String name;
	private String img;
	private String categoryName;
	private String brand;
	private String price;

}