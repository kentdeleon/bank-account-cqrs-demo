package com.bridgingcode.bankaccountscqrsdemo.query.dto.queries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountByIdQuery {

    private String accountId;
}
