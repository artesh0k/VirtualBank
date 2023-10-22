package sk.tuke.virtualbank.service;

import sk.tuke.virtualbank.entity.Customer;
import sk.tuke.virtualbank.entity.Payment;

import java.util.List;

public class PaymentServiceRestClient implements PaymentService{
    @Override
    public void addPayment(Payment payment) {

    }

    @Override
    public List<Payment> getTransactions(Customer customer) {
        return null;
    }

    @Override
    public boolean isPaymentPossible(Payment payment) {
        return false;
    }

    @Override
    public void reset() {

    }
}
