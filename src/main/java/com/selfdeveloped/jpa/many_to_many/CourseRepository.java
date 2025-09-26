package com.selfdeveloped.jpa.many_to_many;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{

	List<Course> findByFeeLessThan(double fee);
}
