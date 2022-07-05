package com.hibernate_mapping.OneToManyUni.repo;

import com.hibernate_mapping.OneToManyUni.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewJpaRepo extends JpaRepository<Review, Long> {
}
