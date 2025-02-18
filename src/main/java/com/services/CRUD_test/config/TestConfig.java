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

        Team t1 = new Team(null, "McLaren", 1, "MCL39");
        Team t4 = new Team(null, "Ferrari", 2, "SF-25");
        Team t6 = new Team(null, "Red Bull", 3, "RB21");
        Team t7 = new Team(null, "Mercedes", 4, "W16");
        Team t10 = new Team(null, "Aston Martin", 5, "AMR25");
        Team t9 = new Team(null, "Alpine", 6, "A525");
        Team t2 = new Team(null, "Haas", 7, "VF-25");
        Team t5 = new Team(null, "Racing Bulls", 8, "VCARB 02");
        Team t3 = new Team(null, "Williams", 9, "FW47");
        Team t8 = new Team(null, "Sauber", 10, "C45");
        
        

        teamRepository.saveAll(Arrays.asList(t9, t10, t4, t2, t1, t7, t5, t6, t8, t3));
        
        Driver d1 = new Driver(null, "Lando Norris", 4, t1);
        Driver d2 = new Driver(null, "Oscar Piastri", 81, t1); 
        Driver d3 = new Driver(null, "Esteban Ocon", 31, t2);
        Driver d4 = new Driver(null, "Oliver Bearman", 87, t2); 
        Driver d5 = new Driver(null, "Carlos Sainz", 55, t3);
        Driver d6 = new Driver(null, "Alexander Albon", 23, t3); 
        Driver d7 = new Driver(null, "Lewis Hamilton", 44, t4);
        Driver d8 = new Driver(null, "Charles Leclerc", 16, t4); 
        Driver d9 = new Driver(null, "Isaac Hadjar", 6, t5);
        Driver d10 = new Driver(null, "Yuki Tsunoda", 22, t5); 
        Driver d11 = new Driver(null, "Max Verstappen", 1, t6);
        Driver d12 = new Driver(null, "Liam Lawson", 30, t6); 
        Driver d13 = new Driver(null, "George Russel", 63, t7);
        Driver d14 = new Driver(null, "Andrea Kimi Antonelli", 12, t7); 
        Driver d15 = new Driver(null, "Gabriel Bortoleto", 5, t8);
        Driver d16 = new Driver(null, "Nico Hulkemberg", 27, t8); 
        Driver d17 = new Driver(null, "Jack Doohan", 7, t9);
        Driver d18 = new Driver(null, "Pierre Gasly", 10, t9); 
        Driver d19 = new Driver(null, "Fernando Alonso", 14, t10);
        Driver d20 = new Driver(null, "Lance Stroll", 18, t10); 
        
        
        driverRepository.saveAll(Arrays.asList(d6, d14, d5, d8, d3, d19, d15, d13, d9, d17, d20, d1, d7, d12, d11, d16, d4, d2, d18, d10));

        

    }
    
}
