package com.hr.hrsystem.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * DTO for {@link com.hr.hrsystem.models.Attendance}
 */
@Builder
@Data
public class AttendanceDto {
    private Long id;
    private LocalDate attendanceDate;
    private LocalTime clockIn;
    private LocalTime clockOut;
    private EmployeeDto employee;
}