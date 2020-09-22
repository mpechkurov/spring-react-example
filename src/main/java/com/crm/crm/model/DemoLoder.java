package com.crm.crm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoLoder implements CommandLineRunner{
    
    private final ContacRepository repository;


    @Autowired
    public DemoLoder(ContacRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) throws Exception {
        this.repository.save(new Contact("Emanuel", "Henri","emanuel.henri@test.com"));
    }
}
