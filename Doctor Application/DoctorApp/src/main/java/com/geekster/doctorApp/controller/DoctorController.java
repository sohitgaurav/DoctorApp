package com.geekster.doctorApp.controller;

import com.geekster.doctorApp.model.Doctor;
import com.geekster.doctorApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping()
    void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }
}
