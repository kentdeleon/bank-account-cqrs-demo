package com.bridgingcode.bankaccountscqrsdemo.query.service;

import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountListResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.api.AccountResponse;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.queries.AccountByIdQuery;
import com.bridgingcode.bankaccountscqrsdemo.query.dto.queries.AllAccountQuery;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class AccountQueryService {

    private final QueryGateway queryGateway;

    public AccountQueryService(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }


    public ResponseEntity<AccountListResponse> getAllAccount() {
        log.info("Get All account.");

        AccountListResponse accounts = queryGateway.query(new AllAccountQuery(), AccountListResponse.class).join();

        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    public ResponseEntity<AccountResponse> getAccount(String id) {
        log.info("Get account with id {}", id);

        AccountResponse account = queryGateway.query(new AccountByIdQuery(id), AccountResponse.class).join();

        if(Objects.isNull(account)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
