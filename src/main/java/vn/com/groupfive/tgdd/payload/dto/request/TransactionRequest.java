package vn.com.groupfive.tgdd.payload.dto.request;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest implements Serializable {
	
	@NotNull
	private String detail;
	
	@NotNull
	private Long branchId;
	
	private Set<TransactionDetailRequest> transactionDetailRequests;
}
