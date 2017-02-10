package com.example.services;

import com.example.entities.Contacts;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by noelaniekan on 1/31/17.
 */
public interface ContactRepository extends CrudRepository<Contacts, Integer> {
}
