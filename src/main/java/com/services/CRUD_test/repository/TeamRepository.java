package com.services.CRUD_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.CRUD_test.entities.Team;


public interface TeamRepository extends JpaRepository <Team, Long>{
    
}
