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
	/* This is my service layer */
	/* Bussiness logic */
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

	@Override
	public EmployeeBO update(Long userid, EmployeeBO bo) {

	    // existing record eduthukrom
	    Employee existing = dao.findById(userid);
	       

	    // fields update pannrom
	    existing.setName(bo.getName());
	    existing.setEmail(bo.getEmail());

	    // save pannrom
	    Employee updated = dao.update(existing);

	    // response return pannrom
	    EmployeeBO response = new EmployeeBO();
	    BeanUtils.copyProperties(updated, response);

	    return response;
	}

	@Override
	public void delete(Long userid) {

	    // first DB la iruka record edukkrom
	    Employee existing = dao.findById(userid);

	    // check pannrom (important)
	    if (existing == null) {
	        throw new RuntimeException("Employee not found");
	    }

	    // delete pannrom
	    dao.delete(existing);
	}

}
