package com.helloworld.spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String role;

    Employee(){
    }

    public Employee(String name, String role){
        this.name = name;
        this.role = role;
    }

}
