package com.example.DogPound;

public class Day {
    private String name;
    private int spots;

    public Day(String name, int spots) {
        this.name = name;
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public int getSpots() {
        return spots;
    }

    public void setSpots(int spots) {
        this.spots = spots;
    }
    public void removeOneSpot() {
        if (spots > 0) {
            spots--;
        }
    }
    public void addOneSpot() {
        if (spots < 10) {
            spots++;
        }
    }
}
