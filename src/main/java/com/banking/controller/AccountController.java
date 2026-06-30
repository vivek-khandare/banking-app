package com.banking.controller;

import com.banking.dto.TransactionRequest;
import com.banking.entity.Account;
import com.banking.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updateAccount(@PathVariable Long id,
                                 @RequestBody Account account) {
        return accountService.updateAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "Account Deleted Successfully";
    }

    @PostMapping("/deposit")
    public Account deposit(@RequestBody TransactionRequest request) {
        return accountService.deposit(
                request.getAccountNumber(),
                request.getAmount()
        );
    }

    @PostMapping("/withdraw")
    public Account withdraw(@RequestBody TransactionRequest request) {
        return accountService.withdraw(
                request.getAccountNumber(),
                request.getAmount()
        );
    }
}