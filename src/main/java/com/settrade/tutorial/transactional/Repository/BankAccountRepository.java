package com.settrade.tutorial.transactional.Repository;

import com.settrade.tutorial.transactional.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String>{
}
