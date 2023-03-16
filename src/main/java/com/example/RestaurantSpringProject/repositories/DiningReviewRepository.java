package com.example.RestaurantSpringProject.repositories;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.model.Restaurant;
import com.example.RestaurantSpringProject.model.AdminReviewAction;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {

    Optional<DiningReview> getByReviewerName(String reviewerName);

    List<DiningReview> getAllByReviewStatus(ReviewStatus reviewStatus);

    Optional<DiningReview> getById(Long id);

}
