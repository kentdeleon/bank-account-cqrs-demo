package com.bridgingcode.bankaccountscqrsdemo.command.command;

import lombok.ToString;

import java.math.BigDecimal;

@ToString(callSuper = true)
public class CreateAccountCommand  extends BaseCommand<String>{

    private final BigDecimal balance;

    public CreateAccountCommand(String id, BigDecimal balance) {
        super(id);
        this.balance = balance;
    }

    public BigDecimal getBalance(){
        return balance;
    }
}
