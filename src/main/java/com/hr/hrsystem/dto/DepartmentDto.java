package com.hr.hrsystem.dto;

import lombok.*;

/**
 * DTO for {@link com.hr.hrsystem.models.Department}
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Integer id;
    private String departmentName;
    private LocationDto location;
    private Integer departmentHead;
}