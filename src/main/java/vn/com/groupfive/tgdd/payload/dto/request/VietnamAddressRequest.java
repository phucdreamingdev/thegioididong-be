package vn.com.groupfive.tgdd.payload.dto.request;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VietnamAddressRequest {
	private Set<ProvinceRequest> provinces = new HashSet<>();
}