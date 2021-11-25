package com.bridgingcode.bankaccountscqrsdemo.query.service.event;

import com.bridgingcode.bankaccountscqrsdemo.common.entity.Account;
import com.bridgingcode.bankaccountscqrsdemo.common.repository.AccountRepository;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.event.FindAllAccountQueryEvent;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.event.FindByAccountIdQueryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AccountQueryEventService   {

    private final AccountRepository accountRepository;

    public AccountQueryEventService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(FindByAccountIdQueryEvent event) {
        log.info("Handling FindAccountByIdQuery");
        return accountRepository.findById(event.getAccountId()).orElse(null);
    }

    public List<Account> findAll(FindAllAccountQueryEvent event) {
        log.info("Handling FindAllAccount");
        return accountRepository.findAll();
    }
}
