package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.PolicyDto;
import com.hr.hrsystem.models.Policy;

import java.util.List;

public interface PolicyService {
    public List<PolicyDto> findAllPolicies();
    public Policy saveDepartment(Policy policy);
    PolicyDto findPolicyById(Integer id);
    void updatePolicy(PolicyDto policy);
    void delete(Integer id);
}