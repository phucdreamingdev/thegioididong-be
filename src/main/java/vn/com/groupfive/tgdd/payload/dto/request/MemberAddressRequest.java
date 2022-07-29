package vn.com.groupfive.tgdd.payload.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberAddressRequest {

	private String address;

	private boolean isDefault;

	private long wardID;
}
