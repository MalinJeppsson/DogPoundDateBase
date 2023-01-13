package com.example.DogPound;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByEmailAndPassword(String email, String password);



}

