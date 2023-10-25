package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.PolicyDto;
import com.hr.hrsystem.models.Policy;
import com.hr.hrsystem.service.LocationService;
import com.hr.hrsystem.service.PolicyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PolicyController {

    private PolicyService policyService;
    private LocationService locationService;

    public PolicyController(PolicyService policyService, LocationService locationService) {
        this.policyService = policyService;
        this.locationService = locationService;
    }

    @GetMapping("/policies")
    public String listPolicies(Model model) {
        List<PolicyDto> policies = policyService.findAllPolicies();
        List<LocationDto> locations = locationService.findAllLocations();
        Policy policy = new Policy();

        model.addAttribute("policies", policies);
        model.addAttribute("locations", locations);
        model.addAttribute("policy", policy);

        return "policies-list";
    }

    @PostMapping("/policies")
    public String savePolicy(@ModelAttribute("policy") Policy policy) {
        policyService.saveDepartment(policy);
        return "redirect:/policies";
    }

    @GetMapping("/policies/{id}/edit")
    public String editPolicyForm(@PathVariable("id") Integer id, Model model) {
        PolicyDto policy = policyService.findPolicyById(id);
        model.addAttribute("policy", policy);
        return "edit/policy-edit";
    }

    @PostMapping("/policies/{id}/edit")
    public String updateLocation(@PathVariable("id") Integer id, @ModelAttribute("policy") PolicyDto policy) {
        policy.setId(id);
        policyService.updatePolicy(policy);
        return "redirect:/policies";
    }

    @GetMapping("/policies/{id}/delete")
    public String deletePolicy (@PathVariable("id") Integer id) {
        policyService.delete(id);
        return "redirect:/policies";
    }
}
