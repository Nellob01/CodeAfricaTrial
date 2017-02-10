package com.example.entities;

import javax.persistence.*;

/**
 * Created by noelaniekan on 2/10/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    public String name;
}
