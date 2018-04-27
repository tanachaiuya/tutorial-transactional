package com.settrade.tutorial.transactional.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_account", uniqueConstraints = { @UniqueConstraint(columnNames = "accountId") } )
@Data
public class BankAccount implements Serializable {

    @Id @Column(name = "accountId")
    private String accountId;

    @Column(name = "balance", nullable = false)
    @PositiveOrZero
    private BigDecimal balance;
}
