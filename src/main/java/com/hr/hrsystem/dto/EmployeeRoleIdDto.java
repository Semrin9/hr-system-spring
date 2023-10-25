package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

/**
 * DTO for {@link com.hr.hrsystem.models.EmployeeRoleId}
 */
@Data
@Builder
public class EmployeeRoleIdDto {
    private Integer employeeId;
    private Integer roleId;
}