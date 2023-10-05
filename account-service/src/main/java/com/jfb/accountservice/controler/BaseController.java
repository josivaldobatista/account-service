package com.jfb.accountservice.controler;

import com.jfb.accountservice.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseController {

    @Autowired
    private Environment environment;

    private String getPort() {
        return environment.getProperty("local.server.port");
    }

    protected ResponseEntity<?> getResponseError(String message) {
        return new ResponseEntity<>(ResponseDto.builder()
                .port(getPort())
                .message(message)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<?> getResponseSuccess(Object data) {
        return new ResponseEntity<>(ResponseDto.builder()
                .data(data)
                .port(getPort())
                .message("Conta registrada com sucesso")
                .build(), HttpStatus.CREATED);
    }

    protected ResponseEntity<?> getResponseSuccess(Object data, HttpStatus status) {
        return new ResponseEntity<>(ResponseDto.builder()
                .data(data)
                .port(getPort())
                .build(), status);
    }
}
