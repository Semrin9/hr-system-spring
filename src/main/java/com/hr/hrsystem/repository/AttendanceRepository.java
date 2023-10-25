package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findAllByAttendanceDate(Date date);
}