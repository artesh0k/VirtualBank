package sk.tuke.virtualbank.service;


import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    boolean isLoginCorrect(String login, String password);

    boolean isTheSameUser(String login);

    void removeCustomer(Customer customer);

    void reset();
}
