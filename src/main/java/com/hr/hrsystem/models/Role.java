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
@Table(name = "role", schema = "hr_system_database", indexes = {
        @Index(name = "role_title", columnList = "role_title", unique = true)
})
public class Role {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "role_title")
    private String roleTitle;

    @Column(name = "role_description")
    private String roleDescription;

}