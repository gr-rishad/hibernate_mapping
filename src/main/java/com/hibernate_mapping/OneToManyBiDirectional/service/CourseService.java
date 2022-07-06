package com.hibernate_mapping.OneToManyBiDirectional.service;

import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import com.hibernate_mapping.OneToManyBiDirectional.repository.CourseRepository;
import com.hibernate_mapping.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements BaseService<Course> {

    private CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveOrUpdate(Course course) {

        //course.addReview(course.getReviews().stream().map(review -> Review::new));
        // course.addReview(course.getReviews().stream().map());
        //for (Review review: course.getReviews()){
        //  course.setReviews(course.getReviews());
        // course.
        //}

//        for (Student student: course.getStudents()){
//            course.setStudents(student);
//
//        }


        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
