package com.example.entities;

import javax.persistence.*;

/**
 * Created by noelaniekan on 2/10/17.
 */
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String phone;

    public Student() {
    }

    public Student(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
