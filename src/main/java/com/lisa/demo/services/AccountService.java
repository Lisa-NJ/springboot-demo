package com.lisa.demo.services;


import com.lisa.demo.dtos.account.AccountGetDto;
import com.lisa.demo.dtos.transaction.TransactionGetDto;
import com.lisa.demo.entities.Account;
import com.lisa.demo.entities.Transaction;
import com.lisa.demo.exceptions.InvalidAccountException;
import com.lisa.demo.exceptions.TransactionNotExistException;
import com.lisa.demo.mappers.AccountMapper;
import com.lisa.demo.mappers.TransactionMapper;
import com.lisa.demo.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    private final TransactionMapper transactionMapper;

    public List<AccountGetDto> getAccounts() {
        return accountRepository.findAll().stream()
                .map(account -> accountMapper.fromEntity(account))
                .collect(Collectors.toList());
    }

    public List<TransactionGetDto> getTransactionsByUser(Long accountId) {
        Account account = accountRepository.findAccountAndRelatedTransactionsByAccountId(accountId)
                .orElseThrow(() -> new InvalidAccountException("No such an Id:" + accountId));

        Set<Transaction> transactions = account.getTransactions();
        if (transactions == null || transactions.isEmpty()) {
            throw new TransactionNotExistException(String.format("Account with id:%s does not have transactions", accountId));
        }

        return account.getTransactions()
                .stream()
                .map(transaction -> transactionMapper.fromEntity(transaction))
                .collect(Collectors.toList());
    }
}