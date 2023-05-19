package com.geekster.doctorApp.repository;

import com.geekster.doctorApp.model.AuthenticationToken;
import com.geekster.doctorApp.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken,Integer> {

    AuthenticationToken findByPatient(Patient patient);
}
