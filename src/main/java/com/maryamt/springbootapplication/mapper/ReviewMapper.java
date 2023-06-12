package com.maryamt.springbootapplication.mapper;


import com.maryamt.springbootapplication.dto.ReviewDTO;
import com.maryamt.springbootapplication.entity.Review;

public class ReviewMapper {
    public static ReviewDTO mapToReviewDto(Review review){
        ReviewDTO reviewDTO= new ReviewDTO(
                review.getReview_id(),
                review.getBook(),
                review.getComment(),
                review.getRating()

        );
        return reviewDTO;
    }

    public static Review mapToReview(ReviewDTO reviewDTO){
        Review review = new Review(
                reviewDTO.getReview_id(),
                reviewDTO.getBook(),
                reviewDTO.getComment(),
                reviewDTO.getRating()
        );
        return review;
    }
}
