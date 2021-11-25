package com.bridgingcode.bankaccountscqrsdemo.command.controller;

import com.bridgingcode.bankaccountscqrsdemo.command.dto.api.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api
public interface BankAccountInterface {

    @ApiOperation(value = "", notes = "API to create Customer account", tags = {"bank-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CreateAccountResponse.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = CreateAccountResponse.class)})
    ResponseEntity<CreateAccountResponse> createAccount(CreateAccountRequest request);

    @ApiOperation(value = "", notes = "API to deposit money to Customer account", tags = {"bank-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CreateAccountResponse.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = CreateAccountResponse.class)})
    ResponseEntity<DepositResponse> deposit(DepositRequest request);


    @ApiOperation(value = "", notes = "API to withdraw money from Customer account ", tags = {"bank-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = CreateAccountResponse.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = CreateAccountResponse.class)})
    ResponseEntity<WithdrawalResponse> withdraw(WithdrawalRequest request);
}
