package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {

	private String fullname;
	
	
	private String phone;
	
	
	private boolean gender;
	

	
}
