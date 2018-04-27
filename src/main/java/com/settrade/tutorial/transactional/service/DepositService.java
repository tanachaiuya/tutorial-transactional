package com.settrade.tutorial.transactional.service;

import com.settrade.tutorial.transactional.Repository.BankAccountRepository;
import com.settrade.tutorial.transactional.entity.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
public class DepositService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Transactional
    public void deposit(String accountId, BigDecimal amt){
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(
                () -> new NestedRuntimeException(String.format("BankAccount[%s] not found.", accountId)) {});
        bankAccount.setBalance(bankAccount.getBalance().add(amt));
        bankAccountRepository.save(bankAccount);
    }
}
