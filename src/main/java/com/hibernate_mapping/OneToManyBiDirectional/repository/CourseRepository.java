package com.hibernate_mapping.OneToManyBiDirectional.repository;

import com.hibernate_mapping.OneToManyBiDirectional.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
