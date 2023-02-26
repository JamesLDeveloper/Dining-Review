package com.example.RestaurantSpringProject.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<RestaurantRepository, String>{


}