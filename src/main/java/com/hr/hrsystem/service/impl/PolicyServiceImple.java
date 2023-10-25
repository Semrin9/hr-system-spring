package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.PolicyDto;
import com.hr.hrsystem.models.Policy;
import com.hr.hrsystem.repository.PolicyRepository;
import com.hr.hrsystem.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyServiceImple implements PolicyService {

    private PolicyRepository policyRepository;

    @Autowired
    public PolicyServiceImple(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public List<PolicyDto> findAllPolicies() {
        List<Policy> policies = policyRepository.findAll();
        return policies.stream().map((policy -> toDto(policy))).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        policyRepository.deleteById(id);
    }

    @Override
    public Policy saveDepartment(Policy policy) {
        return policyRepository.save(policy);
    }

    @Override
    public PolicyDto findPolicyById(Integer id) {
        Policy policy = policyRepository.findById(id).get();
        return toDto(policy);
    }

    @Override
    public void updatePolicy(PolicyDto policyDto) {
        Policy policy = mapToPolicy(policyDto);
        policyRepository.save(policy);
    }

    private Policy mapToPolicy(PolicyDto policyDto) {
        if ( policyDto == null ) {
            return null;
        }

        Policy policy = Policy.builder()
                .id(policyDto.getId())
                .policyTitle(policyDto.getPolicyTitle())
                .policyDescription(policyDto.getPolicyDescription())
                .build();
        return policy;
    }

    public PolicyDto toDto(Policy policy) {
        if ( policy == null ) {
            return null;
        }

        PolicyDto policyDto = PolicyDto.builder()
                .id(policy.getId())
                .policyTitle(policy.getPolicyTitle())
                .policyDescription(policy.getPolicyDescription())
                .build();
        return policyDto;
    }
}
