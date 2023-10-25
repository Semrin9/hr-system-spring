package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.RoleDto;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.models.Role;
import com.hr.hrsystem.repository.EmployeeRoleRepository;
import com.hr.hrsystem.repository.RoleRepository;
import com.hr.hrsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private EmployeeRoleRepository employeeRoleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, EmployeeRoleRepository employeeRoleRepository) {
        this.roleRepository = roleRepository;
        this.employeeRoleRepository = employeeRoleRepository;
    }

    @Override
    public List<RoleDto> findAllRolls() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map((role -> toDto(role))).collect(Collectors.toList());
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Map<RoleDto, Long> getRoleEmployeeCounts() {
        List<RoleDto> allRoles = findAllRolls();
        Map<RoleDto, Long> roleEmployeeCounts = new HashMap<>();

        for (RoleDto roleDto : allRoles) {
            Role role = mapToRole(roleDto);
            long employeeCount = employeeRoleRepository.countByRole(role);
            roleEmployeeCounts.put(roleDto, employeeCount);
        }

        return roleEmployeeCounts;
    }

    @Override
    public long getTotalNumberOfRoles() {
        return roleRepository.count();
    }

    @Override
    public void delete(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role saveRole(RoleDto roleDto) {
        Role role = mapToRole(roleDto);
        return roleRepository.save(role);
    }

    @Override
    public RoleDto findRoleById(Integer id) {
        Role role = roleRepository.findById(id).get();
        return mapToRoleDto(role);
    }

    @Override
    public void updateRole(RoleDto roleDto) {
        Role role = mapToRole(roleDto);
        roleRepository.save(role);
    }

    private RoleDto mapToRoleDto(Role role) {
        if (role == null) {
            return null;
        }

        RoleDto roleDto = RoleDto.builder()
                .id(role.getId())
                .roleTitle(role.getRoleTitle())
                .roleDescription(role.getRoleDescription())
                .build();
        return roleDto;
    }

    private Role mapToRole(RoleDto roleDto) {
        Role role = Role.builder()
                .id(roleDto.getId())
                .roleTitle(roleDto.getRoleTitle())
                .roleDescription(roleDto.getRoleDescription())
                .build();
        return role;
    }

        public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = RoleDto.builder()
                .id(role.getId())
                .roleTitle(role.getRoleTitle())
                .roleDescription(role.getRoleDescription())
                .build();

        return roleDto;
    }

    public Role partialUpdate(RoleDto roleDto, Role role) {
        if ( roleDto == null ) {
            return role;
        }

        return role;
    }
}
