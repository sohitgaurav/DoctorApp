package com.geekster.doctorApp.service;

import com.geekster.doctorApp.model.Doctor;
import com.geekster.doctorApp.repository.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo doctorRepo;

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);

    }

    public List<Doctor> getAllDoctor() {
        List<Doctor> allDoctors = doctorRepo.findAll();
       return allDoctors;
    }
}
