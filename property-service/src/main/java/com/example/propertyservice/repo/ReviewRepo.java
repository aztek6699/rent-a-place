package com.example.propertyservice.repo;

import com.example.propertyservice.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewModel, Long> {

    List<ReviewModel> findAllByPropertyIdOrderByRatingDesc(Long propertyId);
}
