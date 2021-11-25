package com.bridgingcode.bankaccountscqrsdemo.command.service;

import com.bridgingcode.bankaccountscqrsdemo.command.dto.api.*;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.CreateAccountCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.DepositMoneyCommand;
import com.bridgingcode.bankaccountscqrsdemo.command.dto.command.WithdrawMoneyCommand;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AccountCommandService {

    private final CommandGateway commandGateway;

    public AccountCommandService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public ResponseEntity<CreateAccountResponse> createAccount(CreateAccountRequest createAccountRequest) {

        try {
            String response = commandGateway.sendAndWait(
                    new CreateAccountCommand(UUID.randomUUID().toString(), createAccountRequest.getStartingBalance()));
            log.info("successfully created account with accountId {}", response);
            return new ResponseEntity<>(CreateAccountResponse.SUCCESS(response), HttpStatus.CREATED);
        } catch (Exception e) {
            log.info("exception occurred", e);
            return new ResponseEntity<>(CreateAccountResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<DepositResponse> depositToAccount(DepositRequest depositRequest) {
       try {
           CompletableFuture<Object> response = commandGateway.send(new DepositMoneyCommand(depositRequest.getAccountId(),
                   depositRequest.getAmount()));

           log.info("Deposit event completed.");
           DepositResponse depositResponse = new DepositResponse(depositRequest.getAccountId(), depositRequest.getAmount());
           return new ResponseEntity<>(depositResponse, HttpStatus.OK);
       } catch (Exception e) {
           log.info("exception occurred", e);
           return new ResponseEntity<>(DepositResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
       }


    }

    public ResponseEntity<WithdrawalResponse> withdrawFromAccount(WithdrawalRequest withdrawalRequest) {

        try {
            CompletableFuture<Object> response = commandGateway.send(
                    new WithdrawMoneyCommand(
                            withdrawalRequest.getAccountId(),
                            withdrawalRequest.getAmount()));

            log.info("Withdrawal event completed");
            WithdrawalResponse withdrawalResponse =
                    new WithdrawalResponse(withdrawalRequest.getAccountId(), withdrawalRequest.getAmount());
            return new ResponseEntity<>(withdrawalResponse, HttpStatus.OK);
        } catch (Exception e) {
            log.info("exception occurred", e);
            return new ResponseEntity<>(WithdrawalResponse.FAILED(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
