package vn.com.groupfive.tgdd.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MemberUpdateDTO {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("fullname")
	private String fullname;
		
	@JsonProperty("gender")
	private boolean gender;
	

}
