package com.bridgingcode.bankaccountscqrsdemo.query.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponse {

    private String accountId;
    private BigDecimal balance;
    private String status;

}
