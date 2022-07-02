package com.hibernate_mapping.OneToOne.controller;

import com.hibernate_mapping.OneToOne.entity.Instructor;
import com.hibernate_mapping.OneToOne.entity.InstructorDetails;
import com.hibernate_mapping.OneToOne.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/saveInstructor")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor){
        Instructor instructor1= instructorService.saveOrUpdate(instructor);
        return ResponseEntity.ok(instructor1);
    }
}
