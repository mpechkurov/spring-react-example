package com.crm.crm.model;

import java.net.URISyntaxException;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    private ContacRepository contacRepository;

    public ContactController(ContacRepository contacRepository){
        this.contacRepository = contacRepository;
    }

    @GetMapping("/contacts")
    Collection<Contact> contacts(){
        return (Collection<Contact>) contacRepository.findAll();
    }

    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws URISyntaxException{
        Contact result = contacRepository.save(contact);
        return ResponseEntity.ok().body(result);
    }

}
