package br.com.rodrigolisboa.financeapi.service;

import br.com.rodrigolisboa.financeapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import br.com.rodrigolisboa.financeapi.entity.Transaction;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
}