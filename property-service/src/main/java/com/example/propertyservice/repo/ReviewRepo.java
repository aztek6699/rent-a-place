package com.example.propertyservice.repo;

import com.example.propertyservice.model.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<ReviewModel, Long> {

    //@Query("SELECT * FROM review WHERE property")
    //List<ReviewModel> getAllReviewsOfProperty();
}
