package com.hibernate_mapping.OneToOne.service;

import com.hibernate_mapping.OneToOne.entity.InstructorDetails;
import com.hibernate_mapping.OneToOne.repository.InstructorDetailJpaRepository;
import com.hibernate_mapping.exception.ResourceNotFoundException;
import com.hibernate_mapping.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorDetailService implements BaseService<InstructorDetails> {

    private InstructorDetailJpaRepository instructorDetailJpaRepository;

    @Autowired
    public InstructorDetailService(InstructorDetailJpaRepository instructorDetailJpaRepository) {
        this.instructorDetailJpaRepository = instructorDetailJpaRepository;
    }

    @Override
    public InstructorDetails saveOrUpdate(InstructorDetails instructorDetails) {
        return instructorDetailJpaRepository.save(instructorDetails);
    }

    @Override
    public Optional<InstructorDetails> findById(Long id) {
        InstructorDetails instructorDetails = instructorDetailJpaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("InstructorDetail", "id", id));
        return Optional.of(instructorDetails);
    }

    @Override
    public void delete(Long id) {
        InstructorDetails instructorDetails = findById(id).orElseThrow(() -> new ResourceNotFoundException("InstructorDetail", "id", id));
        instructorDetails.getInstructor().setInstructorDetails(null);
        instructorDetailJpaRepository.deleteById(id);
    }

    @Override
    public List<InstructorDetails> findAll() {
        return instructorDetailJpaRepository.findAll();
    }
}
