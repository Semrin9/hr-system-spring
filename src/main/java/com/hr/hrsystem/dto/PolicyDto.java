package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link com.hr.hrsystem.models.Policy}
 */
@Builder
@Data
public class PolicyDto {
    private Integer id;
    private String policyTitle;
    private String policyDescription;
}