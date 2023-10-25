package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.service.EmployeeService;
import com.hr.hrsystem.service.LocationService;
import com.hr.hrsystem.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class DashboardController {

    private LocationService locationService;
    private EmployeeService employeeService;
    private RoleService roleService;

    public DashboardController(LocationService locationService, EmployeeService employeeService, RoleService roleService) {
        this.locationService = locationService;
        this.employeeService = employeeService;
        this.roleService = roleService;
    }

    @GetMapping("/dashboard")
    public String listDashboard(Model model) {
        List<LocationDto> locations = locationService.findAllLocations();
        List<EmployeeDto> employees = employeeService.findAllEmployees();

        if (employees.size() > 4) {
            employees = employees.subList(0, 4);
        }

        for (LocationDto location : locations) {
            long numOfEmployeesByLocation = employeeService.findNumOfEmployeesByLocation(location.getId());
            location.setNumOfEmployees(numOfEmployeesByLocation);
        }

        if (locations.size() > 4) {
            locations = locations.subList(0, 4);
        }

        long totalJobs = roleService.getTotalNumberOfRoles();
        long totalEmployees = employeeService.getTotalNumberOfEmployees();
        BigDecimal totalSalary = employeeService.getTotalSalaryForAllEmployees();

        model.addAttribute("locations", locations);
        model.addAttribute("employees", employees);
        model.addAttribute("totalJobs", totalJobs);
        model.addAttribute("totalEmployees", totalEmployees);
        model.addAttribute("totalSalary", totalSalary);
        return "dashboard";
    }
}
