package com.jfb.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {

    private Object data;

    // Se for null, irá excluir essa propiedade
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    private String port;
}
