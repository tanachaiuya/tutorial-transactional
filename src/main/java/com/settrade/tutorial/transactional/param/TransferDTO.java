package com.settrade.tutorial.transactional.param;

import com.settrade.tutorial.transactional.entity.BankAccount;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
public class TransferDTO {
    @NonNull
    private String fromAccountId;
    @NonNull
    private String toAccountId;

    @PositiveOrZero
    private BigDecimal amount;
}
