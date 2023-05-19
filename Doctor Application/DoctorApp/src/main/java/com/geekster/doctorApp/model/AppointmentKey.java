package com.geekster.doctorApp.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;
import java.time.LocalDateTime;
@Embeddable    // create table in Appointment
public class AppointmentKey implements Serializable {// seriziable bites
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long appointmentId;
    public LocalDateTime time;
}
