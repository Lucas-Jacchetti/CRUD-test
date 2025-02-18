package com.services.CRUD_test.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.services.CRUD_test.entities.Driver;
import com.services.CRUD_test.services.DriverServices;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/drivers")
public class DriverResources {
    
    @Autowired
    private DriverServices services;

    @GetMapping
    public ResponseEntity <List<Driver>> findAll(){
        List <Driver> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{Id}")
    public ResponseEntity <Driver> findById(@PathVariable Long Id){
        Driver dr = services.findById(Id);
        return ResponseEntity.ok().body(dr);
    }

    @PostMapping
    public ResponseEntity <Driver> insert(@RequestBody Driver dr){
        dr = services.insert(dr);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(dr.getId()).toUri();
        return ResponseEntity.created(uri).body(dr);
    }

    @PutMapping(value = "/{Id}")
    public ResponseEntity <Driver> update(@PathVariable Long Id, @RequestBody Driver dr){
        dr = services.update(Id, dr);
        return ResponseEntity.ok().body(dr);
    }

    @DeleteMapping(value = "/{Id}")
    public ResponseEntity <Void> delete(@PathVariable Long Id){
        services.deleteById(Id);
        return ResponseEntity.noContent().build();
    }
    
    
    
}
