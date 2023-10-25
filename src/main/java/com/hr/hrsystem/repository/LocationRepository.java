package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}