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
@Table(name = "department", schema = "hr_system_database", indexes = {
        @Index(name = "department_name", columnList = "department_name", unique = true)
})
public class Department {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "department_name", nullable = false, length = 24)
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @Column(name = "department_head", nullable = false)
    private Integer departmentHead;

}