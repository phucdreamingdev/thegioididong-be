package vn.com.groupfive.tgdd.payload.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MemberfullDTO {
	@JsonProperty("id")
	private Long id;

	@JsonProperty("fullname")
	private String fullname;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("gender")
	private boolean gender;
	
	
}
