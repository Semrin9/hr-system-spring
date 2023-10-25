package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.RoleDto;
import com.hr.hrsystem.models.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    public List<RoleDto> findAllRolls();
    Map<RoleDto, Long> getRoleEmployeeCounts();
    long getTotalNumberOfRoles();
    Role saveRole(RoleDto roleDto);
    RoleDto findRoleById(Integer id);
    void updateRole(RoleDto role);
    void delete(Integer id);

}