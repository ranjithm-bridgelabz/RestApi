package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Attendance;
import com.example.demo.model.AttendanceBO;

public interface AttendanceRepository  {

	Attendance save(Attendance vo);

	List<Attendance> findAll();

	List<Attendance> filter(String date, String status);

}
