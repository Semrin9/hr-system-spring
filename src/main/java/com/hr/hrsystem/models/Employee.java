package com.hr.hrsystem.models;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "employee", schema = "hr_system_database", indexes = {
        @Index(name = "employee_name", columnList = "employee_name", unique = true),
        @Index(name = "employee_email", columnList = "employee_email", unique = true),
        @Index(name = "phone_number", columnList = "phone_number", unique = true)
})
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "employee_name", nullable = false, length = 24)
    private String employeeName;

    @Column(name = "employee_age", nullable = false)
    private Integer employeeAge;

    @Column(name = "employee_gender", nullable = false, length = 7)
    private String employeeGender;

    @Column(name = "employee_email", nullable = false, length = 50)
    private String employeeEmail;

    @Column(name = "employee_job", nullable = false, length = 24)
    private String employeeJob;

    @Column(name = "phone_number", nullable = false)
    private Integer phoneNumber;

    @Column(name = "employee_username", nullable = false, length = 24)
    private String employeeUsername;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payroll_id", nullable = false)
    private Payroll payroll;

}