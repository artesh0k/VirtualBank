package sk.tuke.virtualbank.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private int accountId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy="payer", fetch = FetchType.EAGER)
    private Set<Payment> payer_payments;

    @OneToMany(mappedBy="beneficiary", fetch = FetchType.EAGER)
    private Set<Payment> beneficiary_payments;

    @Column(nullable = false)
    private String IBAN;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private double balance;

    @Column(nullable = false)
    private Date createdAt;

    public Account() {
    }

    public Account(Customer customer, String IBAN, String type, double balance, Date createdAt) {
        this.customer = customer;
        this.IBAN = IBAN;
        this.type = type;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public int getAccountId() {
        return accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayer_payments() {
        return payer_payments;
    }

    public void setPayer_payments(Set<Payment> payer_payments) {
        this.payer_payments = payer_payments;
    }

    public Set<Payment> getBeneficiary_payments() {
        return beneficiary_payments;
    }

    public void setBeneficiary_payments(Set<Payment> beneficiary_payments) {
        this.beneficiary_payments = beneficiary_payments;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", customer=" + customer +
                ", payer_payments=" + payer_payments +
                ", beneficiary_payments=" + beneficiary_payments +
                ", IBAN='" + IBAN + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                '}';
    }
}
