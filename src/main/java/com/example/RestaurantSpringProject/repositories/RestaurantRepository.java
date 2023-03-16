package com.example.RestaurantSpringProject.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.model.Restaurant;
import com.example.RestaurantSpringProject.model.AdminReviewAction;

import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>{

List<Restaurant> getAllByRestaurantName(String restaurantName);

Optional<Restaurant> getByRestaurantNameAndZipcode(String restaurantName, String zipcode);

Optional<Restaurant> getById(Long id);

//List<Restaurant> getByZipcodeAndAverageEggScoreOrderByAverageEggScoreDesc(String zipcode);
List<Restaurant> getByZipcodeOrderByAverageEggScoreDesc(String zipcode);

//    List<Restaurant>     getByZipcodeAndAverageDairyScoreOrderByAverageDairyScoreDesc(String zipcode);
    List<Restaurant>     getByZipcodeOrderByAverageDairyScoreDesc(String zipcode);

//    List<Restaurant> getByZipcodeAndAveragePeanutScoreOrderByAveragePeanutScoreDesc(String zipcode);
    List<Restaurant> getByZipcodeOrderByAveragePeanutScoreDesc(String zipcode);
    List<Restaurant> getByZipcode(String zipcode);

}