package com.hr.hrsystem.dto;

import lombok.*;

/**
 * DTO for {@link com.hr.hrsystem.models.Employee}
 */
@Builder
@Data
public class EmployeeDto {
    private Integer id;
    private String employeeName;
    private Integer employeeAge;
    private String employeeGender;
    private String employeeEmail;
    private String employeeJob;
    private Integer phoneNumber;
    private String employeeUsername;
    private LocationDto location;
    private DepartmentDto department;
    private PayrollDto payroll;
}