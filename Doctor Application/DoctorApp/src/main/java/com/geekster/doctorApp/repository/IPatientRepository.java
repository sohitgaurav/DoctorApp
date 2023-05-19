package com.geekster.doctorApp.repository;

import com.geekster.doctorApp.model.Patient;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {


    Patient findFirstByPatientEmail(String userEmail);
}
