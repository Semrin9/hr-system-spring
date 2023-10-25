package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.RoleDto;
import com.hr.hrsystem.models.Role;
import com.hr.hrsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public String listRoles(Model model) {
        List<RoleDto> roles = roleService.findAllRolls();
        Map<RoleDto, Long> roleEmployeeCounts = roleService.getRoleEmployeeCounts();
        Role role = new Role();
        model.addAttribute("roles", roles);
        model.addAttribute("role", role);
        model.addAttribute("roleEmployeeCounts", roleEmployeeCounts);

        return "roles-list";
    }

    @PostMapping("/roles")
    public String saveRole(@ModelAttribute("role") RoleDto roleDto) {
        roleService.saveRole(roleDto);
        return "redirect:/roles";
    }

    @GetMapping("/roles/{id}/edit")
    public String editRoleForm(@PathVariable("id") Integer id, Model model) {
        RoleDto role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        return "edit/role-edit";
    }

    @PostMapping("/roles/{id}/edit")
    public String updateLocation(@PathVariable("id") Integer id, @ModelAttribute("role") RoleDto role) {
        role.setId(id);
        roleService.updateRole(role);
        return "redirect:/roles";
    }

    @GetMapping("/roles/{id}/delete")
    public String deleteRole (@PathVariable("id") Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }
}
