package com.settrade.tutorial.transactional;

import com.settrade.tutorial.transactional.Repository.BankAccountRepository;
import com.settrade.tutorial.transactional.entity.BankAccount;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;

@EnableSwagger2
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demoData(BankAccountRepository repo) {
        return args -> {
            BankAccount account1 = new BankAccount();
            account1.setAccountId("A");
            account1.setBalance(BigDecimal.valueOf(10000));
            repo.save(account1);

            BankAccount account2 = new BankAccount();
            account2.setAccountId("B");
            account2.setBalance(BigDecimal.valueOf(10000));
            repo.save(account2);
        };
    }

}
