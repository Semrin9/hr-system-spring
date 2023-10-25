package com.hr.hrsystem.service.impl;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.repository.LocationRepository;
import com.hr.hrsystem.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImple implements LocationService {

    private LocationRepository locationRepository;

    public LocationServiceImple(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDto> findAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map((location -> mapToLocationDto(location))).collect(Collectors.toList());
    }

    @Override
    public Location saveLocation(LocationDto locationDto) {
        Location location = mapToLocation(locationDto);
        return locationRepository.save(location);
    }

    @Override
    public LocationDto findLocationById(Integer id) {
        Location location = locationRepository.findById(id).get();
        return mapToLocationDto(location);
    }

    @Override
    public void updateLocation(LocationDto locationDto) {
        Location location = mapToLocation(locationDto);
        locationRepository.save(location);
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }

    private Location mapToLocation(LocationDto locationDto) {
        if ( locationDto == null ) {
            return null;
        }

        Location location = Location.builder()
                .id(locationDto.getId())
                .locationName(locationDto.getLocationName())
                .city(locationDto.getCity())
                .country(locationDto.getCountry())
                .locationEmail(locationDto.getLocationEmail())
                .locationNumber(locationDto.getLocationNumber())
                .numOfEmployees(locationDto.getNumOfEmployees())
                .build();
        return location;
    }

    public LocationDto mapToLocationDto(    Location location) {
        if ( location == null ) {
            return null;
        }

        LocationDto locationDto = LocationDto.builder()
                .id(location.getId())
                .locationName(location.getLocationName())
                .city(location.getCity())
                .country(location.getCountry())
                .locationEmail(location.getLocationEmail())
                .locationNumber(location.getLocationNumber())
                .numOfEmployees(location.getNumOfEmployees())
                .build();
        return locationDto;
    }
}
