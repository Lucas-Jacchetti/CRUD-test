package com.services.CRUD_test.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.CRUD_test.entities.Team;
import com.services.CRUD_test.repository.TeamRepository;

@Service
public class TeamServices implements Serializable{
    
    @Autowired
    private TeamRepository repository;

    public List <Team> findAll(){
        return repository.findAll();
    }

    public Team findById(Long Id){
        Optional <Team> tm = repository.findById(Id);
        return tm.orElseThrow(() -> new RuntimeException()); //*TODO SUBSTITUIÇÃO DE RUNTIMEEXCEPTION POR EXCESSÃO PEROSNALIZADA */
    }

    public Team insert(Team tm){
        return repository.save(tm);
    }

    public void deleteById(Long Id){  //*TODO CRIAR EXCESSÕES */
        repository.findById(Id); 
    }

    public Team update(Long Id, Team obj){
        Team tm = repository.getReferenceById(Id);  //*TODO CRIAR EXCESSÕES */
        updateTeam(tm, obj);
        return repository.save(tm);
        
    }

    public void updateTeam(Team tm, Team obj){
        tm.setId(obj.getId());
        tm.setName(obj.getName());
        tm.setModel(obj.getModel());
        tm.setPlacement(obj.getPlacement());

    }
}
