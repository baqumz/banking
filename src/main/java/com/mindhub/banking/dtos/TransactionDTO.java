package com.mindhub.banking.dtos;

import com.mindhub.banking.models.Account;
import com.mindhub.banking.models.Transaction;
import com.mindhub.banking.models.TransactionType;

import java.time.LocalDate;

public class TransactionDTO {

    private TransactionType type;
    private LocalDate transactionDate;
    private String description;
    private Double amount;

    public TransactionDTO(Transaction t) {
        this.type = t.getType();
        this.transactionDate = t.getTransactionDate();
        this.description = t.getDescription();
        this.amount = t.getAmount();
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
}
