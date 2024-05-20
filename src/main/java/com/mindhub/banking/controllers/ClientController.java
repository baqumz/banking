package com.mindhub.banking.controllers;

import com.mindhub.banking.dtos.ClientDTO;
import com.mindhub.banking.models.Client;
import com.mindhub.banking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository cliRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @RequestMapping(path = "/clients", method = RequestMethod.POST)
    public ResponseEntity<Object> register(
            @RequestParam String firstName
            ,@RequestParam String lastName
            ,@RequestParam String email
            ,@RequestParam String password
    ) {

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty())
            return new ResponseEntity<>("Valores Vacíos", HttpStatus.FORBIDDEN);

        if (cliRepo.findByEmail(email) != null)
            return new ResponseEntity<>("Ya existe el correo", HttpStatus.FORBIDDEN);

        cliRepo.save(new Client(firstName, lastName, email, passwordEncoder.encode(password)));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/clients/current")
    public ResponseEntity<ClientDTO> getAuthenticatedCustomer(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(new ClientDTO(cliRepo.findByEmail(authentication.getName())));
    }
}
