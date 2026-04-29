package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.AttendanceBO;
import com.example.demo.service.AttendanceService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AttendanceController {

    @Autowired
    private AttendanceService service;

    @PostMapping("/attendance")
    public ResponseEntity<AttendanceBO> createAttendance(@RequestBody AttendanceBO bo) {
        AttendanceBO attendance = service.create(bo);
        return ResponseEntity.ok(attendance);
    }

  
    @GetMapping("/attendance")
    public ResponseEntity<List<AttendanceBO>> getAllAttendance() {
        List<AttendanceBO> list = service.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/attendance/filter")
    public ResponseEntity<List<AttendanceBO>> filterAttendance(
            @RequestParam(required = false) String date,
            @RequestParam(required = false) String status) {

        List<AttendanceBO> list = service.filter(date, status);
        return ResponseEntity.ok(list);
    }
}