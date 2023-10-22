package sk.tuke.virtualbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

public class CustomerServiceRestClient implements CustomerService{

    private String url = "http://localhost:8080/api/customer/lol";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void addCustomer(Customer customer) {
        restTemplate.postForEntity(url, customer, Customer.class);
    }

    @Override
    public List<Customer> getCustomers() {
        return null;
    }

    @Override
    public boolean isLoginCorrect(String login, String password) {
        return false;
    }

    @Override
    public boolean isTheSameCustomer(String login) {
        return false;
    }

    @Override
    public void removeCustomer(String login) {

    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported on web service");
    }
}
