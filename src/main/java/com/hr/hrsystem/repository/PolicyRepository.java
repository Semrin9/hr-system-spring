package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
}