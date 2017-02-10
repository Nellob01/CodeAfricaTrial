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

    @Column
    String comments;

    public Contacts() {
    }

    public Contacts(String name, String email, String phone, String comments) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.comments = comments;
    }
}
