package com.bridgingcode.bankaccountscqrsdemo.command.service.aggregate;

import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.CreateAccountCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.DepositMoneyCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.WithdrawMoneyCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountActivatedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountCreatedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountCreditedEvent;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.events.AccountDebitedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.math.BigDecimal;

@Aggregate
@Slf4j
public class AccountAggregate {

    @AggregateIdentifier
    private String accountId;

    private BigDecimal balance;

    private String status;

    public AccountAggregate(){}

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        log.info("CreateAccountCommand received. {}", createAccountCommand);

        AggregateLifecycle.apply(new AccountCreatedEvent(
                createAccountCommand.getId(),
                createAccountCommand.getBalance()
        ));
    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent accountCreatedEvent) {
        log.info("An AccountCreatedEvent occurred. {}", accountCreatedEvent);
        this.accountId = accountCreatedEvent.getId();
        this.balance = accountCreatedEvent.getBalance();
        this.status = "CREATED";

        AggregateLifecycle.apply(new AccountActivatedEvent(
                accountCreatedEvent.getId(),
                "ACTIVATED"));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent accountActivatedEvent) {
        log.info("An accountActivatedEvent occurred. {}", accountActivatedEvent);
        this.status = accountActivatedEvent.getStatus();

    }

    @CommandHandler
    public void on(DepositMoneyCommand depositMoneyCommand) {
        log.info("DepositMoneyCommand received {}", depositMoneyCommand);
        AggregateLifecycle.apply(new AccountCreditedEvent(
                depositMoneyCommand.getId(),
                depositMoneyCommand.getAmount()));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent accountCreditedEvent) {
        log.info("AccountCreditedEvent occurred. {}", accountCreditedEvent);
        this.balance = this.balance.add(accountCreditedEvent.getAmount());
    }

    @CommandHandler
    public void on(WithdrawMoneyCommand withdrawMoneyCommand) {
        log.info("DepositMoneyCommand received {}", withdrawMoneyCommand);
        AggregateLifecycle.apply(new AccountDebitedEvent(
                withdrawMoneyCommand.getId(),
                withdrawMoneyCommand.getAmount()));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent accountDebitedEvent) {
        log.info("AccountDebitedEvent occurred. {}", accountDebitedEvent);
        this.balance = this.balance.subtract(accountDebitedEvent.getAmount());
    }

}
