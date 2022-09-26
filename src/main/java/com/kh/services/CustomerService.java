package com.kh.services;

import com.kh.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    public List<Customer> listCustomers();
    public Customer getCustomerById(Long customerId);
    public Customer createCustomer(Customer customer);
    public boolean deleteCustomer(Long customerId);

}
