package com.services.CRUD_test.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.services.CRUD_test.entities.Driver;
import com.services.CRUD_test.repository.DriverRepository;
import com.services.CRUD_test.services.exceptions.DataBaseException;
import com.services.CRUD_test.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DriverServices implements Serializable{
    
    @Autowired
    private DriverRepository repository;

    public List <Driver> findAll(){
        return repository.findAll();
    }

    public Driver findById(Long Id){
        Optional <Driver> dr = repository.findById(Id);
        return dr.orElseThrow(() -> new ResourceNotFoundException(Id)); 
    }

    public Driver insert(Driver dr){
        return repository.save(dr);
    }

    public void deleteById(Long Id){  
        try{
            if (!repository.existsById(Id)) {
                throw new ResourceNotFoundException(Id);
            }
            repository.deleteById(Id);
        }
        catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(Id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException(e.getMessage());
        }
    
    }

    public Driver update(Long Id, Driver obj){
        try{
        Driver dr = repository.getReferenceById(Id); 
        updateDriver(dr, obj);
        return repository.save(dr);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(Id);
        }
        
    }

    public void updateDriver(Driver dr, Driver obj){
        dr.setId(obj.getId());
        dr.setName(obj.getName());
        dr.setNumber(obj.getNumber());
    }
}
