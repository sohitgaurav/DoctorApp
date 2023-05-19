package com.geekster.doctorApp.controller;

import com.geekster.doctorApp.dto.SignInInput;
import com.geekster.doctorApp.dto.SignInOutput;
import com.geekster.doctorApp.dto.SignUpInput;
import com.geekster.doctorApp.dto.SignUpOutput;
import com.geekster.doctorApp.model.Doctor;
import com.geekster.doctorApp.service.PatientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    // sign  up
   // sign up input
    // sigh up output
    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return patientService.signUp(signUpDto);
    }

    //sign in

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return patientService.signIn(signInDto);
    }

    @GetMapping("/doctors")
         public ResponseEntity<List<Doctor>>getAlDoctor(){
        List<Doctor> allDoctors =patientService.getAllDoctors();


        return  new ResponseEntity<List<Doctor>>(allDoctors, HttpStatus.OK);
        }
    }

