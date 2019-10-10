package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    // GET http://localhost:2020/customers/customer/order --- all customers w/ their orders
    @GetMapping(value = "/customer/order",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerService.findOrders();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // POST http://localhost:2020/customers/customer/new --- saving
    @PostMapping(value = "/customer/new",
            consumes = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                                @RequestBody Customer newCustomer)
    {
        newCustomer = customerService.save(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    // PUT http://localhost:2020/customers/customer/update/{custcode} --- updating
    // DELETE http://localhost:2020/customers/customer/delete/{custcode} --- deleting
}
