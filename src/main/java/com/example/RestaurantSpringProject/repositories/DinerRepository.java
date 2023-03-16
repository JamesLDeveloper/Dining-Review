package com.example.RestaurantSpringProject.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.model.Restaurant;
import com.example.RestaurantSpringProject.model.AdminReviewAction;
import org.springframework.data.repository.CrudRepository;

public interface DinerRepository extends CrudRepository<Diner, String> {

Optional<Diner> getByDisplayName(String displayName);





}
