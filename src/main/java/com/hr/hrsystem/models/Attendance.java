package com.hr.hrsystem.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "attendance", schema = "hr_system_database")
public class Attendance {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @CreationTimestamp
    @Column(name = "attendance_date")
    private LocalDate attendanceDate;

    @CreationTimestamp
    @Column(name = "clock_in")
    private LocalTime clockIn;

    @UpdateTimestamp
    @Column(name = "clock_out")
    private LocalTime clockOut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

}