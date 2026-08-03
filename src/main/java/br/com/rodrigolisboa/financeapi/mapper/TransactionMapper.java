package br.com.rodrigolisboa.financeapi.mapper;

import br.com.rodrigolisboa.financeapi.dto.TransactionRequestDTO;
import br.com.rodrigolisboa.financeapi.dto.TransactionResponseDTO;
import br.com.rodrigolisboa.financeapi.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestDTO dto) {

        Transaction transaction = new Transaction();

        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setType(dto.getType());
        transaction.setDate(dto.getDate());

        return transaction;
    }
    public TransactionResponseDTO toResponse(Transaction transaction) {

        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDate()
        );
    }
}