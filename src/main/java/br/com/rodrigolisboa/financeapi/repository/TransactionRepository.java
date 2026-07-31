package br.com.rodrigolisboa.financeapi.repository;

import br.com.rodrigolisboa.financeapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}