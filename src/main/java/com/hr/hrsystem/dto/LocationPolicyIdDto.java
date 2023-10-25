package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link com.hr.hrsystem.models.LocationPolicyId}
 */
@Data
@Builder
public class LocationPolicyIdDto {
    private Integer locationid;
    private Integer policyid;
}