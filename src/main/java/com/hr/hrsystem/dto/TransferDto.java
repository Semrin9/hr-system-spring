package com.hr.hrsystem.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

/**
 * DTO for {@link com.hr.hrsystem.models.Transfer}
 */
@Builder
@Data
public class TransferDto {
    private Integer id;
    private LocalDate transferDate;
    private String transferDescription;
    private LocationDto location;
    private EmployeeDto employee;
}