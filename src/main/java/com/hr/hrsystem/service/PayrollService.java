package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.PayrollDto;
import com.hr.hrsystem.models.Payroll;


import java.util.List;

public interface PayrollService {
    public List<PayrollDto> findAllPayrolls();
    public long getTotalNumberOfRoles();
    void delete(Integer id);
    Payroll savePayroll(PayrollDto payrollDto);

    PayrollDto findPayrollById(Integer id);

    void updatePayroll(PayrollDto payroll);
}