package com.example.demo;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private User_details user_details;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "User_grouped_Friends",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "Frieds_id")
    )
    private List<Friends> friends;
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public User() {}

   public void  setFriends(List<Friends> friends) {
        this.friends = friends;
}

     @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
     private List<Post>post;
}
