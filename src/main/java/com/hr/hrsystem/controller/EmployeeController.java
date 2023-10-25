package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.DepartmentDto;
import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.PayrollDto;
import com.hr.hrsystem.models.Department;
import com.hr.hrsystem.models.Employee;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.models.Payroll;
import com.hr.hrsystem.service.DepartmentService;
import com.hr.hrsystem.service.EmployeeService;
import com.hr.hrsystem.service.LocationService;
import com.hr.hrsystem.service.PayrollService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;
    private LocationService locationService;
    private DepartmentService departmentService;
    private PayrollService payrollService;

    public EmployeeController(EmployeeService employeeService, LocationService locationService, DepartmentService departmentService, PayrollService payrollService) {
        this.employeeService = employeeService;
        this.locationService = locationService;
        this.departmentService = departmentService;
        this.payrollService = payrollService;
    }

    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<EmployeeDto> employees = employeeService.findAllEmployees();
        List<LocationDto> locations = locationService.findAllLocations();
        List<DepartmentDto> departments = departmentService.findAllDepartments();
        List<PayrollDto> payrolls = payrollService.findAllPayrolls();

        Employee employee = new Employee();
        model.addAttribute("employees", employees);
        model.addAttribute("locations", locations);
        model.addAttribute("departments", departments);
        model.addAttribute("payrolls", payrolls);
        model.addAttribute("employee", employee);

        return "employees-list";
    }

    @PostMapping("/employees")
    public String saveEmployees(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}/edit")
    public String editEmployeeForm(@PathVariable("id") Integer id, Model model) {
        EmployeeDto employee = employeeService.findEmployeeById(id);

        LocationDto location = locationService.findLocationById(employee.getLocation().getId());
        DepartmentDto department = departmentService.findDepartmentById(employee.getDepartment().getId());
        PayrollDto payroll = payrollService.findPayrollById(employee.getPayroll().getId());

        List<LocationDto> locations = locationService.findAllLocations();
        List<DepartmentDto> departments = departmentService.findAllDepartments();
        List<PayrollDto> payrolls = payrollService.findAllPayrolls();

        model.addAttribute("employee", employee);
        model.addAttribute("location", location);
        model.addAttribute("department", department);
        model.addAttribute("payroll", payroll);

        model.addAttribute("locations", locations);
        model.addAttribute("departments", departments);
        model.addAttribute("payrolls", payrolls);
        return "edit/employee-edit";
    }

    @PostMapping("/employees/{id}/edit")
    public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employee") Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}/delete")
    public String deleteEmployee (@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
