package com.maryamt.springbootapplication.service;

import com.maryamt.springbootapplication.dto.ReviewDTO;
import com.maryamt.springbootapplication.entity.Review;
import com.maryamt.springbootapplication.mapper.ReviewMapper;
import com.maryamt.springbootapplication.repository.ReviewRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewRepo reviewRepo;
    @Override
    public ReviewDTO createReview(ReviewDTO reviewDTO) {
        Review review= ReviewMapper.mapToReview(reviewDTO);
        Review savedReview= reviewRepo.save(review);
        return ReviewMapper.mapToReviewDto(review);
    }

    @Override
    public ReviewDTO getReviewById(Long review_id) {
        Optional<Review> optionalReview=reviewRepo.findById(review_id);
        Review review= optionalReview.get();
        return ReviewMapper.mapToReviewDto(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews=reviewRepo.findAll();
        return reviews.stream().map(ReviewMapper::mapToReviewDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDTO updateReview(ReviewDTO reviewDTO) {
        Review review= ReviewMapper.mapToReview(reviewDTO);
        Review existingReview = reviewRepo.findById(review.getReview_id()).get();
        existingReview.setBook(review.getBook());
        existingReview.setComment(review.getComment());
        existingReview.setRating(review.getRating());
        Review updatedReview= reviewRepo.save(existingReview);
        return ReviewMapper.mapToReviewDto(updatedReview);
    }

    @Override
    public void deleteReview(Long review_id) {
        reviewRepo.deleteById(review_id);
    }
}
