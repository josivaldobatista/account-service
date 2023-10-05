package com.jfb.accountservice.controler;

import com.jfb.accountservice.dto.CustomerDto;
import com.jfb.accountservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer-account")
@Slf4j
public class CustomerAccountController extends BaseController {

    private final CustomerService customerService;

    public CustomerAccountController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CustomerDto customerDto) {
        try {
            CustomerDto newCustomer = customerService.save(customerDto);
            return getResponseSuccess(newCustomer);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return getResponseError(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return getResponseSuccess(customerService.getAll(), HttpStatus.OK);
    }
}
