package com.example.services;

import com.example.entities.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by noelaniekan on 2/10/17.
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
