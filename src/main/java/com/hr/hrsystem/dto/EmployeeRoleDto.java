package com.hr.hrsystem.dto;

import com.hr.hrsystem.models.EmployeeRoleId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.hr.hrsystem.models.EmployeeRole}
 */
@Data
@Builder
public class EmployeeRoleDto {
    private EmployeeRoleId id;
    private EmployeeDto employee;
    private RoleDto role;
}