package com.mindhub.banking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    private TransactionType type;
    private LocalDate transactionDate;
    private String description;
    private Double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id")
    private Account account;

    public Transaction() {}

    public Transaction(TransactionType type, LocalDate transactionDate, String description, Double amount, Account account) {
        this.type = type;
        this.transactionDate = transactionDate;
        this.description = description;
        if(type.equals(TransactionType.CREDIT) && amount < 0)
            this.amount = amount*-1;
        else if (type.equals(TransactionType.CREDIT) && amount > 0)
            this.amount = amount;
        else if (type.equals(TransactionType.DEBIT) && amount < 0)
            this.amount = amount;
        else
            this.amount = amount*-1;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
