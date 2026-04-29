package com.example.demo.repositoryimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
@Repository
public class EmployeeRepositoryimpl implements EmployeeRepository {
	/* This is my repository layer*/
	@Autowired
	public EntityManager entitymanager;

	@Override
	public Employee save(Employee vo) {
		try {
			entitymanager.persist(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<Employee> findAll() {
		 CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
	        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	        Root<Employee> root = cq.from(Employee.class);
	        cq.select(root);

	        return entitymanager.createQuery(cq).getResultList();
	}

	@Override
	public Employee findById(Long userid) {

	    CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
	    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	    Root<Employee> root = cq.from(Employee.class);

	    // where condition
	    cq.select(root).where(cb.equal(root.get("userid"), userid));

	    List<Employee> result = entitymanager.createQuery(cq).getResultList();

	    if (result.isEmpty()) {
	        return null;
	    }

	    return result.get(0);
	}

	@Override
	public Employee update(Employee existing) {
	    return entitymanager.merge(existing);
	}

	@Override
	public void delete(Employee existing) {
		entitymanager.remove(existing);
		
	}

	@Override
	public Employee findById(int id) {

	    CriteriaBuilder cb = entitymanager.getCriteriaBuilder();
	    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
	    Root<Employee> root = cq.from(Employee.class);

	    // where condition
	    cq.select(root).where(cb.equal(root.get("userid"), id));

	    List<Employee> result = entitymanager.createQuery(cq).getResultList();

	    if (result.isEmpty()) {
	        return null;
	    }

	    return result.get(0);
	}

}
