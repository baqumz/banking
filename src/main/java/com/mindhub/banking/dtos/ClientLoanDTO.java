package com.mindhub.banking.dtos;

import com.mindhub.banking.models.ClientLoan;

public class ClientLoanDTO {

    private Long id;
    private Long loanId;
    private String name;
    Double amount;
    private Integer payments;

    public ClientLoanDTO() {
    }

    public ClientLoanDTO(ClientLoan cl) {
        this.id = cl.getId();
        this.loanId = cl.getLoan().getId();
        this.name = cl.getLoan().getName();
        this.amount = cl.getAmount();
        this.payments = cl.getPayments();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getPayments() {
        return payments;
    }

    public void setPayments(Integer payments) {
        this.payments = payments;
    }
}
