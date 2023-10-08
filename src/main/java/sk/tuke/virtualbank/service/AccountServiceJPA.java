package sk.tuke.virtualbank.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.tuke.virtualbank.entity.Account;
import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

@Transactional
public class AccountServiceJPA implements AccountService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAccount(Account account) {
        entityManager.persist(account);
    }

    @Override
    public List<Account> getAccounts(Customer customer) {
        return entityManager.createQuery("select a from Account a where a.customer = :customer")
                .setParameter("customer", customer)
                .getResultList();
    }

    @Override
    public void removeAccount(String IBAN) {
        entityManager.createNativeQuery("DELETE FROM Account a WHERE a.iban = :iban")
                .setParameter("iban", IBAN)
                .executeUpdate();

    }

    @Override
    public boolean isTheSameIBAN(String IBAN) {
        return (boolean) entityManager.createQuery("select case when (count(a) > 0)  then true else false end from Account a where a.IBAN = :IBAN")
                .setParameter("IBAN", IBAN)
                .getSingleResult();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM account").executeUpdate();
    }
}
