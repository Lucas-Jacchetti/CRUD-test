package com.services.CRUD_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.services.CRUD_test.entities.Driver;

public interface DriverRepository extends JpaRepository <Driver, Long>{
    
}
