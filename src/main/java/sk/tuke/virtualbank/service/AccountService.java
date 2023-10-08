package sk.tuke.virtualbank.service;

import sk.tuke.virtualbank.entity.Account;
import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

public interface AccountService {

    void addAccount(Account account);

    List<Account> getAccounts(Customer customer);

    void removeAccount(String IBAN);

    boolean isTheSameIBAN(String IBAN);

    void reset();

}
