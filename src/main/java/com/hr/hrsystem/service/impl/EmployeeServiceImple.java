package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.DepartmentDto;
import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.PayrollDto;
import com.hr.hrsystem.models.Department;
import com.hr.hrsystem.models.Employee;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.models.Payroll;
import com.hr.hrsystem.repository.EmployeeRepository;
import com.hr.hrsystem.repository.LocationRepository;
import com.hr.hrsystem.service.EmployeeService;
import com.hr.hrsystem.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImple implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImple(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee -> mapToEmployeeDto(employee))).collect(Collectors.toList());
    }

    @Override
    public long findNumOfEmployeesByLocation(int locationId) {
        return employeeRepository.countByLocationId(locationId);
    }
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto findEmployeeById(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return mapToEmployeeDto(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public long getTotalNumberOfEmployees() {
        return employeeRepository.count();
    }

    @Override
    public BigDecimal getTotalSalaryForAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        BigDecimal totalSalary = BigDecimal.ZERO;

        for (Employee employee : employees) {
            Payroll payroll = employee.getPayroll();
            if (payroll != null) {
                BigDecimal netSalary = payroll.calculateNetSalary();
                totalSalary = totalSalary.add(netSalary);
            }
        }
        return totalSalary;
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    private LocationDto convertLocationToLocationDto(Location location) {
        if (location == null) {
            return null;
        }

        LocationDto locationDto = LocationDto.builder()
                .id(location.getId())
                .locationName(location.getLocationName())
                .build();
        return locationDto;
    }

    private Location convertLocationToLocation(LocationDto locationDto) {
        if (locationDto == null) {
            return null;
        }

        Location location = Location.builder()
                .id(locationDto.getId())
                .locationName(locationDto.getLocationName())
                .build();
        return location;
    }

    private DepartmentDto convertDepartmentToDepartmentDto(Department department) {
        if (department == null) {
            return null;
        }

        DepartmentDto departmentDto = DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .build();
        return departmentDto;
    }

    private Department convertDepartmentToDepartment(DepartmentDto departmentDto) {
        if (departmentDto == null) {
            return null;
        }

        Department department = Department.builder()
                .id(departmentDto.getId())
                .departmentName(departmentDto.getDepartmentName())
                .build();
        return department;
    }

    private PayrollDto convertPayrollToPayrollDto(Payroll payroll) {
        if (payroll == null) {
            return null;
        }

        PayrollDto payrollDto = PayrollDto.builder()
                .id(payroll.getId())
                .payrollTemplateName(payroll.getPayrollTemplateName())
                .build();
        return payrollDto;
    }

    private Payroll convertPayrollToPayroll(PayrollDto payrollDto) {
        if (payrollDto == null) {
            return null;
        }

        Payroll payroll = Payroll.builder()
                .id(payrollDto.getId())
                .payrollTemplateName(payrollDto.getPayrollTemplateName())
                .build();
        return payroll;
    }

    private Employee mapToEmployee(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Location location = convertLocationToLocation(employeeDto.getLocation());
        Department department = convertDepartmentToDepartment(employeeDto.getDepartment());
        Payroll payroll = convertPayrollToPayroll(employeeDto.getPayroll());

        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .employeeName(employeeDto.getEmployeeName())
                .employeeAge(employeeDto.getEmployeeAge())
                .employeeEmail(employeeDto.getEmployeeEmail())
                .employeeGender(employeeDto.getEmployeeGender())
                .employeeJob(employeeDto.getEmployeeJob())
                .phoneNumber(employeeDto.getPhoneNumber())
                .employeeUsername(employeeDto.getEmployeeUsername())
                .location(location)
                .department(department)
                .payroll(payroll)
                .build();
        return employee;
    }

    public EmployeeDto mapToEmployeeDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        LocationDto locationDto = convertLocationToLocationDto(employee.getLocation());
        DepartmentDto departmentDto = convertDepartmentToDepartmentDto(employee.getDepartment());
        PayrollDto payrollDto = convertPayrollToPayrollDto(employee.getPayroll());

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .employeeAge(employee.getEmployeeAge())
                .employeeEmail(employee.getEmployeeEmail())
                .employeeGender(employee.getEmployeeGender())
                .employeeJob(employee.getEmployeeJob())
                .phoneNumber(employee.getPhoneNumber())
                .employeeUsername(employee.getEmployeeUsername())
                .location(locationDto)
                .department(departmentDto)
                .payroll(payrollDto)
                .build();
        return employeeDto;
    }
}
