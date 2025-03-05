package com.services.CRUD_test.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.services.CRUD_test.entities.Team;
import com.services.CRUD_test.repository.TeamRepository;
import com.services.CRUD_test.services.exceptions.DataBaseException;
import com.services.CRUD_test.services.exceptions.ResourceNotFoundException;

@Service
public class TeamServices implements Serializable{
    
    @Autowired
    private TeamRepository repository;

    public List <Team> findAll(){
        return repository.findAll();
    }

    public Team findById(Long Id){
        Optional <Team> tm = repository.findById(Id);
        return tm.orElseThrow(() -> new ResourceNotFoundException(Id)); 
    }

    public Team insert(Team tm){
        return repository.save(tm);
    }

    public void deleteById(Long Id){ 
        try{
            if (!repository.existsById(Id)) {
                throw new ResourceNotFoundException(Id);
            }  repository.deleteById(Id);
        }
        catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException(Id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
        
    }

    public Team update(Long Id, Team obj){
        try {
            Team tm = repository.getReferenceById(Id); 
            updateTeam(tm, obj);
            return repository.save(tm);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException(Id);
        }
        
    }

    public void updateTeam(Team tm, Team obj){
        tm.setId(obj.getId());
        tm.setName(obj.getName());
        tm.setModel(obj.getModel());
        tm.setPlacement(obj.getPlacement());

    }
}
