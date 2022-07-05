package com.hibernate_mapping.OneToManyUni.service;

import com.hibernate_mapping.OneToManyUni.entity.Review;
import com.hibernate_mapping.OneToManyUni.repo.ReviewJpaRepo;
import com.hibernate_mapping.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReviewService implements BaseService<Review> {

    private ReviewJpaRepo reviewJpaRepo;

    @Autowired
    public ReviewService(ReviewJpaRepo reviewJpaRepo) {
        this.reviewJpaRepo = reviewJpaRepo;
    }

    @Override
    public Review saveOrUpdate(Review review) {
        return reviewJpaRepo.save(review);
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewJpaRepo.findById(id);
    }

    @Override
    public void delete(Long id) {
        reviewJpaRepo.deleteById(id);
    }

    @Override
    public List<Review> findAll() {
        return reviewJpaRepo.findAll();
    }
}
