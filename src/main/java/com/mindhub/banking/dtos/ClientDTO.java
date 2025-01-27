package com.mindhub.banking.dtos;

import com.mindhub.banking.models.Client;
import com.mindhub.banking.models.ClientLoan;

import java.util.List;
import java.util.stream.Collectors;


public class ClientDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<AccountDTO> accounts;
    private List<ClientLoanDTO> clientLoans;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
        this.accounts = client.getAccounts().stream()
                .map(AccountDTO::new)
                .collect(Collectors.toList());
        this.clientLoans = client.getLoans().stream()
                .map(ClientLoanDTO::new)
                .collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
    }

    public List<ClientLoanDTO> getClientLoans() {
        return clientLoans;
    }

    public void setClientLoans(List<ClientLoanDTO> clientLoans) {
        this.clientLoans = clientLoans;
    }
}
