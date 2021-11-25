package com.bridgingcode.bankaccountscqrsdemo.query.controller;

import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountListResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.service.AccountQueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage-account")
@Slf4j
public class ManageAccountController implements ManageAccountInterface{

    private final AccountQueryService queryService;

    public ManageAccountController(AccountQueryService queryService) {
        this.queryService = queryService;
    }

    @Override
    @GetMapping("/get-account")
    public ResponseEntity<AccountListResponse> getAllAccount() {
        return queryService.getAllAccount();
    }

    @Override
    @GetMapping("/get-account/{id}")
    public ResponseEntity<AccountResponse> getAccount(@PathVariable String id) {
        return queryService.getAccount(id);
    }
}
