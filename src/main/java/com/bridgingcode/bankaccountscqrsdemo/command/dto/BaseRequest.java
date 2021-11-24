package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class BaseRequest {

    @ApiModelProperty(value = "account id", example = "3099c0f6-73f2-4b7f-9190-8b938a00a0d0")
    private String accountId;

    @ApiModelProperty(value = "amount to deposit", example = "500.00")
    private BigDecimal amount;
}
