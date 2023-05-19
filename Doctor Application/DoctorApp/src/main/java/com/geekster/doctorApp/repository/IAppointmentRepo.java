package com.geekster.doctorApp.repository;

import com.geekster.doctorApp.model.Appointment;
import com.geekster.doctorApp.model.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {
}
