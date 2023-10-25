package com.hr.hrsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO for {@link com.hr.hrsystem.models.Payroll}
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayrollDto {
    private Integer id;
    private String payrollTemplateName;
    private BigDecimal basicSalary;
    private BigDecimal overtimeRate;
    private BigDecimal housingAllowance;
    private BigDecimal medicalAllowance;
}