package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.PayrollDto;
import com.hr.hrsystem.models.Payroll;
import com.hr.hrsystem.repository.PayrollRepository;
import com.hr.hrsystem.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayrollServiceImple implements PayrollService {

    private PayrollRepository payrollRepository;

    @Autowired
    public PayrollServiceImple(PayrollRepository payrollRepository) {
        this.payrollRepository = payrollRepository;
    }

    public List<PayrollDto> findAllPayrolls() {
        List<Payroll> payrolls = payrollRepository.findAll();
        return payrolls.stream().map((payroll -> toDto(payroll))).collect(Collectors.toList());
    }

    @Override
    public long getTotalNumberOfRoles() {
        return payrollRepository.count();
    }

    @Override
    public void delete(Integer id) {
        payrollRepository.deleteById(id);
    }

    @Override
    public Payroll savePayroll(PayrollDto payrollDto) {
        Payroll payroll = mapToPayroll(payrollDto);
        return payrollRepository.save(payroll);
    }

    @Override
    public PayrollDto findPayrollById(Integer id) {
        Payroll payroll = payrollRepository.findById(id).get();
        return toDto(payroll);
    }

    @Override
    public void updatePayroll(PayrollDto payrollDto) {
        Payroll payroll = mapToPayroll(payrollDto);
        payrollRepository.save(payroll);
    }

    private Payroll mapToPayroll(PayrollDto payrollDto) {
        if ( payrollDto == null ) {
            return null;
        }

        Payroll payroll = Payroll.builder()
                .id(payrollDto.getId())
                .payrollTemplateName(payrollDto.getPayrollTemplateName())
                .basicSalary(payrollDto.getBasicSalary())
                .overtimeRate(payrollDto.getOvertimeRate())
                .housingAllowance(payrollDto.getHousingAllowance())
                .medicalAllowance(payrollDto.getMedicalAllowance())
                .build();
        return payroll;
    }

    public PayrollDto toDto(Payroll payroll) {
        if ( payroll == null ) {
            return null;
        }

        PayrollDto payrollDto = PayrollDto.builder()
                .id(payroll.getId())
                .payrollTemplateName(payroll.getPayrollTemplateName())
                .basicSalary(payroll.getBasicSalary())
                .overtimeRate(payroll.getOvertimeRate())
                .housingAllowance(payroll.getHousingAllowance())
                .medicalAllowance(payroll.getMedicalAllowance())
                .build();
        return payrollDto;
    }

    public Payroll partialUpdate(PayrollDto payrollDto, Payroll payroll) {
        if ( payrollDto == null ) {
            return payroll;
        }

        return payroll;
    }
}
