package com.example.DogPound.Classes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(name="OWNER_NAME")
    private String ownerName;

    @Column(name="OWNER_LASTNAME")
    @NotEmpty
    private String ownerLastName;

    @Column(name="EMAIL")
    @Email
    private String email;

    @Column(name="PASSWORD")
    @Size(min = 5, max = 25)
    private String password;

    @Column(name="PHONE_NUMBER")
    @Pattern (regexp="^[0-9]{3}[0-9- .]{4,10}+$")
    private String phoneNumber;

    @Column(name="DOG_NAME")
    @Size(min = 2, max = 30)
    private String dogName;
    @Column(name="DOG_WEIGHT")
    private String dogWeight;

    @Column(name="DOG_BREED")
    private String dogBreed;

    @Column(name="SPECIAL_NEEDS")
    private String specialNeeds;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();



    public User() {

    }

    public User(Long id, String ownerName, String ownerLastName, String email, String password, String phoneNumber, String dogName, String dogWeight, String dogBreed, String specialNeeds) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerLastName = ownerLastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dogName = dogName;
        this.dogWeight = dogWeight;
        this.dogBreed = dogBreed;
        if (this.specialNeeds != null) {
            this.specialNeeds = specialNeeds;
        } else {
            this.specialNeeds="";
        }
    }
    public List<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getDogWeight() {
        return dogWeight;
    }

    public void setDogWeight(String dogWeight) {
        this.dogWeight = dogWeight;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }

    public String getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(String specialNeeds) {
        this.specialNeeds = specialNeeds;
    }
    public Long getId(){
        return this.id;
    }
}
