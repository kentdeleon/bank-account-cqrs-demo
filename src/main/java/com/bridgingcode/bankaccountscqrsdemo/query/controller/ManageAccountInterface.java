package com.bridgingcode.bankaccountscqrsdemo.query.controller;

import com.bridgingcode.bankaccountscqrsdemo.query.entity.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

@Api
public interface ManageAccountInterface {

    @ApiOperation(value = "", notes = "API to query account information", tags = {"manage-account-controller"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Account.class),
            @ApiResponse(code = 404, message = "Not Found", response = Account.class),
            @ApiResponse(code = 500, message = "Internal server error occurred", response = Account.class)})
    ResponseEntity<Account> getAccount(String id);
}
