package com.services.CRUD_test.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.services.CRUD_test.entities.Team;
import com.services.CRUD_test.services.TeamServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/teams")
public class TeamResources {
    
    @Autowired
    private TeamServices services;

    @GetMapping
    public ResponseEntity <List<Team>> findAll(){
        List <Team> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity <Team> findById(@PathVariable Long Id){
        Team dr = services.findById(Id);
        return ResponseEntity.ok().body(dr);
    }

    @PostMapping
    public ResponseEntity <Team> insert(@RequestBody Team tm){
        tm = services.insert(tm);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tm.getId()).toUri();
        return ResponseEntity.created(uri).body(tm);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity <Team> update(@PathVariable Long Id, @RequestBody Team tm){
        tm = services.update(Id, tm);
        return ResponseEntity.ok().body(tm);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity <Void> delete(@PathVariable Long Id){
        services.deleteById(Id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
