package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link com.hr.hrsystem.models.Role}
 */
@Builder
@Data
public class RoleDto {
    private Integer id;
    private String roleTitle;
    private String roleDescription;
}