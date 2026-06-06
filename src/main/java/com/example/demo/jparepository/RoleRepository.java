package com.example.demo.jparepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Roles;


public interface RoleRepository extends JpaRepository<Roles, Long>{
	
	Optional<Roles> findByname(String name);

}
