package com.example.demo;
import java.util.*;

import jakarta.persistence.*;


@Entity
public class Friends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


   @ManyToMany(mappedBy = "friends")
    private List<User>user;
   public Friends(String name) {
       this.id = id;
       this.name = name;

   }
   public Friends() {}
}
