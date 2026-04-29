package com.example.demo.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 🔗 Employee relation
    @ManyToOne
    @JoinColumn(name = "userid")
    private Employee employee;
    
    private String date;
    private String status;

    // GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

   
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
    
}