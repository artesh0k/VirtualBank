package sk.tuke.virtualbank.service;

import sk.tuke.virtualbank.entity.Account;
import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

public class AccountServiceRestClient implements AccountService{
    @Override
    public void addAccount(Account account) {

    }

    @Override
    public List<Account> getAccounts(Customer customer) {
        return null;
    }

    @Override
    public void removeAccount(String IBAN) {

    }

    @Override
    public boolean isTheSameIBAN(String IBAN) {
        return false;
    }

    @Override
    public void reset() {

    }
}
