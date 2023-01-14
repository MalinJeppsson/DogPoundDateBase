package com.example.DogPound.Services;

import com.example.DogPound.Classes.Booking;
import com.example.DogPound.Classes.Day;
import com.example.DogPound.Classes.User;
import com.example.DogPound.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BookingService {

    @Autowired
    BookingRepository repository;


    public void addBooking(User user, Day day) {
        repository.save(new Booking(user, day));
    }

    public List<String> convertBookingsToStringList(User user) {
        List<String> returnList = new ArrayList<>();
        List<Booking> userBookings = user.getBookings();
        for (int i = 0; i < userBookings.size(); i++) {
            // Loops through bookings, gets its Day object and checks its name. Returns string like "Tisdag" etc.
            String dayName = userBookings.get(i).getDay().getName();
            String weekString = returnWeekNumAsString(userBookings.get(i));
            returnList.add(dayName + ", " + weekString);
        }
        return returnList;
    }

    public String returnWeekNumAsString(Booking booking) {
        return "Vecka " + booking.getDay().getWeek().getName(); // this is gonna be a week number like 44 or 45 etc. So Vecka 44 etc.
    }

}
