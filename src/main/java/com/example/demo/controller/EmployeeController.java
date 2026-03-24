package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeBO;
import com.example.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api")
public class EmployeeController {
	/* This is my rest api */
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeBO> createemployee(@RequestBody EmployeeBO bo)
	{
		EmployeeBO employee=service.create(bo);
		
		return new ResponseEntity<EmployeeBO>(employee, HttpStatus.OK);
		
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeBO>> getAllEmployees() {

	    List<EmployeeBO> employees = service.getAll();

	    return ResponseEntity.ok(employees);
	}
	
	

}
