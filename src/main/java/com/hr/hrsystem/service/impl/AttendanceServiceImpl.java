package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.AttendanceDto;
import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.models.Attendance;
import com.hr.hrsystem.models.Employee;
import com.hr.hrsystem.repository.AttendanceRepository;
import com.hr.hrsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private AttendanceRepository attendanceRepository;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<AttendanceDto> findAllAttendances() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return attendances.stream().map((attendance -> mapToAttendanceDto(attendance))).collect(Collectors.toList());
    }

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void delete(long id) {
        attendanceRepository.deleteById(id);
    }

    private AttendanceDto mapToAttendanceDto(Attendance attendance) {
        if (attendance == null) {
            return null;
        }

        EmployeeDto employeeDto = convertEmployeeToEmployeeDto(attendance.getEmployee());

        AttendanceDto attendanceDto = AttendanceDto.builder()
                .id(attendance.getId())
                .attendanceDate(attendance.getAttendanceDate())
                .clockIn(attendance.getClockIn())
                .clockOut(attendance.getClockOut())
                .employee(employeeDto)
                .build();

        return attendanceDto;
    }

    private EmployeeDto convertEmployeeToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .build();

        return employeeDto;
    }
    public Attendance partialUpdate(AttendanceDto attendanceDto, Attendance attendance) {
        return null;
    }
}
