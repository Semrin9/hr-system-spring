package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}