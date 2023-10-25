package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.models.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    public List<EmployeeDto> findAllEmployees();
    public long findNumOfEmployeesByLocation(int locationId);
    public Employee saveEmployee(Employee employee);
    EmployeeDto findEmployeeById(Integer id);
    void updateEmployee(Employee employee);
    void delete(Integer id);
    long getTotalNumberOfEmployees();
    public BigDecimal getTotalSalaryForAllEmployees();
}