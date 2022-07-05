package com.hibernate_mapping.OneToManyBiDirectional.controller;

import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import com.hibernate_mapping.OneToManyBiDirectional.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courseController")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping("/saveCourse")
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        Course course1 = courseService.saveOrUpdate(course);
        return ResponseEntity.ok(course1);
    }

    @GetMapping("/findCourse")
    public ResponseEntity<?> findAllCourse() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.delete(courseId);
        return ResponseEntity.ok("Delete Successfully");
    }
}
