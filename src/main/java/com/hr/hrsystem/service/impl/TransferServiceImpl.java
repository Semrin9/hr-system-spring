package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.EmployeeDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.dto.TransferDto;
import com.hr.hrsystem.models.Employee;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.models.Transfer;
import com.hr.hrsystem.repository.TransferRepository;
import com.hr.hrsystem.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {

    private TransferRepository transferRepository;

    @Autowired
    public TransferServiceImpl(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public List<TransferDto> findAllTransfers() {
        List<Transfer> transfers = transferRepository.findAll();
        return transfers.stream().map((transfer -> toDto(transfer))).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        transferRepository.deleteById(id);
    }

    private LocationDto convertLocationToLocationDto(Location location) {
        if (location == null) {
            return null;
        }

        LocationDto locationDto = LocationDto.builder()
                .id(location.getId())
                .locationName(location.getLocationName())
                .build();

        return locationDto;
    }

    private EmployeeDto convertEmployeeToEmployeeDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        LocationDto locationDto = convertLocationToLocationDto(employee.getLocation());
        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .employeeName(employee.getEmployeeName())
                .location(locationDto)
                .build();

        return employeeDto;
    }

    public TransferDto toDto(Transfer transfer) {
        if (transfer == null) {
            return null;
        }

        LocationDto locationDto = convertLocationToLocationDto(transfer.getLocation());
        EmployeeDto employeeDto = convertEmployeeToEmployeeDto(transfer.getEmployee());

        TransferDto transferDto = TransferDto.builder()
                .id(transfer.getId())
                .transferDate(transfer.getTransferDate())
                .transferDescription(transfer.getTransferDescription())
                .location(locationDto)
                .employee(employeeDto)
                .build();

        return transferDto;
    }

    public Transfer partialUpdate(TransferDto transferDto, Transfer transfer) {
        if ( transferDto == null ) {
            return transfer;
        }

        return transfer;
    }
}
