package com.bridgingcode.bankaccountscqrsdemo.command.dto.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositResponse extends ErrorResponse {

    @ApiModelProperty(value = "account id", example = "3099c0f6-73f2-4b7f-9190-8b938a00a0d0")
    private String accountId;

    @ApiModelProperty(value = "new balance", example = "1500.00")
    private BigDecimal amountCredited;

    @ApiModelProperty(value = "errorMessage", example = "Failed to deposit money")
    private String errorMessage;

    public DepositResponse(String accountId, BigDecimal amountCredited) {
        this.accountId = accountId;
        this.amountCredited = amountCredited;
    }

    public static DepositResponse FAILED(){
        return new DepositResponse(null, null, "Failed to deposit money");
    }
}
