package com.services.CRUD_test.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_drivers")
public class Driver implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
    private Long Id;

    private String name;
    private Integer number;


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
}
