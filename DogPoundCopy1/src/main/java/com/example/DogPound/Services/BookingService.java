package com.example.DogPound.Services;

import com.example.DogPound.Classes.Booking;
import com.example.DogPound.Classes.User;
import com.example.DogPound.Classes.Week;
import com.example.DogPound.Repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Service
public class BookingService {

    @Autowired
    BookingRepository repository;


    public Booking createNewBooking(String selectedDay, Week week, User user) {
        String dateAsString = stringifyDate(selectedDay, week);
        Booking booking = new Booking(selectedDay, week, user, dateAsString);
        repository.save(booking);
        return booking;
    }

    private String stringifyDate(String selectedDay, Week week) {
        Calendar mondayDate = week.getMondayDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        switch (selectedDay) {
            case "Tisdag" -> mondayDate.add(Calendar.DATE, 1);
            case "Onsdag" -> mondayDate.add(Calendar.DATE, 2);
            case "Torsdag" -> mondayDate.add(Calendar.DATE, 3);
            case "Fredag" -> mondayDate.add(Calendar.DATE, 4);
        };
        return dateFormat.format(mondayDate.getTime());

    }

}
