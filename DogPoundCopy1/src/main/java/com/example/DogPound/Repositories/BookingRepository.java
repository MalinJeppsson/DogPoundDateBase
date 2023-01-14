package com.example.DogPound.Repositories;

import com.example.DogPound.Classes.Booking;
import com.example.DogPound.Classes.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
