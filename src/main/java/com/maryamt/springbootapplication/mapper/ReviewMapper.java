package com.maryamt.springbootapplication.mapper;


import com.maryamt.springbootapplication.dto.BookDTO;
import com.maryamt.springbootapplication.dto.ReviewDTO;
import com.maryamt.springbootapplication.entity.Book;
import com.maryamt.springbootapplication.entity.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {
    public static ReviewDTO mapToReviewDto(Review review){
        ReviewDTO reviewDTO= new ReviewDTO(
                review.getReview_id(),
                BookMapper.mapToBookDto(review.getBook()),
//                review.getBook(),
                review.getComment(),
                review.getRating()

        );
        return reviewDTO;
    }

    public static Review mapToReview(ReviewDTO reviewDTO){
        Review review = new Review(
                reviewDTO.getReview_id(),
                BookMapper.mapToBook(reviewDTO.getBook()),
//                reviewDTO.getBook(),
                reviewDTO.getComment(),
                reviewDTO.getRating()
        );
        return review;
    }

    public static List<Review> mapToReviewsList(List<ReviewDTO> reviewDTOS) {
        List<Review> reviews = new ArrayList<>();
        for (ReviewDTO reviewDTO : reviewDTOS) {
            reviews.add(mapToReview(reviewDTO));
        }
        return reviews;
    }

    public static List<ReviewDTO> mapToReviewDTOsList(List<Review> reviews) {
        List<ReviewDTO> reviewDTOS = new ArrayList<>();
        for (Review review : reviews) {
            reviewDTOS.add(mapToReviewDto(review));
        }
        return reviewDTOS;
    }
}
