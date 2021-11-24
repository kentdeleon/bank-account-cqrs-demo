package com.bridgingcode.bankaccountscqrsdemo.command.command;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class WithdrawMoneyCommand extends BaseCommand<String> {

    private final BigDecimal amount;

    public WithdrawMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}