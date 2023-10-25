package com.hr.hrsystem.service;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.models.Location;


import javax.tools.DocumentationTool;
import java.util.List;

public interface LocationService {
    public List<LocationDto> findAllLocations();
    Location saveLocation(LocationDto locationDto);
    LocationDto findLocationById(Integer id);
    void updateLocation(LocationDto location);
    void delete(Integer id);
}