package com.example.DogPound.Services;

import com.example.DogPound.Classes.Day;
import com.example.DogPound.Classes.Week;
import com.example.DogPound.Repositories.DayRepository;
import com.example.DogPound.Repositories.UserRepository;
import com.example.DogPound.Repositories.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {

    @Autowired
    DayRepository repository;


    public Day createNewDayAndAddToWeekAndRepo(String selectedDay, Week week) {
        Day day = new Day(selectedDay, week);
        repository.save(day);
        return day;
    }
}
