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
@Table(name = "policy", schema = "hr_system_database", indexes = {
        @Index(name = "policy_title", columnList = "policy_title", unique = true)
})
public class Policy {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "policy_title")
    private String policyTitle;

    @Column(name = "policy_description")
    private String policyDescription;

}