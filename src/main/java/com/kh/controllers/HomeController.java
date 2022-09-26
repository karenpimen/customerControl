package com.kh.controllers;

import com.kh.exceptions.NotFoundException;
import com.kh.models.Customer;
import com.kh.services.CustomerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private CustomerServiceImp customerService;

    @GetMapping("/")
    public String start() {
        log.info("Starting goToCustomer controller");
        return "index";
    }

    @GetMapping("/searchById")
    public String searchById(@RequestParam(value = "customer_id") String customer_id,
                             Model model) {
        List<Customer> customers = new ArrayList<>();
        Customer c = customerService.getCustomerById(Long.parseLong(customer_id));
        if (c != null) {
            customers.add(c);
        }
        model.addAttribute("customers", customers);
        return "customers";
    }
    @ExceptionHandler(NumberFormatException.class)
    public String handlerNumberFormatException(NumberFormatException e){
        return "exceptionNumberFormat";
    }

    @ExceptionHandler(NotFoundException.class)
    public String handlerNumberFormatException(NotFoundException e) {
        return "exceptionNotFound";
    }

}
