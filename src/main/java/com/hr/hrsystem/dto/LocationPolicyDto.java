package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;

/**
 * DTO for {@link com.hr.hrsystem.models.LocationPolicy}
 */
@Data
@Builder
public class LocationPolicyDto {
    private LocationPolicyIdDto id;
    private LocationDto locationid;
    private PolicyDto policyid;
}