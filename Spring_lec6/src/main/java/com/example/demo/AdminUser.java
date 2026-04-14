package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class AdminUser extends User {
    private String role;
    public AdminUser() {}

    public AdminUser(String name,int age,String role) {
     super(name,age);
     this.role=role;
    }
}
