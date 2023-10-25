package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.LocationDto;
import com.hr.hrsystem.models.Location;
import com.hr.hrsystem.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/locations")
    public String listLocations(Model model) {
        List<LocationDto> locations = locationService.findAllLocations();
        Location location = new Location();

        model.addAttribute("locations", locations);
        model.addAttribute("location", location);

        return "locations-list";
    }

    @PostMapping("/locations")
    public String saveLocation(@ModelAttribute("location") LocationDto locationDto) {
        locationService.saveLocation(locationDto);
        return "redirect:/locations";
    }

    @GetMapping("/locations/{id}/edit")
    public String editLocationForm(@PathVariable("id") Integer id, Model model) {
        LocationDto location = locationService.findLocationById(id);
        model.addAttribute("location", location);
        return "edit/location-edit";
    }

    @PostMapping("/locations/{id}/edit")
    public String updateLocation(@PathVariable("id") Integer id, @ModelAttribute("location") LocationDto location) {
        location.setId(id);
        locationService.updateLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/locations/{id}/delete ")
    public String deleteLocation (@PathVariable("id") Integer id) {
        locationService.delete(id);
        return "redirect:/locations";
    }
}
