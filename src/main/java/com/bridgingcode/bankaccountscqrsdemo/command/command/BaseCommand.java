package com.bridgingcode.bankaccountscqrsdemo.command.command;

import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@ToString
public class BaseCommand<T>{

    @TargetAggregateIdentifier
    private final T id;

    public BaseCommand(T id){
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
