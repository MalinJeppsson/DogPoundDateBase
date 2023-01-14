package com.example.DogPound.Classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "WEEK_NAME")
    private String name;
    @OneToMany (mappedBy = "week", cascade = CascadeType.ALL)
    private List<Day> weekDays;

//    public Week(String name) {
//        this.name = name;
//        this.weekDays = generateOneWeek();
//    }

    public Week() {
    }

    public Week(String name) {
        this.name = name;
        this.weekDays=new ArrayList<>();
    }

    public Week(String name, List<Day> weekDays) {
        this.name = name;
        this.weekDays = weekDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Day> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<Day> weekDays) {
        this.weekDays = weekDays;
    }

    //    public void setWeekDays(ArrayList<Day> weekDays) {
//        this.weekDays = weekDays;
//    }
//    public void removeSpot(String day) {
//        Day dayToRemove= new Day("XX", 10);
//        for (Day loopDay : weekDays){
//            if (loopDay.getName().equals(day)) {
//                dayToRemove = loopDay;
//            }
//        }
//        dayToRemove.removeOneSpot();
//    }
//
//    public ArrayList<Day> generateOneWeek() {
//        ArrayList<Day> returnList = new ArrayList<>();
//        returnList.add(new Day("Måndag", 10));
//        returnList.add(new Day("Tisdag", 10));
//        returnList.add(new Day("Onsdag", 10));
//        returnList.add(new Day("Torsdag", 10));
//        returnList.add(new Day("Fredag", 10));
//        return returnList;
//    }
}
