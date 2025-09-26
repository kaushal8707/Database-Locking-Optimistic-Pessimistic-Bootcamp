package com.selfdeveloped.jpa.many_to_many;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByNameContaining(String name);
}
