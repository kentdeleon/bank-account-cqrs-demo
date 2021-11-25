package com.bridgingcode.bankaccountscqrsdemo.command.dto.command;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class DepositMoneyCommand extends BaseCommand<String>{

    private final BigDecimal amount;

    public DepositMoneyCommand(String id, BigDecimal amount) {
        super(id);
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return amount;
    }
}