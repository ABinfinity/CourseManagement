package com.springboot.coursemanagement.services;

import com.springboot.coursemanagement.coursedao.CourseDAO;
import com.springboot.coursemanagement.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDAO courseDAO;

//    List<Course> list;
    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(001,"Java Basics","Give basic implementation of java."));
//        list.add(new Course(002,"Spring Basics","Give basic implementation of spring boot."));
//        list.add(new Course(003,"Rest Basics","Give basic implementation of RESTful services."));
    }

    @Override
    public List<Course> getCourses() {
//        return list;
        return courseDAO.findAll();
    }

    @Override
    public Course getCourse(long courseID) {
//        Course c = null;
//        for(Course course:list){
//            if(course.getId() == courseID){
//                c = course;
//                break;
//            }
//        }
//
//        return c;
        return courseDAO.getOne(courseID);
    }

    @Override
    public String addCourse(Course course) {
//        list.add(course);
        courseDAO.save(course);
        return "{message: course added successfully!}";
    }

    @Override
    public Course updateCourse(Course course) {
//        list.forEach(e -> {
//            if(e.getId() == course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });
//        return course;
        courseDAO.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseID) {
//        list = this.list.stream().filter(e -> e.getId() != courseID).collect(Collectors.toList());
        Course entity = courseDAO.getOne(courseID);
        courseDAO.delete(entity);
    }
}
