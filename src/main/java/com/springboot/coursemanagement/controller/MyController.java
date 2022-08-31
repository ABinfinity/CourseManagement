package com.springboot.coursemanagement.controller;

import com.springboot.coursemanagement.entities.Course;
import com.springboot.coursemanagement.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    @GetMapping("/course/{courseID}")
    public Course getCourse(@PathVariable String courseID){
        return this.courseService.getCourse(Long.parseLong(courseID));
    }

    @PostMapping("/course")
    public String addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/course/{courseID}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseID){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseID));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
