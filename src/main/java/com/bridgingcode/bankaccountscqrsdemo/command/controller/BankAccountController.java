package com.bridgingcode.bankaccountscqrsdemo.command.controller;

import com.bridgingcode.bankaccountscqrsdemo.command.dto.*;
import com.bridgingcode.bankaccountscqrsdemo.command.service.AccountCommandService;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

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
        try {
            CompletableFuture<String> response = accountCommandService.createAccount(request);
            final String accountId = response.get();
            log.info("successfully created account with accountId {}", accountId);
            return new ResponseEntity<>(CreateAccountResponse.SUCCESS(accountId), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(CreateAccountResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping("/deposit")
    public ResponseEntity<DepositResponse> deposit(@ApiParam(required = true) @RequestBody DepositRequest request) {
        try {
            accountCommandService.depositToAccount(request);
            log.info("successfully credited accountId {}", request.getAccountId());
            return new ResponseEntity<>(
                    new DepositResponse(request.getAccountId(), request.getAmount()),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(DepositResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @PostMapping("/withdraw")
    public ResponseEntity<WithdrawalResponse> withdraw(@ApiParam(required = true) @RequestBody WithdrawalRequest request) {
        try {
            accountCommandService.withdrawFromAccount(request);
            log.info("successfully debited accountId {}", request.getAccountId());
            return new ResponseEntity<>(new WithdrawalResponse(request.getAccountId(), request.getAmount()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(WithdrawalResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
