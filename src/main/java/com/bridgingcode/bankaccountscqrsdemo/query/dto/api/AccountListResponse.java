package com.bridgingcode.bankaccountscqrsdemo.query.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountListResponse {

    private List<AccountResponse> accounts;
}
