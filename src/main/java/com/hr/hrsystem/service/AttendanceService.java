package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.AttendanceDto;
import com.hr.hrsystem.models.Attendance;

import java.util.List;

public interface AttendanceService {
    public List<AttendanceDto> findAllAttendances();
    public Attendance saveAttendance(Attendance attendance);
    void delete(long id);
}