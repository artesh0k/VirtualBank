package sk.tuke.virtualbank.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;

    @OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
    private Set<Account> accounts;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean admin;

    @Column(nullable = false)
    private Date createdAt;

    public Customer() {
    }

    public Customer(String name, String surname, String email, String login, String password, boolean admin, Date createdAt) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.createdAt = createdAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", accounts=" + accounts +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", createdAt=" + createdAt +
                '}';
    }
}
