package com.hibernate_mapping.OneToOne.controller;

import com.hibernate_mapping.OneToOne.entity.InstructorDetails;
import com.hibernate_mapping.OneToOne.service.InstructorDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/instructorDetailController")
public class InstructorDetailController {

    private InstructorDetailService instructorDetailService;

    public InstructorDetailController(InstructorDetailService instructorDetailService) {
        this.instructorDetailService = instructorDetailService;
    }

    @GetMapping("/instructorDetail/{id}")
    public Optional<InstructorDetails> findInstructorDetail(@PathVariable("id") Long id) {
        Optional<InstructorDetails> instructorDetails = instructorDetailService.findById(id);
        return instructorDetails;
    }

    @DeleteMapping("/deleteInstructorDetailBy/{id}")
    public ResponseEntity<?> deleteInstructorDetail(@PathVariable("id") Long id) {
        instructorDetailService.delete(id);
        return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
    }
}
