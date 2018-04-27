package com.settrade.tutorial.transactional.response;

import lombok.Data;

import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BankAccountResponse implements Serializable{
    private String accountId;

    @PositiveOrZero
    private BigDecimal balance;

}
