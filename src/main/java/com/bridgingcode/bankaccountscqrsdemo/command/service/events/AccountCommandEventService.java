package com.bridgingcode.bankaccountscqrsdemo.command.service.events;

import com.bridgingcode.bankaccountscqrsdemo.common.entity.Account;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountActivatedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountCreatedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountCreditedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountDebitedEvent;
import com.bridgingcode.bankaccountscqrsdemo.common.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@ProcessingGroup("account")
public class AccountCommandEventService {

    private final AccountRepository accountRepository;

    public AccountCommandEventService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @EventHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        log.info("Handling AccountCreatedEvent...");
        Account account = new Account();
        account.setAccountId(accountCreatedEvent.getId());
        account.setBalance(accountCreatedEvent.getBalance());
        account.setStatus("CREATED");

        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent accountActivatedEvent) {
        log.info("Handling AccountActivatedEvent...");

        Account account = accountRepository.findById(accountActivatedEvent.getId())
                .orElse(null);

        if(Objects.nonNull(account)) {
            account.setStatus(accountActivatedEvent.getStatus());
            accountRepository.save(account);
        }
    }

    @EventHandler
    public void on(AccountCreditedEvent accountCreditedEvent) {
        log.info("Handling AccountCreditEvent");

        Account account = accountRepository.findById(accountCreditedEvent.getId())
                .orElse(null);


        if(Objects.nonNull(account)) {
            account.setBalance(account.getBalance().add(accountCreditedEvent.getAmount()));
            accountRepository.save(account);
        }
    }

    @EventHandler
    public void on(AccountDebitedEvent accountDebitedEvent) {
        log.info("Handling AccountDebitedEvent");

        Account account = accountRepository.findById(accountDebitedEvent.getId())
                .orElse(null);

        if(Objects.nonNull(account)) {
            account.setBalance(account.getBalance().subtract(accountDebitedEvent.getAmount()));
            accountRepository.save(account);
        }
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        log.info("exception occurred", exception);
        throw exception;
    }
}
