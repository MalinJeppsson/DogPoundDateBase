package com.example.DogPound.Classes;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Entity
@Table(name="WEEKS")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "WEEK_NAME")
    private String name;
    @OneToMany (mappedBy = "week", cascade = CascadeType.ALL)
    private List<Booking> weekDays;

    @Column
    private Calendar mondayDate;

//    public Week(String name) {
//        this.name = name;
//        this.weekDays = generateOneWeek();
//    }

    public Week() {
    }

    public Week(String name) {
        this.name = name;
        this.weekDays=new ArrayList<>();
        this.mondayDate =generateWeekStartDate(name);
    }

    private Calendar generateWeekStartDate(String weekNum) {
        Calendar mondayDate = Calendar.getInstance();
        mondayDate.set(2023,01,06);
        if (weekNum.equals("6")) {
            return mondayDate;
        } else {
            mondayDate.add(Calendar.WEEK_OF_YEAR, Integer.valueOf(weekNum) - 6);
            return mondayDate;
        }
    }

    public Calendar getMondayDate() {
        return mondayDate;
    }

    public void setMondayDate(Calendar mondayDate) {
        this.mondayDate = mondayDate;
    }

    public Week(String name, List<Booking> weekDays) {
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

    public List<Booking> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(List<Booking> weekDays) {
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
