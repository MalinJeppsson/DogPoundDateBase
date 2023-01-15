package com.example.DogPound.Services;

import com.example.DogPound.Classes.Booking;
import com.example.DogPound.Classes.User;
import com.example.DogPound.Repositories.UserRepository;
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

    public List<String> convertBookingsToStringList(User user) {
        List<String> returnList = new ArrayList<>();
        List<Booking> userBookings = user.getBookings();
        for (int i = 0; i < userBookings.size(); i++) {
            // Loops through bookings, gets its Day object and checks its name. Returns string like "Tisdag" etc. Add strings like "Vecka 44" to returnList
            String dayName = userBookings.get(i).getDayName();
            String date = userBookings.get(i).getDate();
            returnList.add(dayName + ", Vecka " + userBookings.get(i).getWeek().getName()+ ", " + date);
        }
        return returnList;
    }

}