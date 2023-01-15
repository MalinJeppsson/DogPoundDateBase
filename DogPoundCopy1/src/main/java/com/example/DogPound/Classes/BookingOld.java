//package com.example.DogPound.Classes;
//
//import jakarta.persistence.*;
//
//@Table(name="BOOKINGS")
//@Entity
//public class BookingOld {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private Booking day;
//
//    public BookingOld(User user, Booking day) {
//        this.user = user;
//        this.day = day;
//    }
//
//    public BookingOld() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Booking getDay() {
//        return day;
//    }
//
//    public void setDay(Booking day) {
//        this.day = day;
//    }
//}
