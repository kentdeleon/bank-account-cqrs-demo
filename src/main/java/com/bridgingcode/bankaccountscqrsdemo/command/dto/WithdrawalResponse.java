package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WithdrawalResponse {

    @ApiModelProperty(value = "account id", example = "3099c0f6-73f2-4b7f-9190-8b938a00a0d0")
    private String accountId;

    @ApiModelProperty(value = "amount debited", example = "1500.00")
    private BigDecimal amountDebited;

    @ApiModelProperty(value = "errorMessage", example = "Failed to withdraw from account")
    private String errorMessage;

    public WithdrawalResponse(String accountId, BigDecimal amountDebited) {
        this.accountId = accountId;
        this.amountDebited = amountDebited;
    }

    public static WithdrawalResponse FAILED() {
        WithdrawalResponse withdrawalResponse = new WithdrawalResponse();
        withdrawalResponse.setErrorMessage("Failed to withdraw from account");
        return withdrawalResponse;
    }
}
