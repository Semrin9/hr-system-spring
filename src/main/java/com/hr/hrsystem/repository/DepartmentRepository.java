package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}