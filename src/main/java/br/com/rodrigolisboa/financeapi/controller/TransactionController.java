package br.com.rodrigolisboa.financeapi.controller;
import br.com.rodrigolisboa.financeapi.entity.Transaction;
import br.com.rodrigolisboa.financeapi.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import br.com.rodrigolisboa.financeapi.dto.TransactionRequestDTO;
import jakarta.validation.Valid;
import br.com.rodrigolisboa.financeapi.mapper.TransactionMapper;

@RestController
@RequestMapping("/transactions")
public class  TransactionController {

    private final TransactionService service;
    private final TransactionMapper mapper;

    public TransactionController(
            TransactionService service,
            TransactionMapper mapper) {

        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction create(
            @Valid @RequestBody TransactionRequestDTO transactionDTO) {

        Transaction transaction = mapper.toEntity(transactionDTO);
        return service.save(transaction);
    }
    @GetMapping
    public List<Transaction> findAll() {
        return service.findAll();
    }
    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id,
                              @RequestBody Transaction transaction) {
        return service.update(id, transaction);
    }
    @GetMapping("/{id}")
    public Transaction findById(@PathVariable Long id) {
        return service.findById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}