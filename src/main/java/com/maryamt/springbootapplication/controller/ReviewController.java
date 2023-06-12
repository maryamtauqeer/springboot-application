package com.maryamt.springbootapplication.controller;

import com.maryamt.springbootapplication.dto.ReviewDTO;
import com.maryamt.springbootapplication.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> createReview(@RequestBody ReviewDTO reviewDTO){
        ReviewDTO savedReview=reviewService.createReview(reviewDTO);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable("id") Long review_id){
        ReviewDTO reviewDTO=reviewService.getReviewById(review_id);
        return new ResponseEntity<>(reviewDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReviewDTO>> getReview(){
        List<ReviewDTO> reviews=reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable("id")Long review_id, @RequestBody ReviewDTO reviewDTO){
        reviewDTO.setReview_id(review_id);
        ReviewDTO updatedReview =reviewService.updateReview(reviewDTO);
        return new ResponseEntity<>(updatedReview, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteReview(@PathVariable("id")Long id){
        reviewService.deleteReview(id);
        return new ResponseEntity<>("Genre deleted successfully.",HttpStatus.OK);
    }
}
