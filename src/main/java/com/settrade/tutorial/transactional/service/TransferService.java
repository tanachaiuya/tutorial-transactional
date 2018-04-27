package com.settrade.tutorial.transactional.service;

import com.settrade.tutorial.transactional.param.TransferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class TransferService {
    @Autowired
    DepositService depositService;

    @Autowired
    WithdrawService withdrawService;

    @Transactional
    public void transfer(TransferDTO transferDTO) {
        withdrawService.withdraw(transferDTO.getFromAccountId(), transferDTO.getAmount());
        depositService.deposit(transferDTO.getToAccountId(), transferDTO.getAmount());
    }
}
