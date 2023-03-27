package com.csi.controller;


import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceimpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer>saveData(@RequestBody Customer customer){
        return ResponseEntity.ok(customerServiceimpl.saveData(customer));
    }
    @GetMapping("/getdataid/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int cutId){
        return ResponseEntity.ok(customerServiceimpl.getDataById(cutId));
    }
    @GetMapping("/getalldata")
    public ResponseEntity<List<Customer>>getAllData(){
        return ResponseEntity.ok(customerServiceimpl.getAllData());
    }
    @PutMapping("/updatedata/{custId}")
    public ResponseEntity<Customer>updateData(@PathVariable int custId,@RequestBody Customer customer){
        Customer customer1=customerServiceimpl.getDataById(custId).orElseThrow(()->new RecordNotFoundException("customer Id Done"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustDOB(customer.getCustDOB());
        customer1.setCustAccountbalance(customer.getCustAccountbalance());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        customer1.setCustAddress(customer.getCustAddress());

        return ResponseEntity.ok(customerServiceimpl.updateData(customer1));

    }
    @DeleteMapping("/deletedataid/{custId}")
    public ResponseEntity<String>deleteDataId(@PathVariable int custId){
        customerServiceimpl.deletDataById(custId);
        return  ResponseEntity.ok("data deleted successfully");
    }





}
