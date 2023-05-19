package com.geekster.doctorApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
public class AuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne()
    @JoinColumn(nullable = false,name ="fk_patient_Id")
    private Patient patient;

    public AuthenticationToken(Patient patient) {
        this.patient = patient;
        this.tokenCreationDate=LocalDate.now();
        this.token= UUID.randomUUID().toString();
    }
}
