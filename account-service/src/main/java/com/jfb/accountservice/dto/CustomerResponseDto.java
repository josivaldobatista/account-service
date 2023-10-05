package com.jfb.accountservice.dto;

import lombok.Data;

@Data
public class CustomerResponseDto extends CustomerDto {

    private String accountNumber;
}
