package com.hr.hrsystem.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payroll", schema = "hr_system_database", indexes = {
        @Index(name = "payroll_template_name", columnList = "payroll_template_name", unique = true)
})
public class Payroll {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "payroll_template_name", nullable = false, length = 24)
    private String payrollTemplateName;

    @Column(name = "basic_salary", nullable = false, precision = 6, scale = 2)
    private BigDecimal basicSalary;

    @Column(name = "overtime_rate", precision = 6, scale = 2)
    private BigDecimal overtimeRate;

    @Column(name = "housing_allowance", precision = 6, scale = 2)
    private BigDecimal housingAllowance;

    @Column(name = "medical_allowance", precision = 6, scale = 2)
    private BigDecimal medicalAllowance;

    public BigDecimal calculateNetSalary() {
        BigDecimal grossSalary = basicSalary.add(overtimeRate).add(housingAllowance).add(medicalAllowance);
        return grossSalary;
    }
}