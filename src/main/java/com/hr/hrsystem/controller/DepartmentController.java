package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.DepartmentDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.models.Department;
import com.hr.hrsystem.service.DepartmentService;
import com.hr.hrsystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {

    private DepartmentService departmentService;
    private LocationService locationService;

    public DepartmentController(DepartmentService departmentService, LocationService locationService) {
        this.departmentService = departmentService;
        this.locationService = locationService;
    }

    @GetMapping("/departments")
    public String listDepartments(Model model) {
        List<DepartmentDto> departments = departmentService.findAllDepartments();
        List<LocationDto> locations = locationService.findAllLocations();
        Department department = new Department();
        model.addAttribute("departments", departments);
        model.addAttribute("locations", locations);
        model.addAttribute("department", department);
        return "departments-list";
    }

    @PostMapping("/departments")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @GetMapping("/departments/{id}/edit")
    public String editDepartment (@PathVariable("id") Integer id, Model model) {
        DepartmentDto department = departmentService.findDepartmentById(id);

        List<LocationDto> locations = locationService.findAllLocations();
        LocationDto location = locationService.findLocationById(department.getLocation().getId());

        model.addAttribute("department", department);
        model.addAttribute("locations", locations);

        model.addAttribute("location", location);
        return "edit/department-edit";
    }

    @PostMapping("/departments/{id}/edit")
    public String updateDepartment (@PathVariable("id") Integer id, @ModelAttribute("department") Department department) {
        department.setId(id);
        departmentService.updateDepartment(department);
        return "redirect:/departments";
    }

        @GetMapping("/departments/{id}/delete")
    public String deleteDepartment (@PathVariable("id") Integer id) {
        departmentService.delete(id);
        return "redirect:/departments";
    }
}
