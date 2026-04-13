package com.example.demo;

import jakarta.persistence.*;

@Entity
public class User_details {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int details_Id;
    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name ="user_id")
    private User user;

    public int getDetails_Id() {
        return details_Id;
    }

    public void setDetails_Id(int details_Id) {
        this.details_Id = details_Id;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setUser(User user) {
        this.user = user;
    }
}
