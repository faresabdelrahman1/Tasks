package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Post {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String header;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setHeader(String header) {
        this.header = header;
    }



    public void setContent(String content) {
        this.content = content;
    }



    public void setUser(User user) {
        this.user = user;
    }
}
