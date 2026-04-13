package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("normal")
public class NormalUser extends User{
    private String level;
    public NormalUser() {}

    public NormalUser(String name,int age,String level) {
        super(name, age);
        this.level = level;
    }

}
