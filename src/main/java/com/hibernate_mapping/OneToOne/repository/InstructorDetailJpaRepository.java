package com.hibernate_mapping.OneToOne.repository;

import com.hibernate_mapping.OneToOne.entity.InstructorDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailJpaRepository extends JpaRepository<InstructorDetails,Long> {
}
