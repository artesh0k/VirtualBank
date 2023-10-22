package sk.tuke.virtualbank.server.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;
import sk.tuke.virtualbank.entity.Customer;
import sk.tuke.virtualbank.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@EntityScan(basePackages = "sk.tuke.virtualbank.entity")
public class CustomerServiceRest {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @PostMapping("/lol")
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
}
