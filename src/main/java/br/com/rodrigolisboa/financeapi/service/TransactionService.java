package br.com.rodrigolisboa.financeapi.service;

import br.com.rodrigolisboa.financeapi.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import br.com.rodrigolisboa.financeapi.entity.Transaction;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }
    public List<Transaction> findAll() {
        return repository.findAll();
    }
    public Transaction update(Long id, Transaction transaction) {
        Transaction existingTransaction = repository.findById(id).orElseThrow();

        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setType(transaction.getType());
        existingTransaction.setDate(transaction.getDate());

        return repository.save(existingTransaction);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public Transaction findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}