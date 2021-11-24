package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class CreateAccountRequest {

    @ApiModelProperty(value = "starting balance", example = "1000.00")
    private BigDecimal startingBalance;
}
