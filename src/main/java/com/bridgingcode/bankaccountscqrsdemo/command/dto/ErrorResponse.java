package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    @ApiModelProperty(value = "errorMessage", example = "Failed to create account")
    private String errorMessage;
}
