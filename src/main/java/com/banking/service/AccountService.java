package com.banking.service;

import com.banking.entity.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    List<Account> getAllAccounts();

    Account getAccountById(Long id);

    Account updateAccount(Long id, Account account);

    void deleteAccount(Long id);

    Account deposit(String accountNumber, Double amount);

    Account withdraw(String accountNumber, Double amount);

}