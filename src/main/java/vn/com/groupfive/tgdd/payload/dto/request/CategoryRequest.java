package vn.com.groupfive.tgdd.payload.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {
	@NotNull
	private String name;
	
	private String logo;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 2)
	private int level;
	
	private String parentName;
	
	@NotNull
	private boolean status;
	
	@NotNull
	private boolean isParent;
	
	@NotNull
	@Min(value = 0)
	@Max(value = 2)
	private int childrenLevel;
}
