package com.example.DogPound.Repositories;

import com.example.DogPound.Classes.User;
import com.example.DogPound.Classes.Week;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeekRepository extends CrudRepository<Week, Long> {

    List<Week> findByName(String selectedWeekNumber);
}