package com.bridgingcode.bankaccountscqrsdemo.query.service.projection;

import com.bridgingcode.bankaccountscqrsdemo.common.entity.Account;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountListResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.event.FindAllAccountQueryEvent;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.event.FindByAccountIdQueryEvent;
import com.bridgingcode.bankaccountscqrsdemo.query.service.event.AccountQueryEventService;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.queries.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Slf4j
public class AccountProjection {

    private final AccountQueryEventService accountQueryEventService;

    public AccountProjection(AccountQueryEventService accountQueryEventService) {
        this.accountQueryEventService = accountQueryEventService;
    }

    @QueryHandler
    public AccountResponse handle(AccountByIdQuery query) {
        log.info("AccountProjection findById");
        Account account = accountQueryEventService.findById(new FindByAccountIdQueryEvent(query.getAccountId()));
        return buildResponse(account);
    }

    @QueryHandler
    public AccountListResponse handle(AllAccountQuery query) {
        log.info("Handling FindAllAccount");
        List<Account> accounts = accountQueryEventService.findAll(new FindAllAccountQueryEvent());
        return new AccountListResponse(
                accounts.stream()
                        .map(this::buildResponse)
                .collect(Collectors.toList()));
    }

    private AccountResponse buildResponse(Account account) {
        if(Objects.nonNull(account)) {
            return AccountResponse.builder()
                    .accountId(account.getAccountId())
                    .balance(account.getBalance())
                    .status(account.getStatus())
                    .build();
        }

        return new AccountResponse();

    }

}
