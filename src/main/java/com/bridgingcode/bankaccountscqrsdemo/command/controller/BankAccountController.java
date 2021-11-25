package com.bridgingcode.bankaccountscqrsdemo.command.controller;

import com.bridgingcode.bankaccountscqrsdemo.command.dto.api.*;
import com.bridgingcode.bankaccountscqrsdemo.command.service.AccountCommandService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-account")
@Slf4j
public class BankAccountController implements BankAccountInterface {

    private final AccountCommandService accountCommandService;

    public BankAccountController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<CreateAccountResponse> createAccount(
            @ApiParam(required = true) @RequestBody CreateAccountRequest request) {

        return accountCommandService.createAccount(request);
    }

    @Override
    @PostMapping("/deposit")
    public ResponseEntity<DepositResponse> deposit(@ApiParam(required = true) @RequestBody DepositRequest request) {
       return accountCommandService.depositToAccount(request);
    }

    @Override
    @PostMapping("/withdraw")
    public ResponseEntity<WithdrawalResponse> withdraw(@ApiParam(required = true) @RequestBody WithdrawalRequest request) {
       return accountCommandService.withdrawFromAccount(request);
    }
}
