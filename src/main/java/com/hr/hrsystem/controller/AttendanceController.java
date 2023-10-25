package com.hr.hrsystem.controller;

import com.hr.hrsystem.dto.AttendanceDto;
import com.hr.hrsystem.models.Attendance;
import com.hr.hrsystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AttendanceController {

    private AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendances")
    public String listAttendances(Model model) {
        List<AttendanceDto> attendances = attendanceService.findAllAttendances();
        Attendance attendance = new Attendance();
        model.addAttribute("attendances", attendances);
        model.addAttribute("attendance", attendance);
        return "attendances-list";
    }

    @PostMapping("/attendances")
    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
        attendanceService.saveAttendance(attendance);
        return "redirect:/attendances";
    }

    @GetMapping("/attendances/{id}/delete")
    public String deleteAttendance (@PathVariable("id") long id) {
        attendanceService.delete(id);
        return "redirect:/attendances";
    }
}
