package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.PayrollDto;
import com.hr.hrsystem.models.Payroll;
import com.hr.hrsystem.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PayrollController {

    private PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping("/payrolls")
    public String listPayrolls(Model model) {
        List<PayrollDto> payrolls = payrollService.findAllPayrolls();
        Payroll payroll = new Payroll();

        model.addAttribute("payrolls", payrolls);
        model.addAttribute("payroll", payroll);

        return "payrolls-list";
    }

    @PostMapping("/payrolls")
    public String savePayroll(@ModelAttribute("payroll") PayrollDto payrollDto) {
        payrollService.savePayroll(payrollDto);
        return "redirect:/payrolls";
    }

    @GetMapping("/payrolls/{id}/edit")
    public String editPayrollForm(@PathVariable("id") Integer id, Model model) {
        PayrollDto payroll = payrollService.findPayrollById(id);
        model.addAttribute("payroll", payroll);
        return "edit/payroll-edit";
    }

    @PostMapping("/payrolls/{id}/edit")
    public String updateLocation(@PathVariable("id") Integer id, @ModelAttribute("payroll") PayrollDto payroll) {
        payroll.setId(id);
        payrollService.updatePayroll(payroll);
        return "redirect:/payrolls";
    }

    @GetMapping("/payrolls/{id}/delete")
    public String deletePayroll (@PathVariable("id") Integer id) {
        payrollService.delete(id);
        return "redirect:/payrolls";
    }
}
