package com.example.DogPound;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name="TIMESLOTS")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="START_DATE_TIME")
    private LocalDateTime startDateTime;

    @Column(name="END_DATE_TIME")
    private LocalDateTime endDateTime;

    @ManyToOne
    private User user;
}
