package com.services.CRUD_test.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_drivers")
public class Driver implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    private Long Id;

    private String name;
    private Integer number;

    
    @ManyToOne
    @JoinColumn(name = "team_id") //nome da chave estrangeira 
    private Team team;

    @JsonIgnore
    public Team getTeam(){
        return this.team;
    }


    public Driver(Long Id, String name, Integer number, Team team) {
        this.Id = Id;
        this.name = name;
        this.number = number;
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Driver)) {
            return false;
        }
        Driver driver = (Driver) o;
        return Objects.equals(Id, driver.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "{" +
            " Id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", number='" + getNumber() + "'" +
            ", team='" + getTeam() + "'" +
            "}";
    }

}
