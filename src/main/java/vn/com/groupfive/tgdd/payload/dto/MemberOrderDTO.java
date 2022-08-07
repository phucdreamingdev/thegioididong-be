package vn.com.groupfive.tgdd.payload.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberOrderDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("orderDate")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date orderDate;
	
	@JsonProperty("totalPayment")
	private double totalPayment;
	
	@JsonProperty("deliveryStatus")
	private String deliveryStatus;
	
	@JsonProperty("orderDetails")
	private List<OrderDetailDTO> orderDetails;
}
