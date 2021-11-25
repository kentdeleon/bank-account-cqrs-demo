package com.bridgingcode.bankaccountscqrsdemo.command.dto.events;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class AccountCreatedEvent extends BaseEvent<String>{

    private final BigDecimal balance;

    public AccountCreatedEvent(String id, BigDecimal balance) {
        super(id);
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
