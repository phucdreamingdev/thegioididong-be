package vn.com.groupfive.tgdd.payload.dto;

import java.util.Date;

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

public class TransactionDTO {
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("transaction_date")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
	private Date transactionDate;
	
	@JsonProperty("total")
	private int total;
	
	@JsonProperty("detail")
	private String detail;
	
	@JsonProperty("branch")
	private BranchSlimResponeDTO branch;
	
}
