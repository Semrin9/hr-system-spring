package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.DepartmentDto;
import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.models.Department;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.repository.DepartmentRepository;
import com.hr.hrsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImple implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImple(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> findAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((attendance -> mapToDepartmentDto(attendance))).collect(Collectors.toList());
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDto findDepartmentById(Integer id) {
        Department department = departmentRepository.findById(id).get();
        return mapToDepartmentDto(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentRepository.save(department);
    }

    private LocationDto convertLocationToLocationDto(Location location) {
        if (location == null) {
            return null;
        }

        return LocationDto.builder()
                .id(location.getId())
                .locationName(location.getLocationName())
                .build();
    }

    private Location convertLocationToLocation(LocationDto locationDto) {
        if (locationDto == null) {
            return null;
        }

        return Location.builder()
                .id(locationDto.getId())
                .locationName(locationDto.getLocationName())
                .build();
    }

    private Department mapToDepartment(DepartmentDto departmentDto) {
        if ( departmentDto == null ) {
            return null;
        }

        Location location = convertLocationToLocation(departmentDto.getLocation());
        Department department = Department.builder()
                .id(departmentDto.getId())
                .departmentName(departmentDto.getDepartmentName())
                .location(location)
                .departmentHead(departmentDto.getDepartmentHead())
                .build();
        return department;
    }

    public DepartmentDto mapToDepartmentDto(Department department) {
        if ( department == null ) {
            return null;
        }

        LocationDto locationDto = convertLocationToLocationDto(department.getLocation());
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .location(locationDto)
                .departmentHead(department.getDepartmentHead())
                .build();
        return departmentDto;
    }
}