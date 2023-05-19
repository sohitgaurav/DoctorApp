package com.geekster.doctorApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Appointment {
    //id
    //time
    @Id
    @EmbeddedId
    AppointmentKey appointmentKey; ///not pemetive data type so to create column in table appointment we use @embedableid primary key

    @ManyToOne
    @JoinColumn(name="fk_doctor_doc_id")
    private  Doctor doctor;

    @OneToOne
    private Patient patient;
}
