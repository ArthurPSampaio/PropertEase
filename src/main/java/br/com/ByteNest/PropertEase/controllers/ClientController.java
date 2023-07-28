package br.com.ByteNest.PropertEase.controllers;


import br.com.ByteNest.PropertEase.models.clients.RegisterClientData;
import br.com.ByteNest.PropertEase.models.clients.Client;
import br.com.ByteNest.PropertEase.models.clients.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Validated RegisterClientData data) {
        Client client = new Client(data);
        repository.save(client);

        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }
}
