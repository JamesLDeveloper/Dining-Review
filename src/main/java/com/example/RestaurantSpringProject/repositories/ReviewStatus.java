package com.example.RestaurantSpringProject.repositories;

import com.example.RestaurantSpringProject.repositories.DiningReviewRepository;
import com.example.RestaurantSpringProject.repositories.DinerRepository;
import com.example.RestaurantSpringProject.repositories.RestaurantRepository;
import com.example.RestaurantSpringProject.repositories.ReviewStatus;
import org.springframework.data.repository.CrudRepository;


public enum ReviewStatus {

    PENDING, APPROVED, REJECTED

}
