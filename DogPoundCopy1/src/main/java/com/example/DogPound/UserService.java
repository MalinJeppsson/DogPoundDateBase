package com.example.DogPound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    @Autowired

    UserRepository repository;

    public User createUser(User user) {

        User createdUser = repository.save(user);


        return createdUser;
    }

    public void deleteUser(User user){
        repository.delete(user);
    }

    public void editUser(User user){
        List<User> users  = repository.findByEmail(user.getEmail());

        User dbUser = users.stream().findFirst()
                .orElse(null);
        dbUser.setDogBreed(user.getDogBreed());
        dbUser.setEmail(user.getEmail());
        dbUser.setPassword(user.getPassword());
        dbUser.setDogName(user.getDogName());
        dbUser.setDogWeight(user.getDogWeight());
        dbUser.setOwnerLastName(user.getOwnerLastName());
        dbUser.setOwnerName(user.getOwnerName());
        dbUser.setPhoneNumber(user.getPhoneNumber());
        dbUser.setSpecialNeeds(user.getSpecialNeeds());
        repository.save(dbUser);
    }

    public User getUser(Long id) {

        User user = repository.findById(id).get();

        return user;
    }

    public User getUser(String email){
        List<User> users = repository.findByEmail(email);

        return users.stream().findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers(){
        List<User> users = (List<User>)repository.findAll();
        return users;
    }

    public User findUserByEmailAndByPassword(String email, String password){
        List<User> userList = repository.findByEmailAndPassword(email, password);
        User user = userList.stream().findFirst()
                .orElse(null);

        return user;
    }
}