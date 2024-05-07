package com.mindhub.banking.controllers;

import com.mindhub.banking.dtos.ClientDTO;
import com.mindhub.banking.models.Client;
import com.mindhub.banking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository cliRepo;

    @RequestMapping("/clients")
    public List<ClientDTO> getClients() {
        return cliRepo.findAll()
                .stream()
                .map(ClientDTO::new)
                .collect(toList());
    }

    @RequestMapping("clients/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        Optional<Client> optionalClient = cliRepo.findById(id);
        return optionalClient.map(ClientDTO::new).orElse(null);
    }

}
