package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Employee;
import com.hr.hrsystem.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findAllByLocation(Location location);
    long countByLocationId(int locationId);
}