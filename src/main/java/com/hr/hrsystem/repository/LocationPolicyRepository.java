package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.LocationPolicy;
import com.hr.hrsystem.models.LocationPolicyId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationPolicyRepository extends JpaRepository<LocationPolicy, LocationPolicyId> {
}