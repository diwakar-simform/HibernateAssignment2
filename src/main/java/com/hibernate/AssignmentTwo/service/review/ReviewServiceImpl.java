package com.hibernate.AssignmentTwo.service.review;

import com.hibernate.AssignmentTwo.entities.review.Review;
import com.hibernate.AssignmentTwo.repository.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    ReviewRepo reviewRepo;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Review addReview(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public String deleteReviewById(Long id) {
        String message = "-----Wrong Id------";
        if (id != null && id > 0){
            reviewRepo.deleteById(id);
            message = "-------Item deleted Successfully-----";
        }
        return message;
    }
}
