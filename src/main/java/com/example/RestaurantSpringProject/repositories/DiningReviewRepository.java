package com.example.RestaurantSpringProject.repositories;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.RestaurantSpringProject.model.DiningReview;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
}
