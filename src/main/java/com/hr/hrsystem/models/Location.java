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
@Table(name = "location", schema = "hr_system_database", indexes = {
        @Index(name = "location_name", columnList = "location_name", unique = true),
        @Index(name = "location_email", columnList = "location_email", unique = true),
        @Index(name = "location_number", columnList = "location_number", unique = true)
})
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column(name = "location_name", nullable = false, length = 24)
    private String locationName;

    @Column(name = "city", nullable = false, length = 24)
    private String city;

    @Column(name = "country", nullable = false, length = 24)
    private String country;

    @Column(name = "location_email", nullable = false, length = 50)
    private String locationEmail;

    @Column(name = "location_number", nullable = false)
    private Integer locationNumber;

    @Getter
    private long numOfEmployees;
}