package com.hibernate_mapping.OneToOne.controller;

import com.hibernate_mapping.OneToOne.entity.Instructor;
import com.hibernate_mapping.OneToOne.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/saveInstructor")
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor instructor1 = instructorService.saveOrUpdate(instructor);
        return ResponseEntity.ok(instructor1);
    }

    @GetMapping("/findInstructorBy/{id}")
    public Optional<Instructor> findInstructor(@PathVariable("id") Long id) {
        Optional<Instructor> instructor = instructorService.findById(id);
        return instructor;
    }

    @DeleteMapping("/deleteBy/{instructorId}")
    public ResponseEntity<?> deleteInstructor(@PathVariable("instructorId") Long instructorId) {
        instructorService.delete(instructorId);
        return new ResponseEntity<>("Delete Successfully.", HttpStatus.OK);
    }
}
