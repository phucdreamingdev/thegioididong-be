package vn.com.groupfive.tgdd.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	private Long id;
	private String name;
	private String logo;
	private int level;
	private String parentName;
	private boolean status;
	private boolean isParent;
}