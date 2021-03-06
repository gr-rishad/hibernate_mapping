package com.hibernate_mapping.OneToOne.service;

import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import com.hibernate_mapping.OneToOne.entity.Instructor;
import com.hibernate_mapping.OneToOne.entity.InstructorDetails;
import com.hibernate_mapping.OneToOne.repository.InstructorJpaRepository;
import com.hibernate_mapping.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService implements BaseService<Instructor> {

    private InstructorJpaRepository instructorJpaRepository;
    List<Course> courseList = new ArrayList<>();

    @Autowired
    public InstructorService(InstructorJpaRepository instructorJpaRepository) {
        this.instructorJpaRepository = instructorJpaRepository;
    }

    @Override
    public Instructor saveOrUpdate(Instructor instructor) {
        InstructorDetails instructorDetails = instructor.getInstructorDetails();
        instructor.setInstructorDetails(instructorDetails);

/*
        //course
        Iterator<Course> obj= instructor.getCourses().iterator();
        while (obj.hasNext()){
            Course course=obj.next();
            instructor.addCourse(course);
        }
        for (Course course : instructor.getCourses()) {
             course.setInstructor(instructor);
             courseList.add(course);
        }
 */

        instructor.setCourses(courseList);
        instructor = instructorJpaRepository.save(instructor);
        return instructor;
    }


    @Override
    public Optional<Instructor> findById(Long id) {
        return instructorJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        instructorJpaRepository.deleteById(id);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorJpaRepository.findAll();
    }
}
