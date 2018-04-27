package com.settrade.tutorial.transactional.service;

import com.settrade.tutorial.transactional.Repository.BankAccountRepository;
import com.settrade.tutorial.transactional.entity.BankAccount;
import com.settrade.tutorial.transactional.response.BankAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class AccountQueryService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public List<BankAccountResponse> listAccount() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();
        return bankAccounts.stream().map(record -> {
            BankAccountResponse response = new BankAccountResponse();
            response.setAccountId(record.getAccountId());
            response.setBalance(record.getBalance());
            return response;
        }).collect(Collectors.toList());
    }
}
