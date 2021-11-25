package com.bridgingcode.bankaccountscqrsdemo.query.controller;

import com.bridgingcode.bankaccountscqrsdemo.common.entity.Account;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountListResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api
public interface ManageAccountInterface {

    @ApiOperation(value = "", notes = "API to query account information", tags = {"manage-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = AccountResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = AccountResponse.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = AccountResponse.class)})
    ResponseEntity<AccountResponse> getAccount(String id);

    @ApiOperation(value = "", notes = "API to query account information", tags = {"manage-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 404, message = "Not Found", response = Account.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = Account.class)})
    ResponseEntity<AccountListResponse> getAllAccount();
}
