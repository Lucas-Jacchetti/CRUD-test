package com.services.CRUD_test.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.CRUD_test.entities.Driver;
import com.services.CRUD_test.repository.DriverRepository;

@Service
public class DriverServices implements Serializable{
    
    @Autowired
    private DriverRepository repository;

    public List <Driver> findAll(){
        return repository.findAll();
    }

    public Driver findById(Long Id){
        Optional <Driver> dr = repository.findById(Id);
        return dr.orElseThrow(() -> new RuntimeException()); //*TODO SUBSTITUIÇÃO DE RUNTIMEEXCEPTION POR EXCESSÃO PEROSNALIZADA */
    }

    public Driver insert(Driver dr){
        return repository.save(dr);
    }

    public void deleteById(Long Id){  //*TODO CRIAR EXCESSÕES */
        repository.findById(Id); 
    }

    public Driver update(Long Id, Driver obj){
        Driver dr = repository.getReferenceById(Id);  //*TODO CRIAR EXCESSÕES */
        updateDriver(dr, obj);
        return repository.save(dr);
        
    }

    public void updateDriver(Driver dr, Driver obj){
        dr.setId(obj.getId());
        dr.setName(obj.getName());
        dr.setNumber(obj.getNumber());
    }
}
