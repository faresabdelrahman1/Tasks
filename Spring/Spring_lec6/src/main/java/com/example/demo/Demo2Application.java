package com.example.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Demo2Application {

    public static  void main(String[] args) {
       SessionFactory sessionFactory=new Configuration()
               .addAnnotatedClass(User.class)
               .addAnnotatedClass(Friends.class)
               .addAnnotatedClass(Post.class)
               .addAnnotatedClass(User_details.class)
               .addAnnotatedClass(AdminUser.class)
               .addAnnotatedClass(NormalUser.class)
               .configure("hibernate.cfg.xml")
                .buildSessionFactory();
         Session session=sessionFactory.openSession();
         Transaction transaction=session.beginTransaction();
        User user = new User( "fares", 21);
        Friends f1 = new Friends( "zayed");
        Friends f2 = new Friends( "abdo");
        //  userDetailed
        User_details user_details=new User_details();
        user_details.setAddress("fayoum");
        user_details.setPhone("011506170");
        //الربط بين اليوزر والتفاصيل اليوزر
        user_details.setUser(user);
        session.persist(user);
        session.persist(user_details);
        /// ////////////////////
        List<Friends> flist=new ArrayList<Friends>();
        flist.add(f1);
        flist.add(f2);
        user.setFriends(flist);
        session.save(f1);
        session.save(f2);
        session.save(user);
        /// /////////////////////////////////
        Post posts=new Post();
        posts.setHeader("cnn");
        posts.setContent("this is a post");
        posts.setHeader("iran");
        posts.setUser(user);
        session.save(posts);
        /// ////////        /// ////////        /// ////////        /// ////////
        AdminUser adminUser=new AdminUser("amns",20,"senior");
        session.save(adminUser);
        NormalUser normalUser=new NormalUser("fares abdel",21,"midLevel");
        session.save(normalUser);
         transaction.commit();

        }
    }


