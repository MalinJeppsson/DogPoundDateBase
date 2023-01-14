package com.example.DogPound.Classes;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="DAY_NAME")
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DAY_NAME")
    private String name;

    @ManyToOne
    private Week week;

    @OneToMany (mappedBy = "day", cascade = CascadeType.ALL)
    private List<Booking> bookings;


    public Day(String name) {
        this.name = name;
    }

    public Day() {
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Day(String name, Week week) {
        this.name = name;
        this.week = week;
    }

    public String getName() {
        return name;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    //    public int getSpots() {
//        return spots;
//    }
//
//    public void setSpots(int spots) {
//        this.spots = spots;
//    }
//    public void removeOneSpot() {
//        if (spots > 0) {
//            spots--;
//        }
//    }
//    public void addOneSpot() {
//        if (spots < 10) {
//            spots++;
//        }
//    }
}
