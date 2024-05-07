package com.mindhub.banking.controllers;

import com.mindhub.banking.dtos.AccountDTO;
import com.mindhub.banking.models.Account;
import com.mindhub.banking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private AccountRepository a;

    @RequestMapping("/accounts")
    public List<AccountDTO> getClients() {
        return a.findAll()
                .stream()
                .map(AccountDTO::new)
                .collect(toList());
    }

    @RequestMapping("accounts/{id}")
    public AccountDTO getAccount(@PathVariable Long id) {
        Optional<Account> optionalClient = a.findById(id);
        return optionalClient.map(AccountDTO::new).orElse(null);
    }
}
