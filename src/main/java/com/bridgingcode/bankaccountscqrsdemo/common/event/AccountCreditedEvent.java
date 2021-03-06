package com.bridgingcode.bankaccountscqrsdemo.common.event;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class AccountCreditedEvent extends BaseEvent<String>{

    private final BigDecimal amount;

    public AccountCreditedEvent(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
