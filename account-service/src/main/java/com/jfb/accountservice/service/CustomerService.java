package com.jfb.accountservice.service;

import com.jfb.accountservice.dto.CustomerDto;
import com.jfb.accountservice.entity.Customer;
import com.jfb.accountservice.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerService(
            CustomerRepository customerRepository,
            ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    public CustomerDto save(CustomerDto customerDto) {
        Customer newCustomer = modelMapper.map(customerDto, Customer.class);
        newCustomer.setEnable(true);
        newCustomer.setAccountNumber("123456");
        customerRepository.save(newCustomer);

        return customerDto;
    }
}
