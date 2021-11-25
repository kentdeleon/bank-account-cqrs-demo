package com.bridgingcode.bankaccountscqrsdemo.command.dto.events;

import lombok.ToString;

@ToString
public class BaseEvent<T> {

    private T id;

    public BaseEvent(T id) {
        this.id = id;
    }

    public T getId(){
        return id;
    }
}
