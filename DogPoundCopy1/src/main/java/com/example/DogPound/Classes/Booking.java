package com.example.DogPound.Classes;

import jakarta.persistence.*;

@Entity
@Table(name="BOOKINGS")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DAY_NAME")
    private String dayName;

    @ManyToOne
    private Week week;

//    @OneToMany (mappedBy = "day", cascade = CascadeType.ALL)
//    private List<BookingOld> bookings;

    @ManyToOne
    private User user;

    @Column(name="DATE")
    private String date;




    public Booking(String name) {
        this.dayName = name;
    }

    public Booking() {
    }


    public Booking(String name, Week week, User user, String date) {
        this.dayName = name;
        this.week = week;
        this.user = user;
        this.date= date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayName() {
        return dayName;
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
