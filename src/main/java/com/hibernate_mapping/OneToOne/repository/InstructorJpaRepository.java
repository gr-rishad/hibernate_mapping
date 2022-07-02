package com.hibernate_mapping.OneToOne.repository;

import com.hibernate_mapping.OneToOne.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorJpaRepository extends JpaRepository<Instructor,Long> {
}
