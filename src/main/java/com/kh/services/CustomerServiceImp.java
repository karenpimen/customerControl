package com.kh.services;

import com.kh.exceptions.NotFoundException;
import com.kh.models.Customer;
import com.kh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    CustomerRepository customerRep;

    List<Customer> customers= new ArrayList<>();
    @Override
    @Transactional(readOnly = true)
    public List<Customer> listCustomers() {
        return (List<Customer>) customerRep.findAll();
    }
    @Override
    @Transactional(readOnly =true)
    public Customer getCustomerById(Long customerId) {
        return customerRep.findById(customerId).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional()
    public Customer createCustomer(Customer customer) {
        Customer outcome =customerRep.save(customer);
        return outcome;
    }

    @Override
    public boolean deleteCustomer(Long customer_id) {
        customerRep.deleteById(customer_id);
        return true;
    }


}
