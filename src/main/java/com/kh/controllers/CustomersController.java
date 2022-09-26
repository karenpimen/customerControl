package com.kh.controllers;


import com.kh.models.Customer;
import com.kh.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class CustomersController {
    @Autowired
    private CustomerService customerService;



    @GetMapping("/addCustomer")
    public String add(Customer customer) {
        return "customer";
    }

    @GetMapping("/update/{customer_id}")
    public String update(Customer customer, Model model) {
        Customer customer1 = customerService.getCustomerById(customer.getCustomer_id());
        model.addAttribute("customer", customer1);
        return "customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(Customer customer,Model model){
        List<Customer> list = new ArrayList<>();
        Customer c = customerService.createCustomer(customer);
        if(c!=null){
            list.add(c);
        }
        model.addAttribute("customers",list);
        return "customers";
    }

    @GetMapping("/delete")
    public String customer(Customer customer){
        customerService.deleteCustomer(customer.getCustomer_id());
        return "customers";
    }
}
