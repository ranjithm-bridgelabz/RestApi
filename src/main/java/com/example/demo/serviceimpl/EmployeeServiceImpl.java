package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeBO;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	public EmployeeRepository dao;

	@Override
	public EmployeeBO create(EmployeeBO bo) {
		Employee vo=new Employee();
		  BeanUtils.copyProperties(bo, vo);
		    vo = dao.save(vo);
		    EmployeeBO response = new EmployeeBO();
		    BeanUtils.copyProperties(vo, response);

		    return response;
	}

	@Override
	public List<EmployeeBO> getAll() {

	    List<Employee> employees = dao.findAll();

	    List<EmployeeBO> boList = new ArrayList<>();

	    for (Employee emp : employees) {
	        EmployeeBO bo = new EmployeeBO();
	        BeanUtils.copyProperties(emp, bo);
	        boList.add(bo);
	    }

	    return boList;
	}

}
