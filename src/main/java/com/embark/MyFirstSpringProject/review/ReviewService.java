package com.embark.MyFirstSpringProject.review;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReviewById(Long companyId, Long reviewId);
    boolean updateReviewById(Long companyId, Long reviewId,Review review);
    boolean deleteReviewById(Long companyId, Long reviewId);
}
