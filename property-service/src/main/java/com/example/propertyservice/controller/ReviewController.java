package com.example.propertyservice.controller;

import com.example.propertyservice.model.GenericResponse;
import com.example.propertyservice.model.ReviewModel;
import com.example.propertyservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping("")
    public ResponseEntity<GenericResponse> insertReview(@RequestHeader Long bookingId, @RequestBody ReviewModel newReview) {

        return ResponseEntity.ok(service.insertReview(bookingId, newReview));
    }
}
