package sk.tuke.virtualbank.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import sk.tuke.virtualbank.entity.Customer;

import java.util.List;

@Transactional
public class CustomerServiceJPA implements CustomerService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) {
        try {
            entityManager.persist(customer);
        } catch (PersistenceException e){
            System.out.println("Persistence error.");
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }

    @Override
    public boolean isLoginCorrect(String login, String password) {
        return (boolean) entityManager.createQuery("select case when (count(c) > 0)  then true else false end from Customer c where c.login = :login and c.password = :password")
                .setParameter("login", login)
                .setParameter("password", password)
                .getSingleResult();
    }

    @Override
    public boolean isTheSameCustomer(String login) {
        return (boolean) entityManager.createQuery("select case when (count(c) > 0)  then true else false end from Customer c where c.login = :login")
                .setParameter("login", login)
                .getSingleResult();
    }

    @Override
    public void removeCustomer(String login) {
        entityManager.createNativeQuery("DELETE FROM Customer c WHERE c.login = :login")
                .setParameter("login", login)
                .executeUpdate();
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM customer").executeUpdate();
    }
}
