package com.bridgingcode.bankaccountscqrsdemo.command.dto.events;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class AccountDebitedEvent extends BaseEvent<String>{

    private final BigDecimal amount;

    public AccountDebitedEvent(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
