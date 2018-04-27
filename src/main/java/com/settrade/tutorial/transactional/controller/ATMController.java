package com.settrade.tutorial.transactional.controller;

import com.settrade.tutorial.transactional.param.TransferDTO;
import com.settrade.tutorial.transactional.response.BankAccountResponse;
import com.settrade.tutorial.transactional.service.AccountQueryService;
import com.settrade.tutorial.transactional.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atm")
public class ATMController {

    @Autowired
    TransferService transferService;

    @Autowired
    AccountQueryService accountQueryService;

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferDTO transferDTO) {
        transferService.transfer(transferDTO);
    }

    @GetMapping("/listAccount")
    public List<BankAccountResponse> listAccount() {
        return accountQueryService.listAccount();
    }
}
