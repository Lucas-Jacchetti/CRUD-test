package com.services.CRUD_test.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_teams")
public class Team implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private Integer placement;
    private String model;

    @JsonIgnore //para evitar loop infinito
    @OneToMany(mappedBy = "team") 
    private List<Driver> drivers = new ArrayList<>();
    
    
    public List<Driver> getDriver(){
        return this.drivers;
    }


    public Team(Long Id, String name, Integer placement, String model) {
        this.Id = Id;
        this.name = name;
        this.placement = placement;
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Team)) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(Id, team.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

}
