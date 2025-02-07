package com.services.CRUD_test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.services.CRUD_test.repository.DriverRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @SuppressWarnings("unused")
    @Autowired
    private DriverRepository repository;


    @Override
    public void run(String... args) throws Exception {
        
        
    }
    
}
