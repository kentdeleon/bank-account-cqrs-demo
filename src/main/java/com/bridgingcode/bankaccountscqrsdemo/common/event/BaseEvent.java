package com.bridgingcode.bankaccountscqrsdemo.common.event;

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
