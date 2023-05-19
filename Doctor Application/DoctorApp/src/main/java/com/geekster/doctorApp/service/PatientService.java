package com.geekster.doctorApp.service;

import com.geekster.doctorApp.dto.SignInInput;
import com.geekster.doctorApp.dto.SignInOutput;
import com.geekster.doctorApp.dto.SignUpInput;
import com.geekster.doctorApp.dto.SignUpOutput;
import com.geekster.doctorApp.model.AuthenticationToken;
import com.geekster.doctorApp.model.Doctor;
import com.geekster.doctorApp.model.Patient;
import com.geekster.doctorApp.repository.IDoctorRepo;
import com.geekster.doctorApp.repository.IPatientRepository;
import jakarta.xml.bind.DatatypeConverter;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@Service
public class PatientService {
    @Autowired
    IPatientRepository iPatientRepository;
    @Autowired
    AuthenticationService tokenService;
    @Autowired
    DoctorService doctorService;

    public SignUpOutput signUp(SignUpInput signUpDto) {
        // check if user exist
        Patient patient= iPatientRepository.findFirstByPatientEmail(signUpDto.getUserEmail());
      if(patient != null){
          throw new IllegalStateException("patient already exist ....signIn Instead");
      }

        // encryption
        String encryptedPassword=null;
        try {
            encryptedPassword=encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //save the user
        patient = new Patient(signUpDto.getUserFirstName(),
                signUpDto.getUserFirstName(),signUpDto.getUserEmail(),
                encryptedPassword,signUpDto.getUserContact());
              iPatientRepository.save(patient);

        // token creation and saving
        AuthenticationToken token = new AuthenticationToken(patient);

        tokenService.saveToken(token);
   return  new SignUpOutput("patient registered","patient created successfully");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested= md5.digest();


        String hash= DatatypeConverter.printHexBinary(digested);
        return  hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        //get email
        Patient patient= iPatientRepository.findFirstByPatientEmail(signInDto.getPatientEmail());
        if(patient == null){
            throw new IllegalStateException("user invalid  ....signUp Instead");
        }

        // encrypt password

        String encryptedPassword=null;
        try {
            encryptedPassword= encryptPassword(signInDto.getPatientPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //match with  database encrypted password

        boolean isPassword=encryptedPassword.equals(patient.getPatientPassword());
        if(!isPassword){
            throw new IllegalStateException("user invalid  ....signUp Instead");

        }

        // figure out the token
        AuthenticationToken authToken = tokenService.getToken(patient);

        //return output response
        return new SignInOutput("Authentication successful",authToken.getToken() );
    }

    public List<Doctor> getAllDoctors() {
      return   doctorService.getAllDoctor();
    }
}

