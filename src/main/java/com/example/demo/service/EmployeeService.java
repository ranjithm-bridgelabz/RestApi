package com.example.demo.service;

import java.util.List;

import com.example.demo.model.EmployeeBO;

public interface EmployeeService {
	/* This is my Service layer */

	EmployeeBO create(EmployeeBO bo);

	List<EmployeeBO> getAll();

}
