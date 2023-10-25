package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.DepartmentDto;
import com.hr.hrsystem.models.Department;


import java.util.List;

public interface DepartmentService {
    public List<DepartmentDto> findAllDepartments();
    public Department saveDepartment(Department department);

    void delete(Integer id);

    DepartmentDto findDepartmentById(Integer id);

    void updateDepartment(Department department);
}