package com.services.CRUD_test.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.services.CRUD_test.entities.Driver;
import com.services.CRUD_test.entities.Team;
import com.services.CRUD_test.repository.DriverRepository;
import com.services.CRUD_test.repository.TeamRepository;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public void run(String... args) throws Exception {

        Team t1 = new Team(null, "McLaren", 1, "MCL38");

        teamRepository.saveAll(Arrays.asList(t1));
        
        Driver d1 = new Driver(null, "Lando Norris", 4, t1);
        Driver d2 = new Driver(null, "Oscar Piastri", 81, t1); 
        
        driverRepository.saveAll(Arrays.asList(d1, d2));

        

    }
    
}
