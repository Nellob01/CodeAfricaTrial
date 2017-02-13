package com.example.entities;

import javax.persistence.*;

/**
 * Created by noelaniekan on 1/31/17.
 */
@Entity
@Table(name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String phone;


    public Contacts() {
    }

    public Contacts(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;

    }
}
