package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BranchCreateRequest {
	private String address;
	
	private boolean status;

	private Long wardId;
}
