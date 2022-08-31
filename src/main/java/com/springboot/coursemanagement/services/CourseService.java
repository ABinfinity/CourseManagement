package com.springboot.coursemanagement.services;

import com.springboot.coursemanagement.entities.Course;


import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseID);

    public String addCourse(Course course);

    public Course updateCourse(Course course);

    public void deleteCourse(long parseLong);
}
