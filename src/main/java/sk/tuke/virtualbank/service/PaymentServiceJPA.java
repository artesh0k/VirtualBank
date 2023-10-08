package sk.tuke.virtualbank.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import sk.tuke.virtualbank.entity.Customer;
import sk.tuke.virtualbank.entity.Payment;

import java.util.List;

@Transactional
public class PaymentServiceJPA implements PaymentService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addPayment(Payment payment) {
        entityManager.persist(payment);

        entityManager.createQuery("update Account a set a.balance = a.balance - :amount where a.accountId = :payerId")
                .setParameter("amount", payment.getAmount())
                .setParameter("payerId", payment.getPayer().getAccountId())
                .executeUpdate();

        entityManager.createQuery("update Account a set a.balance = a.balance + :amount where a.accountId = :beneficiaryId")
                .setParameter("amount", payment.getAmount())
                .setParameter("beneficiaryId", payment.getBeneficiary().getAccountId())
                .executeUpdate();
    }

    @Override
    public List<Payment> getTransactions(Customer customer) {
        return entityManager.createQuery("select p from Payment p where p.payer = :payer or p.beneficiary = :beneficiary")
                .setParameter("payer", customer)
                .setParameter("beneficiary", customer)
                .getResultList();
    }

    @Override
    public boolean isPaymentPossible(Payment payment) {
        boolean rule1 = (boolean) entityManager.createQuery("select case when (count(a) = 1) then true else false end from Account a where a.IBAN = :IBAN")
                .setParameter("IBAN", payment.getPayer().getIBAN())
                .getSingleResult();

        boolean rule2 = (boolean) entityManager.createQuery("select case when (count(a) = 1) then true else false end from Account a where a.IBAN = :IBAN")
                .setParameter("IBAN", payment.getBeneficiary().getIBAN())
                .getSingleResult();

        boolean rule3 = (boolean) entityManager.createQuery("select case when (a.balance >= :amount) then true else false end from Account a where a.IBAN = :IBAN")
                .setParameter("amount", payment.getAmount())
                .setParameter("IBAN", payment.getPayer().getIBAN())
                .getSingleResult();

        return rule1 && rule2 && rule3;
    }

    @Override
    public void reset() {
        entityManager.createNativeQuery("DELETE FROM payment").executeUpdate();
    }
}
