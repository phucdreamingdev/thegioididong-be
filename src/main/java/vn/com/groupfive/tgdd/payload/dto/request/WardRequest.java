package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WardRequest {
	private String id;
	private String name;
	private String level;
}
