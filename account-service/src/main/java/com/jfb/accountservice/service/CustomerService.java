package com.jfb.accountservice.service;

import com.jfb.accountservice.dto.CustomerDto;
import com.jfb.accountservice.dto.CustomerResponseDto;
import com.jfb.accountservice.entity.Customer;
import com.jfb.accountservice.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

import static com.jfb.accountservice.utils.AccountServiceUtils.createAccountNumber;

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

    public CustomerResponseDto save(CustomerDto customerDto) {
        Customer newCustomer = modelMapper.map(customerDto, Customer.class);
        newCustomer.setEnable(true);
        newCustomer.setAccountNumber(createAccountNumber());
        customerRepository.save(newCustomer);

        return modelMapper.map(customerRepository.save(newCustomer), CustomerResponseDto.class);
    }

    public List<CustomerResponseDto> getAll() {
        Type listType = new TypeToken<List<CustomerResponseDto>>() {}.getType();
        return modelMapper.map(customerRepository.findAll(), listType);
    }
}
