package com.example.demo.repository;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeRepository {
	/* This is my repository layer */

	Employee save(Employee vo);

	List<Employee> findAll();

	Employee findById(Long userid);

	Employee update(Employee existing);

	void delete(Employee existing);

	Employee findById(int id);


}
