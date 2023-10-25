package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepository extends JpaRepository<Payroll, Integer> {
}