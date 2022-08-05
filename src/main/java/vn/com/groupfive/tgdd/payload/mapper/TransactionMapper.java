package vn.com.groupfive.tgdd.payload.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import vn.com.groupfive.tgdd.payload.dto.TransactionDTO;
import vn.com.groupfive.tgdd.payload.entities.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
	TransactionDTO transactionToTransactionDto (Transaction transaction);
	
	List<TransactionDTO> transactionToTransactionDtos (List<Transaction> transactions);
}
