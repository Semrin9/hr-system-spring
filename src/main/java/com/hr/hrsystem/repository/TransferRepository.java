package com.hr.hrsystem.repository;

import com.hr.hrsystem.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}