package com.example.demo.service;

import java.util.List;

import com.example.demo.model.AttendanceBO;

public interface AttendanceService {

	AttendanceBO create(AttendanceBO bo);

	List<AttendanceBO> getAll();

	List<AttendanceBO> filter(String date, String status);

}
