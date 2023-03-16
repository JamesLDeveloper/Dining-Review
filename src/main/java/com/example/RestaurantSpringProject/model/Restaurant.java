package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import com.example.RestaurantSpringProject.model.Diner;
import com.example.RestaurantSpringProject.model.DiningReview;
import com.example.RestaurantSpringProject.model.Restaurant;
import com.example.RestaurantSpringProject.model.AdminReviewAction;

@Entity
public class Restaurant {

  @Id
  @GeneratedValue
  @Getter @Setter    private Long id;

  @Getter @Setter private String zipcode;

  @Getter @Setter private String restaurantName;
  @Getter @Setter  private double averagePeanutScore;
    @Getter @Setter  private double averageEggScore;
    @Getter @Setter  private double averageDairyScore;
    @Getter @Setter private double averageOverallScore;

    @Getter @Setter private int numberOfPeanutScores;

  @Getter @Setter private int numberOfDairyScores;

  @Getter @Setter private int numberOfEggScores;

  public Restaurant(){}

    public Restaurant(Long id, String restaurantName, String zipcode, double averagePeanutScore, double averageEggScore, double averageDairyScore, double averageOverallScore, int numberOfPeanutScores, int numberOfDairyScores, int numberOfEggScores){
      this.id = id;
      this.restaurantName = restaurantName;
      this.zipcode = zipcode;
      this.averagePeanutScore = averagePeanutScore;
      this.averageEggScore = averageEggScore;
      this.averageDairyScore = averageDairyScore;
      this.averageOverallScore = averageOverallScore;
      this.numberOfPeanutScores = numberOfPeanutScores;
      this.numberOfDairyScores = numberOfDairyScores;
      this.numberOfEggScores = numberOfEggScores;
    }





    }