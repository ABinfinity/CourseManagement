package com.springboot.coursemanagement.coursedao;

import com.springboot.coursemanagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Long> {
}
