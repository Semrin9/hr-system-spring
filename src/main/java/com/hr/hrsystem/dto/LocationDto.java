package com.hr.hrsystem.dto;

import lombok.*;

/**
 * DTO for {@link com.hr.hrsystem.models.Location}
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {
    private Integer id;
    private String locationName;
    private String city;
    private String country;
    private String locationEmail;
    private Integer locationNumber;

    @Getter
    private long numOfEmployees;

}