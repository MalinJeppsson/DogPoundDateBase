package com.example.DogPound;

import java.util.ArrayList;

public class Week {

    private String name;
    private ArrayList<Day> weekDays;

    public Week(String name) {
        this.name = name;
        this.weekDays = generateOneWeek();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Day> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(ArrayList<Day> weekDays) {
        this.weekDays = weekDays;
    }
    public void removeSpot(String day) {
        Day dayToRemove= new Day("XX", 10);
        for (Day loopDay : weekDays){
            if (loopDay.getName().equals(day)) {
                dayToRemove = loopDay;
            }
        }
        dayToRemove.removeOneSpot();
    }

    public ArrayList<Day> generateOneWeek() {
        ArrayList<Day> returnList = new ArrayList<>();
        returnList.add(new Day("Måndag", 10));
        returnList.add(new Day("Tisdag", 10));
        returnList.add(new Day("Onsdag", 10));
        returnList.add(new Day("Torsdag", 10));
        returnList.add(new Day("Fredag", 10));
        return returnList;
    }
}
