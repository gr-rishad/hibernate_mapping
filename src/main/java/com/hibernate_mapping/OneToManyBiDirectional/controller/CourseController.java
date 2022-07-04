package com.hibernate_mapping.OneToManyBiDirectional.controller;

import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import com.hibernate_mapping.OneToManyBiDirectional.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
