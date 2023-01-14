package com.example.DogPound.Services;

import com.example.DogPound.Classes.User;
import com.example.DogPound.Classes.Week;
import com.example.DogPound.Repositories.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeekService {

    @Autowired
    WeekRepository repository;


    public Week createNewWeekOrReturnIfAlreadyExists(String selectedWeek) {
        String selectedWeekNumber = selectedWeek.split(" ")[1];
        List<Week> weekList = repository.findByName(selectedWeekNumber);
        if (weekList.isEmpty()) {
            Week weekToAdd = new Week(selectedWeekNumber);
            addWeek(weekToAdd);
            return weekToAdd;
        } else {
            return weekList.get(0);
        }
    }

    public void addWeek(Week week) {
        repository.save(week);
    }
}
