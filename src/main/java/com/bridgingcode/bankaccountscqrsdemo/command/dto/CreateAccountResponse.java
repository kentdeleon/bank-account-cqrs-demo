package com.bridgingcode.bankaccountscqrsdemo.command.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateAccountResponse {

    @ApiModelProperty(value = "message", example = "Successfully created account")
    private String message;

    @ApiModelProperty(value = "account id", example = "25232318-6c54-4b4a-878b-9a7d7cc2a993")
    private String accountId;

    public static CreateAccountResponse SUCCESS(String accountId) {
        return new CreateAccountResponse("Successfully created account", accountId);
    }

    public static CreateAccountResponse FAILED() {
        return new CreateAccountResponse("Failed to create account", null);
    }
}
