package com.sales.client.rest;

import java.util.List;

import com.sales.client.dto.ClientDto;
import com.sales.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity createClient(@RequestBody ClientDto clientDto){
        clientService.save(clientDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{clientId}")
    public ResponseEntity updateClient(@PathVariable Long clientId, @RequestBody ClientDto clientDto){
        clientService.update(clientDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity deleteClient(@PathVariable Long clientId){
        clientService.delete(clientId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long clientId){
        return ResponseEntity.ok(clientService.findByClientId(clientId));
    }

}
