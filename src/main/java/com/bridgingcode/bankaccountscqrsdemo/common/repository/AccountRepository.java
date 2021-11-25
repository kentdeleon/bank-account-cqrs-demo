package com.bridgingcode.bankaccountscqrsdemo.common.repository;

import com.bridgingcode.bankaccountscqrsdemo.common.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}