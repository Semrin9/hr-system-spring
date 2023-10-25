package com.hr.hrsystem.repository;

import com.hr.hrsystem.dto.RoleDto;
import com.hr.hrsystem.models.EmployeeRole;
import com.hr.hrsystem.models.EmployeeRoleId;
import com.hr.hrsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, EmployeeRoleId> {
    long countByRole(Role role);
}