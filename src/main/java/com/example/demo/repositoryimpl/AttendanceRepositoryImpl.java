package com.example.demo.repositoryimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attendance;
import com.example.demo.repository.AttendanceRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

@Repository
public class AttendanceRepositoryImpl implements AttendanceRepository {

    @Autowired
    private EntityManager entityManager;

    /* ================= SAVE ================= */
    @Override
    public Attendance save(Attendance vo) {
        try {
            entityManager.persist(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vo;
    }

    /* ================= GET ALL (WITH EMPLOYEE JOIN) ================= */
    @Override
    public List<Attendance> findAll() {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Attendance> cq = cb.createQuery(Attendance.class);
        Root<Attendance> root = cq.from(Attendance.class);

        // 🔥 fetch relation
        root.fetch("employee", JoinType.LEFT);

        // 🔥 IMPORTANT FIX
        cq.select(root).distinct(true);

        return entityManager.createQuery(cq).getResultList();
    }

    /* ================= FILTER (DATE + STATUS + EMPLOYEE JOIN) ================= */
    @Override
    public List<Attendance> filter(String date, String status) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Attendance> cq = cb.createQuery(Attendance.class);
        Root<Attendance> root = cq.from(Attendance.class);

        // 🔥 JOIN employee
        root.join("employee", JoinType.LEFT);

        cq.select(root).distinct(true);

        if (date != null && !date.isEmpty() && status != null && !status.isEmpty()) {
            cq.where(cb.and(
                    cb.equal(root.get("date"), date),
                    cb.equal(root.get("status"), status)
            ));
        }
        else if (date != null && !date.isEmpty()) {
            cq.where(cb.equal(root.get("date"), date));
        }
        else if (status != null && !status.isEmpty()) {
            cq.where(cb.equal(root.get("status"), status));
        }

        return entityManager.createQuery(cq).getResultList();
    }
}