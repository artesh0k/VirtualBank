package sk.tuke.virtualbank.service;


import sk.tuke.virtualbank.entity.Customer;
import sk.tuke.virtualbank.entity.Payment;

import java.util.List;

public interface PaymentService {

    void addPayment(Payment payment);

    List<Payment> getTransactions(Customer customer);

    boolean isPaymentPossible(Payment payment);

    void removePayment(Payment payment);

    void reset();

}
