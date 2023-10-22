package sk.tuke.virtualbank.core;

import org.springframework.beans.factory.annotation.Autowired;
import sk.tuke.virtualbank.entity.Account;
import sk.tuke.virtualbank.entity.Customer;
import sk.tuke.virtualbank.entity.Payment;
import sk.tuke.virtualbank.service.AccountService;
import sk.tuke.virtualbank.service.AccountServiceJPA;
import sk.tuke.virtualbank.service.CustomerService;
import sk.tuke.virtualbank.service.PaymentService;

import java.util.Date;
import java.util.List;

public class Console {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private NumberGenerator numberGenerator;

    public void play() {
        Customer customer1 = new Customer("v1","v1","email1", "login1",
                "password1", false, new Date());
        Customer customer2 = new Customer("v2","v2","email2", "login2",
                "password2", false, new Date());
        Customer customer3 = new Customer("v3","v3","email3", "login3",
                "password3", false, new Date());

        customerService.addCustomer(customer1);
        customerService.addCustomer(customer2);
        customerService.addCustomer(customer3);

//        var customers = customerService.getCustomers();
//        for ( Customer customer : customers){
//            System.out.println(customer.toString());
//        }
//
//        System.out.println(customerService.isLoginCorrect("login2", "password2"));
//        System.out.println(customerService.isLoginCorrect("login3", "password2"));
//
//        System.out.println(customerService.isTheSameCustomer("login2"));
//        System.out.println(customerService.isTheSameCustomer("login33"));
//
//        customerService.removeCustomer("login2");

        Account account1 = new Account(customer1, numberGenerator.generateIBAN(), "credit", 3.3, new Date());
        Account account2 = new Account(customer1, numberGenerator.generateIBAN(), "credit", 34.3, new Date());
        Account account3 = new Account(customer2, numberGenerator.generateIBAN(), "credit", 344.3, new Date());

        accountService.addAccount(account1);
        accountService.addAccount(account2);
        accountService.addAccount(account3);
//
//        Payment payment1 = new Payment(account1, account2, 3,null, null, null,"hi", new Date());
//        Payment payment2 = new Payment(account1, account3, 100,null, null, null,"hi", new Date());
//
//        System.out.println(paymentService.isPaymentPossible(payment1));
//        System.out.println(paymentService.isPaymentPossible(payment2));
//
//        paymentService.addPayment(payment1);
//        paymentService.addPayment(payment2);

    }
}
