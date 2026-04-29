package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Employee;
import com.example.demo.model.AttendanceBO;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AttendanceService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository dao;

    @Autowired
    private EmployeeRepository employeeDao;

    // ================= CREATE =================
    @Override
    public AttendanceBO create(AttendanceBO bo) {

        Attendance vo = new Attendance();

        // userid -> Employee mapping
        Employee emp = employeeDao.findById(bo.getEmployeeid());

        vo.setEmployee(emp);
        vo.setDate(bo.getDate());
        vo.setStatus(bo.getStatus());

        vo = dao.save(vo);

        AttendanceBO response = new AttendanceBO();
        response.setId(vo.getId());
//        response.setUserid(emp.getUserid());
       // response.setName(emp.getName());
//        response.setDate(vo.getDate().toString());
        response.setStatus(vo.getStatus());

        return response;
    }

    @Override
    public List<AttendanceBO> getAll() {

        List<Attendance> list = dao.findAll();

        return list.stream()
                .map(a -> {
                    AttendanceBO bo = new AttendanceBO();

                    bo.setId(a.getId());
                    bo.setDate(a.getDate());
                    bo.setStatus(a.getStatus());

                    // 🔥 SAFE NULL HANDLING
                    bo.setName(
                        a.getEmployee() != null 
                            ? a.getEmployee().getName() 
                            : "No Employee"
                    );

                    return bo;
                })
                .toList();
    }

    @Override
    public List<AttendanceBO> filter(String date, String status) {

        List<Attendance> list = dao.filter(date, status);

        return list.stream()
                .map(a -> {
                    AttendanceBO bo = new AttendanceBO();

                    bo.setId(a.getId());
                    bo.setDate(a.getDate());
                    bo.setStatus(a.getStatus());

                    // 🔥 SAFE NULL HANDLING (IMPORTANT)
                    bo.setName(
                        a.getEmployee() != null 
                            ? a.getEmployee().getName() 
                            : "No Employee"
                    );

                    return bo;
                })
                .toList();
    }

}