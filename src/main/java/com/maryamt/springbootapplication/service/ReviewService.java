package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewDTO reviewDTO);

    ReviewDTO getReviewById(Long review_id);

    List<ReviewDTO> getAllReviews();

    ReviewDTO updateReview(ReviewDTO reviewDTO);

    void deleteReview(Long review_id);
}
