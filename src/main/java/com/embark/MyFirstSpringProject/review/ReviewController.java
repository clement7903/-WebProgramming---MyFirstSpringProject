package com.embark.MyFirstSpringProject.review;

import com.embark.MyFirstSpringProject.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId,
                                            @RequestBody Review review){
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved){
            return new ResponseEntity<>("Review added successfully",
                    HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review not added",
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReviewById(companyId, reviewId), HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId,
                                                   @RequestBody Review review){
        boolean isReviewUpdated = reviewService.updateReviewById(companyId, reviewId, review);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review updated successfully", HttpStatus.OK);
        } else{
            return new ResponseEntity<>("Review not updated",
                    HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Long companyId,
                                                   @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReviewById(companyId, reviewId);
        if (isReviewDeleted){
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review not deleted",
                    HttpStatus.NOT_FOUND);
        }
    }
}
