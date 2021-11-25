package com.bridgingcode.bankaccountscqrsdemo.command.dto.events;

import lombok.ToString;

@ToString(callSuper = true)
public class AccountActivatedEvent extends BaseEvent<String>{

    private final String status;

    public AccountActivatedEvent(String id, String status) {
        super(id);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
