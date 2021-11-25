package com.bridgingcode.bankaccountscqrsdemo.query.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByAccountIdQueryEvent {

    private String accountId;
}
