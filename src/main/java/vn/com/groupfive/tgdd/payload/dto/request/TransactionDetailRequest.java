package vn.com.groupfive.tgdd.payload.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetailRequest {

	@NotNull
	@Min(value = 1)
	@Max(value = 1000)
	private int transactionQuantity;
	
	@NotNull
	private String note;
	
	@NotNull
	private Long versionColorId;
	
}
