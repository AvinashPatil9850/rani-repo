package com.example.crud.controller;

import com.example.crud.entity.Customer;
import com.example.crud.serivce.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
 public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(
            CustomerService customerService
    ) {

        this.customerService =
                customerService;
    }
    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer){
        return customerService.postCustomer((customer));
    }

    @GetMapping("/customers")
    public List<Customer> getAllCustomer(){
       return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer cs = customerService.getCustomerById(id);
        if(cs == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cs);
    }

@PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer existingCustomer = customerService.getCustomerById(id);
    if(existingCustomer == null){
        return  ResponseEntity.notFound().build();
    }
    existingCustomer.setName(customer.getName());
    existingCustomer.setEmail(customer.getEmail());
    existingCustomer.setPhone(customer.getPhone());

    Customer updatedCustomer = customerService.updateCustomer(existingCustomer);
return ResponseEntity.ok(updatedCustomer);
}

@DeleteMapping("customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id){
        Customer exCustomer = customerService.getCustomerById(id);
        if(exCustomer == null){
            return  ResponseEntity.notFound().build();
        }
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
}

}
