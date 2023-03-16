package com.example.RestaurantSpringProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

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

    public Restaurant(Long id, String restaurantName, String zipcode, double averagePeanutScore, double averageEggScore, double averageDairyScore, double averageOverallScore){
      this.id = id;
      this.restaurantName = restaurantName;
      this.zipcode = zipcode;
      this.averagePeanutScore = averagePeanutScore;
      this.averageEggScore = averageEggScore;
      this.averageDairyScore = averageDairyScore;
      this.averageOverallScore = averageOverallScore;
    }





    }